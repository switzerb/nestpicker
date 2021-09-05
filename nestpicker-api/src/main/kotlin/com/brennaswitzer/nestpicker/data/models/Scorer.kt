package com.brennaswitzer.nestpicker.data.models

interface Scorer {
    fun createScore(): Int
    fun getScore(): Int
}

class NumberScorer(
    val strategy: (n: Int) -> Int
) : Scorer {

    private val data: Int = 0

    // this will need to accept some function as a way to calculate score
    override fun createScore(): Int {
        return strategy(data)
    }

    override fun getScore(): Int {
        return data
    }
}
