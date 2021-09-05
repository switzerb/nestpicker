package com.brennaswitzer.nestpicker.data

import io.micronaut.context.annotation.Factory
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.jetbrains.exposed.sql.Database
import javax.sql.DataSource

@Factory
class DatabaseFactory {

    @Inject
    lateinit var dataSource: DataSource

    @Singleton
    fun database(): Database {
        return Database.connect(dataSource)
    }
}
