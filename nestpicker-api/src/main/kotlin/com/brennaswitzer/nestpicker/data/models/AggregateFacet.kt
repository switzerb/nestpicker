package com.brennaswitzer.nestpicker.data.models

import com.brennaswitzer.nestpicker.data.entities.Facet

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

class AggregateFacet() {

    init {
        val facets : MutableList<Facet> = mutableListOf()
    }
}
