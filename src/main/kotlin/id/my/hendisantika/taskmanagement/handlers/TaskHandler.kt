package id.my.hendisantika.taskmanagement.handlers

import id.my.hendisantika.taskmanagement.dtos.TaskQueryParamValues
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
 * Date: 4/22/24
 * Time: 10:50
 * To change this template use File | Settings | File Templates.
 */
@Component
class TaskHandler(
    private val service: TaskService,
    private val userService: UserService,
    private val validator: Validator,
) {
    private val log = LogManager.getLogger(TaskHandler::class.java)
    private val taskRespNotFound = responseNotFound(Task::class, TaskHandler::class)

    suspend fun all(request: ServerRequest): ServerResponse {
        val queryParams = request.queryParams()
        val getRequestParamValues = getQueryParamValues(queryParams)
        val getIdsFromQueryParams = getRequestParamValues then ::toLongs

        val taskQueryParams = TaskQueryParamValues(
            dueDates = (getRequestParamValues then ::toLocalDates)("due-date"),
            statuses = (getRequestParamValues then ::toStatuses)("status"),
            createdByUsers = getIdsFromQueryParams("created-by"),
            updatedByUsers = getIdsFromQueryParams("updated-by"),
        )

        val fetchedTasks =
            if (queryParams.isEmpty()) service.all()
            else service.allByQueryParams(taskQueryParams)

        return ServerResponse.ok().bodyAndAwait(fetchedTasks.map(Task::toTaskResponse).asFlow())
    }

}
