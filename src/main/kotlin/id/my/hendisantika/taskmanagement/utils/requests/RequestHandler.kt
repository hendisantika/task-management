package id.my.hendisantika.taskmanagement.utils.requests

import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.server.ServerRequest
import kotlin.jvm.optionals.getOrNull

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

private typealias QueryParam = String

fun getQueryParam(request: ServerRequest): (QueryParam) -> String? {
    return { param ->
        request.queryParam(param).getOrNull()
    }
}

fun getQueryParamValues(queryParams: MultiValueMap<String, String>): (QueryParam) -> List<String> {
    return { param ->
        queryParams[param].orEmpty()
    }
}
