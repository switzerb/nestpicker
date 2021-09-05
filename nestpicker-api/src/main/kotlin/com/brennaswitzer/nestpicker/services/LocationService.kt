package com.brennaswitzer.nestpicker.services

import com.brennaswitzer.nestpicker.data.repos.LocationRepo
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

@Singleton
class LocationService {

    @Inject
    lateinit var database: Database

    @Inject
    val locationRepo = LocationRepo()

    fun createNewLocation(name: String) {
        transaction {
            locationRepo.addLocation(name)
        }
    }

    fun getLocations(): List<String> {
        return transaction {
            locationRepo
                .getLocations()
                .map {
                    it.name
                }
        }
    }
}
