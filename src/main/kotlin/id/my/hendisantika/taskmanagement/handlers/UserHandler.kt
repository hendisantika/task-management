package id.my.hendisantika.taskmanagement.handlers

import id.my.hendisantika.taskmanagement.dtos.CreateUserRequest
import id.my.hendisantika.taskmanagement.dtos.UpdateUserRequest
import id.my.hendisantika.taskmanagement.dtos.UserPasswordRequest
import id.my.hendisantika.taskmanagement.entities.User
import id.my.hendisantika.taskmanagement.services.UserService
import id.my.hendisantika.taskmanagement.utils.requests.getPathId
import id.my.hendisantika.taskmanagement.utils.responses.BadRequestResponse
import id.my.hendisantika.taskmanagement.utils.responses.responseNotFound
import id.my.hendisantika.taskmanagement.utils.then
import id.my.hendisantika.taskmanagement.utils.validations.entryMapErrors
import jakarta.validation.Validator
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import org.apache.logging.log4j.LogManager
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/23/24
 * Time: 06:54
 * To change this template use File | Settings | File Templates.
 */
@Component
class UserHandler(private val service: UserService, private val validator: Validator) {
    private val log = LogManager.getLogger(UserHandler::class.java)

    private val userResponseNotFound = responseNotFound(User::class, UserHandler::class)

    suspend fun all(request: ServerRequest) =
        ServerResponse.ok().bodyAndAwait(service.all().map(User::toUserResponse).asFlow())

    suspend fun byId(request: ServerRequest): ServerResponse {
        val id = getPathId(request)

        return service.byId(id)
            .flatMap { ServerResponse.ok().bodyValue(it.toUserResponse()) }
            .switchIfEmpty { userResponseNotFound(id) }.awaitSingle()
    }

    suspend fun create(request: ServerRequest): ServerResponse {
        return request.bodyToMono(CreateUserRequest::class.java)
            .flatMap(::doCreate).awaitSingle()
    }

    suspend fun update(request: ServerRequest): ServerResponse {
        val id = getPathId(request)
        return request.bodyToMono<UpdateUserRequest>()
            .flatMap(doUpdate(id)).awaitSingle()
    }

    suspend fun changePassword(request: ServerRequest): ServerResponse {
        val id = getPathId(request)
        return request.bodyToMono<UserPasswordRequest>()
            .flatMap(doChangePassword(id)).awaitSingle()
    }

    suspend fun deleteById(request: ServerRequest): ServerResponse {
        val id = getPathId(request)

        return service.deleteById(id)
            .flatMap { ServerResponse.noContent().build() }
            .switchIfEmpty {
                log.info("User with ID {} does not exist", id)
                ServerResponse.noContent().build()
            }.awaitSingle()
    }

    private fun doCreate(body: CreateUserRequest): Mono<ServerResponse> {
        val violations = validator.validate(body)

        return if (violations.isEmpty()) {
            fun bodyToUser(body: CreateUserRequest) = User.fromCreateUserRequest(body)
            fun createUserAndMapResp(user: User) = service.create(user).map(User::toUserResponse)
            val createUserResponse = ::bodyToUser then ::createUserAndMapResp
            ServerResponse.status(HttpStatus.CREATED).body(createUserResponse(body))
        } else {
            val badRequestResp = BadRequestResponse(entryMapErrors(violations))
            ServerResponse.badRequest().bodyValue(badRequestResp)
        }
    }

    private fun doUpdate(id: Long) = { body: UpdateUserRequest ->
        val violations = validator.validate(body)
        if (violations.isEmpty()) {
            fun bodyToUser(body: UpdateUserRequest) = User.fromUpdateUserRequest(body)
            fun updateUserAndMapResp(id: Long) = { user: User ->
                service.update(id)(user)
                    .map(User::toUserResponse)
            }

            val updateUserResponse = ::bodyToUser then updateUserAndMapResp(id)
            updateUserResponse(body)
                .flatMap(ServerResponse.ok()::bodyValue)
                .switchIfEmpty { userResponseNotFound(id) }
        } else {
            val badRequestResp = BadRequestResponse(entryMapErrors(violations))
            ServerResponse.badRequest().bodyValue(badRequestResp)
        }
    }
}
