package com.brennaswitzer.nestpicker.data.models

data class Score(val value: Double)

interface Scorer<T> {
    fun getScore(data: T): Score
}

class AggregateScorer(
    val strategy: (n: List<Score>) -> Score
) : Scorer<List<Score>> {

    override fun getScore(data: List<Score>): Score {
        return strategy(data)
    }
}

class NumberScorer(
    val strategy: (n: Int) -> Score
) : Scorer<Int> {

    override fun getScore(data: Int): Score {
        return strategy(data)
    }
}
