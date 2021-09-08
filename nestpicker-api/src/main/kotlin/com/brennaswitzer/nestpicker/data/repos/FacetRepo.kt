package com.brennaswitzer.nestpicker.data.repos

import com.brennaswitzer.nestpicker.data.models.DataType
import com.brennaswitzer.nestpicker.data.models.Facet
import com.brennaswitzer.nestpicker.data.models.NumberScorer
import com.brennaswitzer.nestpicker.data.models.Scorer
import jakarta.inject.Singleton

@Singleton
class FacetRepo {

    val costOfLiving = Facet(
        id = 1,
        name = "Cost of Living",
        dataType = DataType.INTEGER,
        scorer = NumberScorer { n -> n * 10 }
    )

    private val facets = mutableListOf<Facet>(
        costOfLiving
    )

    fun getById(id: Int): Facet {
        return costOfLiving
    }

    fun getFacets(): List<Facet> {
        return facets.toList()
    }

    fun createFacet(
        name: String,
        dataType: DataType,
        scorer: Scorer
    ): Facet {
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
        dataType: DataType,
        scorer: Scorer
    ): Facet {
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
