package id.my.hendisantika.taskmanagement.repositories

import id.my.hendisantika.taskmanagement.entities.User
import org.springframework.data.r2dbc.repository.R2dbcRepository

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:49
 * To change this template use File | Settings | File Templates.
 */
interface UserRepository : R2dbcRepository<User, Long>
