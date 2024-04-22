package id.my.hendisantika.taskmanagement.entities

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
//open class BaseEntity(open val id: Long? = null) {
abstract class BaseEntity(open val id: Long? = null) {
    /**
     * ```kt
     * @CreatedDate
     * override val createdAt: Instant? = null
     * ```
     */
    abstract val createdAt: Instant?

    /**
     * ```kt
     * @LastModifiedDate
     * override val updatedAt: Instant? = null,
     * ```
     */
    abstract val updatedAt: Instant?

    /**
     * ```kt
     * @Version
     * override val version: Int? = 1,
     * ```
     */
    abstract val version: Int?
}
