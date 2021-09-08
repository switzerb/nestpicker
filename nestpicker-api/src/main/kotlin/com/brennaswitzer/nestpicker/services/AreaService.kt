package com.brennaswitzer.nestpicker.services

import com.brennaswitzer.nestpicker.data.models.Area
import com.brennaswitzer.nestpicker.data.models.Facet
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

    fun setFacetValue(
        facet: Facet,
        area: Area,
        value: Any?
    ) {
        area.setFacetValue(facet, value)
    }
}
