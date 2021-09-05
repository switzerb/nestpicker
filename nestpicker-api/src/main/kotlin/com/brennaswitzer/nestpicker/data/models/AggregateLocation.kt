package com.brennaswitzer.nestpicker.data.models

import com.brennaswitzer.nestpicker.data.entities.Location

/*
Aggregate Location represents an ad-hoc collection of
"regions" that allow me to scale up and down the faceting
for example if I want to know all the climate change data
for Australia I can create an aggregate location with all
the areas in Australia that I have data for and
calculate their collective facets
*/
class AggregateLocation {

    init {
        val locations : MutableList<Location> = mutableListOf()
    }
}
