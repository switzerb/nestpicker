package com.brennaswitzer.nestpicker.controllers

import com.brennaswitzer.nestpicker.data.repos.LocationRepo
import com.brennaswitzer.nestpicker.utils.BaseTest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject
import org.jetbrains.exposed.sql.transactions.transaction

@MicronautTest
class LocationControllerAgainTest : BaseTest() {

    @Inject
    lateinit var locationRepo: LocationRepo

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun createNewLocation() {
        transaction {
            locationRepo.getLocations()
        }
    }
}
