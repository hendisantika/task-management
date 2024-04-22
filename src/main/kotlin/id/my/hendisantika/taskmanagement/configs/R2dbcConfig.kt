package id.my.hendisantika.taskmanagement.configs

import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing

/**
 * Created by IntelliJ IDEA.
 * Project : task-management
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/22/24
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableR2dbcAuditing // Make it PrePersist / PreUpdate for createdAt/updatedAt
class R2dbcConfig
