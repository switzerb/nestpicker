package com.brennaswitzer.nestpicker.data.models

open class Facet(
    val id: Int,
    val name: String,
    val dataType: DataType = DataType.STRING,
    val scorer: Scorer
) {

    fun getFacetScore(): Int {
        return scorer.getScore()
    }

    override fun toString(): String {
        return name.toString()
    }
}
