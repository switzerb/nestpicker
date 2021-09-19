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
        val goods = facetRepo.createFacet(
            name = "Goods and Services",
            dataType = DataType.INTEGER,
            scorer = NumberScorer { n -> Score(n.toDouble() / 100) }
        )
        val realEstate = facetRepo.createFacet(
            name = "Real Estate",
            dataType = DataType.INTEGER,
            scorer = NumberScorer { n -> Score((n * 100 / 100).toDouble()) }
        )
        val costOfLiving = facetRepo.createAggregateFacet(
            name = "Cost of Living",
            scorer = AggregateScorer { list -> Score(list.map { it.value }.average()) }
        )
        costOfLiving.addFacet(goods)
        costOfLiving.addFacet(realEstate)

        val kauai = Area(
            id = 1,
            name = "Kauai"
        )
        val montpelier = Area(
            id = 2,
            name = "Montpelier"
        )
        areaService.setFacetValue(
            facet = goods,
            area = kauai,
            value = 10
        )
        areaService.setFacetValue(
            facet = realEstate,
            area = kauai,
            value = 50
        )
        areaService.setFacetValue(
            facet = goods,
            area = montpelier,
            value = 20
        )
        areaService.setFacetValue(
            facet = realEstate,
            area = montpelier,
            value = 100
        )
        println("Areas: ${areaService.getAreas()}")
        println(areaService.getAreaFacetScore(kauai, costOfLiving))
        println(areaService.getAreaFacetScore(kauai, goods))
        println(areaService.getAreaFacetScore(kauai, realEstate))
        println(areaService.getAreaFacetScore(montpelier, costOfLiving))
        println(areaService.getAreaFacetScore(montpelier, goods))
        println(areaService.getAreaFacetScore(montpelier, realEstate))
    }
}
