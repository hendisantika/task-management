package id.my.hendisantika.taskmanagement.entities

import id.my.hendisantika.taskmanagement.dtos.CreateUserRequest
import id.my.hendisantika.taskmanagement.dtos.UpdateUserRequest
import id.my.hendisantika.taskmanagement.dtos.UserPasswordRequest
import id.my.hendisantika.taskmanagement.dtos.UserResponse
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:46
 * To change this template use File | Settings | File Templates.
 */

@Table("users")
data class User(
    @Id override val id: Long? = null,

    val email: String? = null,

    // TODO: Hash Password
    val password: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,

    @CreatedDate
    override val createdAt: Instant? = null,

    @LastModifiedDate
    override val updatedAt: Instant? = null,

    /** Start with version 0 when created */
    @Version
    override val version: Int? = null,
) : BaseEntity(id) {
    companion object {
        fun fromCreateUserRequest(body: CreateUserRequest): User = User(
            email = body.email,
            password = body.password,
            firstName = body.firstName,
            lastName = body.lastName,
        )

        fun fromUpdateUserRequest(body: UpdateUserRequest): User = User(
            email = body.email,
            firstName = body.firstName,
            lastName = body.lastName,
        )

        fun fromChangePasswordRequest(body: UserPasswordRequest): User = User(
            password = body.password
        )
    }

    fun toUserResponse(): UserResponse = UserResponse(
        id = id!!,
        email = email.orEmpty(),
        firstName = firstName.orEmpty(),
        lastName = lastName.orEmpty(),
        createdAt = createdAt!!,
        updatedAt = updatedAt!!,
    )
}
