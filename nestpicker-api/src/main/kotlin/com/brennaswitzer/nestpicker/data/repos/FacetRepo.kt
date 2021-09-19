package com.brennaswitzer.nestpicker.data.repos

import com.brennaswitzer.nestpicker.data.models.*
import jakarta.inject.Singleton

@Singleton
class FacetRepo {

    private val facets = mutableListOf<FacetBase<*, *>>()

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

    fun createAggregateFacet(
        name: String,
        scorer: Scorer<List<Score>>
    ): AggregateFacet {
        val newAggregateFacet = AggregateFacet(
            id = getNextId(),
            name = name,
            scorer = scorer
        )
        facets.add(newAggregateFacet)
        return newAggregateFacet
    }

    private fun getNextId(): Int = facets.size + 1
}
