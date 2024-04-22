package id.my.hendisantika.taskmanagement.repositories

import id.my.hendisantika.taskmanagement.entities.Task
import id.my.hendisantika.taskmanagement.entities.TaskStatus
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.query.Param
import reactor.core.publisher.Flux
import java.time.LocalDate

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
interface TaskRepository : R2dbcRepository<Task, Long> {
    @Query(
        """
    SELECT * FROM tasks
          /* :createdBy IS NULL */
    WHERE (:createdbyisnull OR created_by IN (:createdby))
          /* :updatedBy IS NULL */
      AND (:updatedbyisnull OR updated_by IN (:updatedby))
          /* :dueDate IS NULL */
      AND (:duedatesisnull OR due_date IN (:duedates))
          /* :status IS NULL */
      AND (:statusesisnull OR status IN (COALESCE(:statuses, 'PENDING')))
    """
    )
    fun findAllByConditions(
        @Param("createdBy") createdBy: List<Long>,
        @Param("updatedBy") updatedBy: List<Long>,
        @Param("dueDates") dueDates: List<LocalDate>,
        @Param("statuses") statuses: List<TaskStatus>,
        /**```kt
         * queryParams.createdByUsers.isNullOrEmpty()
         * ```
         */
        createdByIsNull: Boolean,
        /**```kt
         * queryParams.updatedByUsers.isNullOrEmpty()
         * ```
         */
        updatedByIsNull: Boolean,
        /**```kt
         * queryParams.dueDates.isNullOrEmpty()
         * ```
         */
        dueDatesIsNull: Boolean,
        /**```kt
         * queryParams.statuses.isNullOrEmpty()
         * ```
         */
        statusesIsNull: Boolean,
    ): Flux<Task>
}
