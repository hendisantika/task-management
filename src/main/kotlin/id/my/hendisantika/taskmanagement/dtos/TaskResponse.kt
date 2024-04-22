package id.my.hendisantika.taskmanagement.dtos

import java.time.Instant
import java.time.LocalDate

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
data class TaskResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val dueDate: LocalDate,
    val status: TaskStatus,
    val createdBy: Long,
    val updatedBy: Long,
    val createdAt: Instant,
    val updatedAt: Instant,
)
