package id.my.hendisantika.taskmanagement.dtos

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

