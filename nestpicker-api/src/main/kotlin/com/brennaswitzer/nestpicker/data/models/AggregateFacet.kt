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

class AggregateFacet(
    id: Int,
    name: String,
    scorer: Scorer<List<Score>>,
    val facets: MutableList<FacetBase<*, *>> = mutableListOf()
) : FacetBase<Nothing, List<Score>>(
    id = id,
    name = name,
    scorer = scorer
) {
    fun getFacetScore(): Score {
        val values = listOf<Score>()
        return scorer.getScore(values)
    }

}
