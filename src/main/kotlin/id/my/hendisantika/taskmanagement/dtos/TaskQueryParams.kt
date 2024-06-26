package id.my.hendisantika.taskmanagement.dtos

import id.my.hendisantika.taskmanagement.entities.TaskStatus
import java.time.LocalDate

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
data class TaskQueryParams(
    val dueDate: LocalDate? = null,
    val status: TaskStatus? = null,
    val createdBy: Long? = null,
    val updatedBy: Long? = null
)

data class TaskQueryParamValues(
    val dueDates: List<LocalDate>?,
    val statuses: List<TaskStatus>?,
    val createdByUsers: List<Long>?,
    val updatedByUsers: List<Long>?,
)

