package com.brennaswitzer.nestpicker

import io.micronaut.runtime.Micronaut.build

// TODO: Building a rating from a scorer
// TODO: More data model

fun main(args: Array<String>) {
    build()
        .eagerInitSingletons(true)
        .args(*args)
        .packages("com.brennaswitzer.nestpicker")
        .start()
}
