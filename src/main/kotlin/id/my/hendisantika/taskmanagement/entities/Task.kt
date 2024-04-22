package id.my.hendisantika.taskmanagement.entities

import id.my.hendisantika.taskmanagement.dtos.TaskRequest
import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.time.LocalDate

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:43
 * To change this template use File | Settings | File Templates.
 */
@Table("tasks")
data class Task(
    @Id
    override val id: Long? = null,

    val title: String,
    val description: String?,
    val dueDate: LocalDate,
    val status: TaskStatus,

    @CreatedBy
    @Reference(User::class)
    val createdBy: Long? = null,

    @LastModifiedBy
    @Reference(User::class)
    val updatedBy: Long? = null,

    @CreatedDate
    override val createdAt: Instant? = null,

    @LastModifiedDate
    override val updatedAt: Instant? = null,

    /** Start with version 0 when created */
    @Version
    override val version: Int? = null,
) : BaseEntity(id) {
    companion object {
        fun fromTaskRequest(body: TaskRequest): Task =
            Task(
                title = body.title,
                description = body.description,
                dueDate = body.dueDate,
                status = body.status,
                createdBy = body.userId,
                updatedBy = body.userId,
            )

        fun fromUpdateTaskRequest(body: TaskRequest): Task =
            Task(
                title = body.title,
                description = body.description,
                dueDate = body.dueDate,
                status = body.status,
                updatedBy = body.userId,
            )

    }
}
