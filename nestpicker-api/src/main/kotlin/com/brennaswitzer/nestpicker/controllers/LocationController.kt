package com.brennaswitzer.nestpicker.controllers

import com.brennaswitzer.nestpicker.services.LocationService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/")
class LocationController {

    @Inject
    val locationService = LocationService()

    @Get(produces = [MediaType.APPLICATION_JSON])
    fun index(): HttpResponse<String> {
        val locations = locationService.getLocations()
        return HttpResponse.status<String>(HttpStatus.OK).body(locations.toString())
    }

    @Post()
    fun createLocation(): HttpResponse<String> {
        locationService.createNewLocation(name = "Topeka")
        return HttpResponse.status(HttpStatus.CREATED)
    }
}
