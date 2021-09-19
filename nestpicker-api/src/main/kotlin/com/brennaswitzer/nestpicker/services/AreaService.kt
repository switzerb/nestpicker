package com.brennaswitzer.nestpicker.services

import com.brennaswitzer.nestpicker.data.models.*
import com.brennaswitzer.nestpicker.data.repos.AreaRepo
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class AreaService {

    @Inject
    val areaRepo = AreaRepo()

    fun createNewArea(name: String) {
        areaRepo.createArea(name = name)
    }

    fun getAreas(): List<Area> {
        return areaRepo.getAreas()
    }

    fun <T> setFacetValue(
        facet: Facet<T>,
        area: Area,
        value: T?
    ) {
        area.setFacetValue(facet, value)
    }

    fun <T> getFacetValue(
        facet: Facet<T>,
        area: Area
    ): T? {
        return area.getFacetValue(facet)
    }

    fun getAreaFacetScore(
        area: Area,
        facet: FacetBase<*, *>
    ): Score? {
        return facet.getFacetScore(area)
    }
}
