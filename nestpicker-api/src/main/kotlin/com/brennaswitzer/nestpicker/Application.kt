package com.brennaswitzer.nestpicker

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
    build()
        .eagerInitSingletons(true)
        .args(*args)
        .packages("com.brennaswitzer.nestpicker")
        .start()
}
