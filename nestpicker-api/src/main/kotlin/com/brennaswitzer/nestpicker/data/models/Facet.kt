package com.brennaswitzer.nestpicker.data.models

abstract class FacetBase<V, S>(
    val id: Int,
    val name: String,
    val scorer: Scorer<S>
)

open class Facet<V>(
    id: Int,
    name: String,
    scorer: Scorer<V>,
    val dataType: DataType = DataType.STRING,
) : FacetBase<V, V>(
    id = id,
    name = name,
    scorer = scorer
) {
    // in Facet guarantee they are the same assertion??

    fun getFacetScore(value: V): Score {
        return scorer.getScore(value)
    }

    override fun toString(): String {
        return name.toString()
    }
}
