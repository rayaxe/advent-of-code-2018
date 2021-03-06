package com.github.rayaxe.days

fun day1Part1(changes: List<String>): Int = changes.sumBy { it.toInt() }

fun day1Part2(changes: List<String>): Int {

    // yielding an infinite repeating sequence
    fun <T> Sequence<T>.repeat() = sequence { while (true) yieldAll(this@repeat) }

    val frequencies: MutableSet<Int> = mutableSetOf()
    return changes.asSequence().repeat().fold(0) { frequency, change ->
        if (frequencies.contains(frequency))
            return frequency
        frequencies.add(frequency)
        frequency + change.toInt()
    }
}
