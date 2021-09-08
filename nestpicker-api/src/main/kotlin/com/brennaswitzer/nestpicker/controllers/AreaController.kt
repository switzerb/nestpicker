package com.brennaswitzer.nestpicker.controllers

import com.brennaswitzer.nestpicker.data.models.Area
import com.brennaswitzer.nestpicker.services.AreaService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/")
class AreaController {

    @Inject
    val areaService = AreaService()

    @Get(produces = [MediaType.APPLICATION_JSON])
    fun index(): HttpResponse<List<Area>> {
        val regions = areaService.getAreas()
        return HttpResponse.status<String>(HttpStatus.OK).body(regions)
    }

    @Post()
    fun createArea(@Body name: String): HttpResponse<String> {
        areaService.createNewArea(
            name = name
        )
        return HttpResponse.status(HttpStatus.CREATED)
    }
}
