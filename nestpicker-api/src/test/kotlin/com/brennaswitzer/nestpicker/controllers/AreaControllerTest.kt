package com.brennaswitzer.nestpicker.controllers

import com.brennaswitzer.nestpicker.data.repos.AreaRepo
import io.kotest.core.spec.style.AnnotationSpec
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject

@MicronautTest
class AreaControllerTest : AnnotationSpec() {

    @Inject
    lateinit var areaRepo: AreaRepo

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun createNewLocation() {
        areaRepo.getAreas()
    }
}
