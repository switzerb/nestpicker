package com.brennaswitzer.nestpicker.data.repos

import com.brennaswitzer.nestpicker.data.entities.Location
import com.brennaswitzer.nestpicker.data.entities.Locations
import jakarta.inject.Singleton
import org.jetbrains.exposed.sql.insert

@Singleton
class LocationRepo {

    fun addLocation(locationName: String) {
        Locations.insert {
            it[name] = locationName
        } get Locations.id
    }

    fun getLocations(): List<Location> {
        return Location.all().toList()
    }
}
