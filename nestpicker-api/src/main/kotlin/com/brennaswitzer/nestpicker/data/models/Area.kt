package com.brennaswitzer.nestpicker.data.models

class Area(
    val id: Int,
    val name: String
) {
    private val facets: MutableMap<Facet, Any?> = mutableMapOf()

    fun setFacetValue(facet: Facet, value: Any?): Map<Facet, Any?> {
        val typedValue = when (facet.dataType) {
            DataType.INTEGER -> value as Int
            DataType.STRING -> value.toString()
        }
        facets[facet] = typedValue
        return facets.toMap()
    }
}
