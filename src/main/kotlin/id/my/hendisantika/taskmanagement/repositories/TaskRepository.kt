package id.my.hendisantika.taskmanagement.repositories

import id.my.hendisantika.taskmanagement.entities.Task
import org.springframework.data.r2dbc.repository.R2dbcRepository

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:48
 * To change this template use File | Settings | File Templates.
 */
interface TaskRepository : R2dbcRepository<Task, Long>
