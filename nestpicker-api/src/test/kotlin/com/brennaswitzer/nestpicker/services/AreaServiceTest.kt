package com.brennaswitzer.nestpicker.services

import com.brennaswitzer.nestpicker.data.models.*
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
        val costOfLiving = facetRepo.createFacet(
            name = "Cost of Living",
            dataType = DataType.INTEGER,
            scorer = NumberScorer { n -> Score(n.toDouble() / 100) }
        )
        val homePrices = facetRepo.createFacet(
            name = "Real Estate",
            dataType = DataType.INTEGER,
            scorer = NumberScorer { n -> Score((n * 100 / 100).toDouble()) }
        )
        val cost = facetRepo.createAggregateFacet(
            name = "Money",
            scorer = AggregateScorer { Score(20.00) }
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
            facet = costOfLiving,
            area = kauai,
            value = 10
        )
        areaService.setFacetValue(
            facet = costOfLiving,
            area = montpelier,
            value = 20
        )
        println(areaService.getAreas())
        println(areaService.getAreaFacetAggregateScore(kauai, cost))
        println(areaService.getAreaFacetScore(kauai, costOfLiving))
        println(areaService.getAreaFacetScore(montpelier, costOfLiving))
    }
}
