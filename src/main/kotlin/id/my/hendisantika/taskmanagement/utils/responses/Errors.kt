package id.my.hendisantika.taskmanagement.utils.responses

import org.springframework.http.HttpStatus

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
open class ErrorResponse(val statusCode: Int, open val errors: Map<String, *>)

data class BadRequestResponse<T : Any>(override val errors: Map<String, T>) :
    ErrorResponse(HttpStatus.BAD_REQUEST.value(), errors)

data class UnAuthorizedResponse<T : Any>(override val errors: Map<String, T>) :
    ErrorResponse(HttpStatus.UNAUTHORIZED.value(), errors)
