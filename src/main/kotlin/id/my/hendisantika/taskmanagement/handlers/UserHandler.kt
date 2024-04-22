package id.my.hendisantika.taskmanagement.handlers

import id.my.hendisantika.taskmanagement.entities.User
import id.my.hendisantika.taskmanagement.services.UserService
import id.my.hendisantika.taskmanagement.utils.responses.responseNotFound
import jakarta.validation.Validator
import kotlinx.coroutines.reactive.asFlow
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait

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

}
