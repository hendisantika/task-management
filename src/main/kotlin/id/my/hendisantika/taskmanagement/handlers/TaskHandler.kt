package id.my.hendisantika.taskmanagement.handlers

import org.springframework.stereotype.Component

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

}
