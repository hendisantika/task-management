package id.my.hendisantika.taskmanagement.handlers

import id.my.hendisantika.taskmanagement.services.UserService
import jakarta.validation.Validator
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Component

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/23/24
 * Time: 06:54
 * To change this template use File | Settings | File Templates.
 */
@Component
class UserHandler(private val service: UserService, private val validator: Validator) {
    private val log = LogManager.getLogger(UserHandler::class.java)

}
