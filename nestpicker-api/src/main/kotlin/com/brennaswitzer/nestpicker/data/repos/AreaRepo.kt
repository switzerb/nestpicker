package com.brennaswitzer.nestpicker.data.repos

import com.brennaswitzer.nestpicker.data.models.Area
import jakarta.inject.Singleton

@Singleton
class AreaRepo {

    private val areas = mutableListOf(
        Area(1, "Kauai"),
        Area(2, "Pienza"),
        Area(3, "Burlington"),
    )

    fun getNextId() = areas.size + 1

    fun getAreas(): List<Area> {
        return areas.toList()
    }

    fun createArea(area: Area): Area {
        areas.add(area)
        return area
    }
}
