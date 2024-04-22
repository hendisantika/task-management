package id.my.hendisantika.taskmanagement.router

import id.my.hendisantika.taskmanagement.handlers.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/23/24
 * Time: 06:58
 * To change this template use File | Settings | File Templates.
 */
@Configuration
class UserRouter(private val handler: UserHandler) {
    @Bean
    fun userRoutes(): RouterFunction<ServerResponse> = coRouter {
        "/users".nest {
            GET("", handler::all)
            GET("/{id}", handler::byId)
            POST("", handler::create)
            PUT("/{id}", handler::update)
            PATCH("/{id}", handler::changePassword)
            DELETE("/{id}", handler::deleteById)
        }
    }
}
