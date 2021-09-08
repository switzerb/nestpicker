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
        name = "Hawaii",
        areas = mutableListOf(kauai, maui)
    )

    private val areas = mutableListOf(
        kauai,
        maui,
        pienza,
        burlington,
        hawaii
    )

    private fun getNextId() = areas.size + 1

    fun getAreas(): List<Area> {
        return areas.toList()
    }

    fun createArea(name: String): Area {
        val newArea = Area(
            id = getNextId(),
            name = name
        )
        areas.add(newArea)
        return newArea
    }

    fun createAggregateArea(name: String, areaList: List<Area>): AggregateArea {
        val newAggregateArea = AggregateArea(
            id = getNextId(),
            name = name,
            areas = areaList.toMutableList()
        )
        areas.add(newAggregateArea)
        return newAggregateArea
    }
}
