package com.brennaswitzer.nestpicker.data.entities

import com.brennaswitzer.nestpicker.data.models.DataType
import com.brennaswitzer.nestpicker.data.models.Scorer
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Facets : IntIdTable() {
    val name = varchar("name", 255)
    val dataType = enumerationByName("DataType", 25, DataType::class)
    override val primaryKey = PrimaryKey(id, name = "PK_Facet_Id")
}

class Facet(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Facet>(Facets)

//    var scorer: Scorer<*>? = null
    var name by Facets.name
    var dataType by Facets.dataType
}
