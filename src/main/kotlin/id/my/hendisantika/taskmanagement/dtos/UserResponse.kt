package id.my.hendisantika.taskmanagement.dtos

import java.time.Instant

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
data class UserResponse(
    val id: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
    val createdAt: Instant,
    val updatedAt: Instant,
)
