package id.my.hendisantika.taskmanagement.services

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:59
 * To change this template use File | Settings | File Templates.
 */
interface BaseService<T, ID> {
    fun all(): Flux<T>
    fun byId(id: ID): Mono<T>
    fun create(item: T): Mono<T>
    fun update(id: ID): (item: T) -> Mono<T>
    fun deleteById(id: Long): Mono<Void>
}
