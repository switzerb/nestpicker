package com.brennaswitzer.nestpicker.data.models

/*
Groups of facets represent a "category" of information

aggregate facets will be where the weights are

precipitation/water
sea level rise
natural disasters
average summer temp
average winter temp
overall stability
Calculated Property to roll things up into, for example, climate data
 */

/* TODO: Can aggregateFacet contain other aggregates? */
class AggregateFacet(
    id: Int,
    name: String,
    scorer: Scorer<List<Score>>,
    private val facets: MutableList<Facet<*>> = mutableListOf()
) : FacetBase<Nothing, List<Score>>(
    id = id,
    name = name,
    scorer = scorer
) {
    fun <V> addFacet(facet: Facet<V>) {
        facets.add(facet)
    }
    override fun getFacetScore(area: Area): Score {
        val scores = facets.mapNotNull { facet ->
            facet.getFacetScore(area)
        }
        return scorer.getScore(scores)
    }
}
