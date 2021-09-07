package com.brennaswitzer.nestpicker.controllers

import com.brennaswitzer.nestpicker.services.RegionService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/")
class RegionController {

    @Inject
    val regionService = RegionService()

    @Get(produces = [MediaType.APPLICATION_JSON])
    fun index(): HttpResponse<List<Region>> {
        val regions = regionService.getRegions()
        return HttpResponse.status<String>(HttpStatus.OK).body(regions)
    }

    @Post()
    fun createArea(@Body name: String): HttpResponse<String> {
        regionService.createNewArea(
            name = name
        )
        return HttpResponse.status(HttpStatus.CREATED)
    }
}
