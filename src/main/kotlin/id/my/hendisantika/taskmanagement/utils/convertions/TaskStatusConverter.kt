package id.my.hendisantika.taskmanagement.utils.convertions

import id.my.hendisantika.taskmanagement.entities.TaskStatus
import org.springframework.core.convert.converter.Converter

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:54
 * To change this template use File | Settings | File Templates.
 */
class TaskStatusConverter : Converter<TaskStatus, String> {
    override fun convert(source: TaskStatus): String {
        return source.name
    }

    fun convertReversed(target: String): TaskStatus {
        return TaskStatus.valueOf(target)
    }
}
