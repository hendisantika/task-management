package id.my.hendisantika.taskmanagement.utils.convertions

import java.time.LocalDate

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:53
 * To change this template use File | Settings | File Templates.
 */
/**
 * @return the LocalDate value
 * @throws IllegalArgumentException
 *
 * ```kt
 * "YYYY-MM-dd".toLocalDate()
 * ```
 */
fun String.toLocalDate(/*dateStr: String*/): LocalDate {
    val ymd = this.split("-").stream().filter(String::isNotBlank).map(String::toInt).toList()

    return if (ymd.size == 3) {
        val (y, m, d) = ymd
        LocalDate.of(y, m, d)
    } else {
        throw IllegalArgumentException("[«field»] format should be [«date_pattern»]")
    }
}
