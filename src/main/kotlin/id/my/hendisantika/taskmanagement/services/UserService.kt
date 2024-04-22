package id.my.hendisantika.taskmanagement.services

import id.my.hendisantika.taskmanagement.entities.User
import id.my.hendisantika.taskmanagement.repositories.UserRepository
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
@Service
class UserService(private val repository: UserRepository) : BaseService<User, Long> {
    private val log = LogManager.getLogger(UserService::class)

    override fun all(): Flux<User> = repository.findAll()

    override fun byId(id: Long): Mono<User> = repository.findById(id)

    override fun create(user: User): Mono<User> = repository.save(user)

}
