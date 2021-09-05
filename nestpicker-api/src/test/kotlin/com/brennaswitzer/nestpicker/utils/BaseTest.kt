package com.brennaswitzer.nestpicker.utils

import com.brennaswitzer.nestpicker.data.entities.*
import com.brennaswitzer.nestpicker.data.models.DataType
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
            SchemaUtils.create(
                Locations,
                Facets,
                FacetValues
            )
        }
    }

    fun Location.Companion.insert(
        name: String = "Tuscany"
    ) : Location {
        return transaction {
            Location.new {
                this.name = name
            }
        }
    }

    fun Facet.Companion.insert(
        name: String = "Avg Summer Temp",
        dataType: DataType = DataType.INTEGER
    ) : Facet {
        return transaction {
            Facet.new {
                this.name = name
                this.dataType = dataType
            }
        }
    }

}
