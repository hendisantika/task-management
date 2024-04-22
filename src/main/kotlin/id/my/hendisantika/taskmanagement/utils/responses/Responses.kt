package id.my.hendisantika.taskmanagement.utils.responses

import org.apache.logging.log4j.LogManager
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import kotlin.reflect.KClass

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
typealias Id = Long

fun responseNotFound(clazz: KClass<*>, logClass: KClass<*>): (Id) -> Mono<ServerResponse> {
    val log = LogManager.getLogger(logClass.java)

    return { id ->
        val errorMessage = "[${clazz.simpleName}] with ID [{}] does not exist"
        val badRequestResp = BadRequestResponse(mapOf("message" to errorMessage.replace("{}", id.toString())))
        log.error(errorMessage, id)
        ServerResponse.status(HttpStatus.NOT_FOUND).bodyValue(badRequestResp)
    }
}
