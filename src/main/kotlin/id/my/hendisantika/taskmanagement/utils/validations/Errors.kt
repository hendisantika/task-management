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

fun <T : Any> entryMapErrors(violations: Set<ConstraintViolation<T>>): Map<String, String> =
    violations.associateBy(getViolationProperty, getViolationMessage)

private val keyValEachViolation: (ConstraintViolation<*>) -> String = { violation ->
    "\"${violation.propertyPath}\": \"${violation.message}\""
}

private val getViolationProperty: (ConstraintViolation<*>) -> String = { it.propertyPath.toString() }

private val getViolationMessage: (ConstraintViolation<*>) -> String = { it.message }
