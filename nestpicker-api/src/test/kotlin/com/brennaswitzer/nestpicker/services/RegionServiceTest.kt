package com.brennaswitzer.nestpicker.services

import com.brennaswitzer.nestpicker.data.models.Area
import com.brennaswitzer.nestpicker.data.models.DataType
import com.brennaswitzer.nestpicker.data.models.Facet
import com.brennaswitzer.nestpicker.data.models.NumberScorer
import com.brennaswitzer.nestpicker.utils.BaseTest
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject

@MicronautTest
class RegionServiceTest : BaseTest() {

    @Inject
    lateinit var regionService: RegionService

    @Test
    fun works() {
        val costOfLiving = Facet(
            name = "Cost of Living",
            dataType = DataType.INTEGER,
            scorer = NumberScorer { n -> n * 10 }
        )
        val kauai = Area(
            id = 1,
            name = "Kauai"
        )
        val montpelier = Area(
            id = 2,
            name = "Montpelier"
        )
        regionService.setFacetValue(
            facet = costOfLiving,
            region = kauai,
            value = 100000
        )
        regionService.setFacetValue(
            facet = costOfLiving,
            region = montpelier,
            value = 10000
        )
        println(regionService.getRegions())
    }
}
