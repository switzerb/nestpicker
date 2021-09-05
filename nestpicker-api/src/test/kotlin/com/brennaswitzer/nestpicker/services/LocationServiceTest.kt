package com.brennaswitzer.nestpicker.services

import com.brennaswitzer.nestpicker.data.entities.Facet
import com.brennaswitzer.nestpicker.data.entities.Location
import com.brennaswitzer.nestpicker.data.models.DataType
import com.brennaswitzer.nestpicker.data.models.NumberScorer
import com.brennaswitzer.nestpicker.utils.BaseTest
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject

@MicronautTest
class LocationServiceTest : BaseTest() {

    @Inject
    lateinit var locationService: LocationService

    @Test
    fun works() {
        val location = Location.insert(
            name = "Kauai"
        )
        val facet = Facet.insert(
            name = "Cost of Living",
            dataType = DataType.INTEGER
        )

        facet.scorer = NumberScorer { n -> n * 10 }

        locationService.setFacetValueForLocation(
            facet = facet,
            location = location,
            value = "10"
        )

//        println(location)
//        println(location.getAllFacets())
    }
}
