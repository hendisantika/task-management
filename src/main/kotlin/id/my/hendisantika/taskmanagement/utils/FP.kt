package id.my.hendisantika.taskmanagement.utils

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
/**
 * Use like `compose`, but reversed
 * ```txt
 * g(f(x)) ≡ (g ∘ f)(x)
 *   f     :: A → B
 *   g     :: B → C
 * ∴ g ∘ f :: A → C
 * (g ∘ f pronounced "g compose f" OR "g after f")
 * ```
 * **Usage:**
 * ```kt
 * val f: (Int) -> Int = { x -> x + 10 }
 * val g: (Int) -> Int = { x -> x + 2 }
 * val x = 5
 * val composedFunc = f then g
 * println(composedFunc(x)) // 17
 * ```
 */
infix fun <A1, A2, R> ((A1) -> A2).then(g: (A2) -> R): (A1) -> R = { x ->
    val f = this
    g(f(x))
}
