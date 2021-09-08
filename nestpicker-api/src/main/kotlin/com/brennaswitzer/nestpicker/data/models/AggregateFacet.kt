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
    dataType: DataType = DataType.STRING,
    scorer: Scorer,
    val facets: MutableList<Facet> = mutableListOf()
) : Facet(id, name, dataType, scorer)
