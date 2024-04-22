package id.my.hendisantika.taskmanagement.services

import id.my.hendisantika.taskmanagement.entities.Task
import id.my.hendisantika.taskmanagement.repositories.TaskRepository
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
@Service
class TaskService(private val repository: TaskRepository) : BaseService<Task, Long> {
    private val log = LogManager.getLogger(TaskService::class)
}
