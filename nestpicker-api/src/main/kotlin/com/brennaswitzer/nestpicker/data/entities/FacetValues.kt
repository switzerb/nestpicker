package com.brennaswitzer.nestpicker.data.entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object FacetValues : IntIdTable() {
    val facet = reference("facet", Facets)
    val location = reference("location", Locations)
    val value = varchar("value", 255)
    override val primaryKey = PrimaryKey(facet, location, name = "PK_facet_location_value")
}

class FacetValue(id: EntityID<Int>) : IntEntity(id) {
    var facet by Facet referencedOn FacetValues.facet
    var location by Location referencedOn FacetValues.location
    var value by FacetValues.value
}
