package id.my.hendisantika.taskmanagement.utils.requests

import org.springframework.web.reactive.function.server.ServerRequest

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
fun getPathId(request: ServerRequest): Long = request.pathVariable("id").toLong()
