package com.brennaswitzer.nestpicker.services

import com.brennaswitzer.nestpicker.data.models.Area
import com.brennaswitzer.nestpicker.data.models.DataType
import com.brennaswitzer.nestpicker.data.models.NumberScorer
import com.brennaswitzer.nestpicker.data.models.Score
import com.brennaswitzer.nestpicker.data.repos.AreaRepo
import com.brennaswitzer.nestpicker.data.repos.FacetRepo
import com.brennaswitzer.nestpicker.utils.BaseTest
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject

@MicronautTest
class AreaServiceTest : BaseTest() {

    @Inject
    lateinit var areaService: AreaService

    @Inject
    lateinit var areaRepo: AreaRepo

    @Inject
    lateinit var facetRepo: FacetRepo

    @Test
    fun works() {
        val facet = facetRepo.createFacet(
            name = "Cost of Living",
            dataType = DataType.INTEGER,
            scorer = NumberScorer { n -> Score((n * 100).toDouble()) }
        )
        val kauai = Area(
            id = 1,
            name = "Kauai"
        )
        val montpelier = Area(
            id = 2,
            name = "Montpelier"
        )
        areaService.setFacetValue(
            facet = facet,
            area = kauai,
            value = 100000
        )
        areaService.setFacetValue(
            facet = facet,
            area = montpelier,
            value = 10000
        )
        println(areaService.getAreas())
        println(areaService.getScoreFromFacetValue(kauai, facet))
    }
}
