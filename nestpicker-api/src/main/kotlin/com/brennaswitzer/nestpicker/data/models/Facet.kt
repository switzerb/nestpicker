package com.brennaswitzer.nestpicker.data.models

abstract class FacetBase<V, S>(
    val id: Int,
    val name: String,
    val scorer: Scorer<S>
) {
    abstract fun getFacetScore(area: Area): Score?
}

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
    override fun getFacetScore(area: Area): Score? {
        return if (area.hasFacetValue(this)) {
            scorer.getScore(
                area.getFacetValue(this)
            )
        } else {
            null
        }
    }
}
