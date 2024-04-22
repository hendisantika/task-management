package id.my.hendisantika.taskmanagement.services

import id.my.hendisantika.taskmanagement.dtos.TaskQueryParamValues
import id.my.hendisantika.taskmanagement.entities.Task
import id.my.hendisantika.taskmanagement.repositories.TaskRepository
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
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
@Service
class TaskService(private val repository: TaskRepository) : BaseService<Task, Long> {
    private val log = LogManager.getLogger(TaskService::class)

    override fun all(): Flux<Task> = repository.findAll()
    /*.delayElements(Duration.ofMillis(300))*/

    override fun byId(id: Long): Mono<Task> = repository.findById(id)

    override fun create(task: Task): Mono<Task> {
        return repository.save(task)
    }

    override fun update(id: Long) = { task: Task ->
        repository.save(task)
    }

    override fun deleteById(id: Long): Mono<Void> {
        return repository.deleteById(id)
    }

    fun allByQueryParams(queryParams: TaskQueryParamValues): Flux<Task> {
        val (dueDates, statuses, createdBy, updatedBy) = queryParams

        return repository.findAllByConditions(
            defaultFirstLong(createdBy),
            defaultFirstLong(updatedBy),
            defaultFirstItem(::firstItemLocalDate)(dueDates),
            defaultFirstItem(::firstItemStatus)(statuses),
            createdByIsNull = createdBy.isNullOrEmpty(),
            updatedByIsNull = updatedBy.isNullOrEmpty(),
            dueDatesIsNull = dueDates.isNullOrEmpty(),
            statusesIsNull = statuses.isNullOrEmpty(),
        )
    }

    val copyToUpdate: (Task) -> (Task) -> Task = { existingTask ->
        { task ->
            task.copy(
                id = existingTask.id,
                version = existingTask.version,
                createdAt = existingTask.createdAt,
                updatedAt = existingTask.updatedAt,
                createdBy = existingTask.createdBy
            )
        }
    }
}
