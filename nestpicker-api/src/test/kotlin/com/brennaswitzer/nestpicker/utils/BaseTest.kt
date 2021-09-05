package com.brennaswitzer.nestpicker.utils

import com.brennaswitzer.nestpicker.data.entities.Locations
import io.kotest.core.spec.style.AnnotationSpec
import jakarta.inject.Inject
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

abstract class BaseTest : AnnotationSpec() {

    @Inject
    lateinit var database: Database

    @Before
    fun init() {
        transaction {
            SchemaUtils.create(Locations)
        }
    }
}
