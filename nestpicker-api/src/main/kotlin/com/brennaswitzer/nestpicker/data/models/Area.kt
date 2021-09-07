package com.brennaswitzer.nestpicker.data.models

open class Area(
    val id: Int,
    val name: String
) {
    private val facets: MutableMap<Facet, Any?> = mutableMapOf()

    fun setFacetValues(facet: Facet, value: Any?) {
        val typedValue = when (facet.dataType) {
            DataType.INTEGER -> value as Int
            DataType.STRING -> value.toString()
        }
        facets[facet] = typedValue
    }

    fun getFacetValues(): Map<Facet, Any?> {
        return facets.toMap()
    }
}
