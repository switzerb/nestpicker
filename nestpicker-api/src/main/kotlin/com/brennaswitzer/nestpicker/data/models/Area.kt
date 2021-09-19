package com.brennaswitzer.nestpicker.data.models

open class Area(
    val id: Int,
    val name: String
) {
    private val facets: MutableMap<Facet<*>, Any?> = mutableMapOf()

//    @Suppress("UNCHECKED_CAST")
//    fun <T> getFacetScore(facet: Facet<T>): Score {
//        return facet.getFacetScore(facets[facet] as T)
//    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getFacetValue(facet: Facet<T>): T {
        if (facets[facet] == null) {
            throw UnsupportedOperationException()
        }
        return facets[facet] as T
    }

    fun <T> setFacetValue(facet: Facet<T>, value: T?) {
        facets[facet] = value
    }

    fun hasFacetValue(facet: Facet<*>): Boolean {
        return facets[facet] != null
    }

    override fun toString(): String {
        return name.toString()
    }
}
