package com.brennaswitzer.nestpicker.services

import com.brennaswitzer.nestpicker.data.models.Facet
import com.brennaswitzer.nestpicker.data.repos.AreaRepo
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class RegionService {

    @Inject
    val regionRepo = AreaRepo()

    fun createNewArea(name: String) {
        regionRepo.createArea(name = name)
    }

    fun getRegions(): List<Region> {
        return regionRepo.getRegions()
    }

    fun setFacetValue(
        facet: Facet,
        region: Region,
        value: Any?
    ) {
        region.setFacetValue(facet, value)
    }
}
