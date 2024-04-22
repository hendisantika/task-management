package id.my.hendisantika.taskmanagement.utils.responses

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
