package com.brennaswitzer.nestpicker.controllers

import com.brennaswitzer.nestpicker.data.DatabaseFactory
import com.brennaswitzer.nestpicker.data.entities.Locations
import com.brennaswitzer.nestpicker.data.repos.LocationRepo
import io.kotest.core.spec.style.AnnotationSpec
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

@MicronautTest
class LocationControllerTest : AnnotationSpec() {

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
