package id.my.hendisantika.taskmanagement.dtos

import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.Size
import java.time.LocalDate

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
data class TaskRequest(
    @field:Size(min = 3, message = "title must be [3] characters or more")
    @field:NotBlank(message = "title must not be empty")
    val title: String,

    val description: String?,

    @field:FutureOrPresent(message = "dueDate must not be in the past")
    @field:NotNull(message = "dueDate must not be empty")
    val dueDate: LocalDate,

    // TODO: Use enum as a type
    // @Column(converter = TaskStatusConverter::class.java)
    // val status: TaskStatus,
    @field:NotNull(message = "status must not be empty")
    val status: TaskStatus,

    @field:NotNull(message = "userId must not be empty")
    val userId: Long,
)

