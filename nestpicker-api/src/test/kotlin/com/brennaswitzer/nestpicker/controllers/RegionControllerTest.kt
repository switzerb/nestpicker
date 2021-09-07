package com.brennaswitzer.nestpicker.controllers

import com.brennaswitzer.nestpicker.data.repos.AreaRepo
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject

@MicronautTest
class RegionControllerTest : AnnotationSpec() {

    @Inject
    lateinit var regionRepo: AreaRepo

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun createNewLocation() {
        1.shouldBe(1)
    }
}
