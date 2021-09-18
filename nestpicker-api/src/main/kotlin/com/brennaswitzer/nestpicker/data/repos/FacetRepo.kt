package com.brennaswitzer.nestpicker.data.repos

import com.brennaswitzer.nestpicker.data.models.*
import jakarta.inject.Singleton

@Singleton
class FacetRepo {

    private val facets = mutableListOf<Facet<*>>()

    fun <T> createFacet(
        name: String,
        dataType: DataType,
        scorer: Scorer<T>
    ): Facet<T> {
        val newFacet = Facet(
            id = getNextId(),
            name = name,
            dataType = dataType,
            scorer = scorer
        )
        facets.add(newFacet)
        return newFacet
    }

    fun <T> createAggregateFacet(
        name: String,
        dataType: DataType,
        scorer: Scorer<T>
    ): Facet<T> {
        val newAggregateFacet = Facet(
            id = getNextId(),
            name = name,
            dataType = dataType,
            scorer = scorer
        )
        facets.add(newAggregateFacet)
        return newAggregateFacet
    }

    private fun getNextId(): Int = facets.size + 1
}
