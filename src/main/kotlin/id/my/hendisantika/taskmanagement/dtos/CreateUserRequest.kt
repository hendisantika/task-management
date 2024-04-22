package id.my.hendisantika.taskmanagement.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
data class CreateUserRequest(
    @field:Email(message = "email format must be correct (eg. email@example.com)")
    val email: String,

    // TODO: Hash Password
    @field:NotBlank(message = "password must not be empty")
    @field:Size(min = 6, message = "password must be [6] characters or more")
    val password: String,

    @field:NotBlank(message = "firstName must not be empty")
    @field:Size(min = 2, message = "firstName must be [2] characters or more")
    val firstName: String,

    @field:NotBlank(message = "lastName must not be empty")
    @field:Size(min = 2, message = "lastName must be [2] characters or more")
    val lastName: String,
)

data class UpdateUserRequest(
    @field:Email(message = "email format must be correct (eg. email@example.com)")
    val email: String,

    @field:NotBlank(message = "firstName must not be empty")
    @field:Size(min = 2, message = "firstName must be [2] characters or more")
    val firstName: String,

    @field:NotBlank(message = "lastName must not be empty")
    @field:Size(min = 2, message = "lastName must be [2] characters or more")
    val lastName: String,
)

data class UserPasswordRequest(
    @field:NotBlank(message = "password must not be empty")
    @field:Size(min = 6, message = "password must be [6] characters or more")
    val password: String,
)
