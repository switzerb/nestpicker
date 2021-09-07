package com.brennaswitzer.nestpicker.data.repos

import com.brennaswitzer.nestpicker.data.models.AggregateArea
import com.brennaswitzer.nestpicker.data.models.Area
import jakarta.inject.Singleton

@Singleton
class AreaRepo {

    val kauai = Area(1, "Kauai")
    val maui = Area(2, "Maui")
    val pienza = Area(3, "Pienza")
    val burlington = Area(4, "Burlington")

    val hawaii = AggregateArea(
        id = 5,
        areas = mutableListOf(kauai, maui)
    )

    private val regions = mutableListOf(
        kauai,
        maui,
        pienza,
        burlington,
        hawaii
    )

    fun getNextId() = regions.size + 1

    fun getRegions(): List<Area> {
        return regions.toList()
    }

    fun createArea(name: String): Area {
        val newArea = Area(
            id = getNextId(),
            name = name
        )
        regions.add(newArea)
        return newArea
    }

    fun createAggregateArea(name: String ,areas: List<Area>) : AggregateArea {
        val newAggregateArea = AggregateArea(
            id = getNextId(),
            name = name,
            areas = areas.toMutableList()
        )
        regions.add(newAggregateArea)
        return newAggregateArea
    }
}
