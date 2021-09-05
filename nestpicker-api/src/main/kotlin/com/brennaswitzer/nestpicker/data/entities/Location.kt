package com.brennaswitzer.nestpicker.data.entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Locations : IntIdTable() {
    val name = varchar("name", 255)
    override val primaryKey = PrimaryKey(id, name = "PK_Locations_Id")
}

class Location(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Location>(Locations)
    var name by Locations.name

    val facets: MutableMap<Facet, Any?> = mutableMapOf<Facet, Any?>()
}
