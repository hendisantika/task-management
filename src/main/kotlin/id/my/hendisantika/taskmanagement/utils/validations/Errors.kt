package id.my.hendisantika.taskmanagement.utils.validations

import jakarta.validation.ConstraintViolation

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 */
fun <T> joinToJsonError(violations: Set<ConstraintViolation<T>>): String =
    "{ ${
        violations.joinToString(", ", transform = keyValEachViolation)
    } }"
