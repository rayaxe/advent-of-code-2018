package com.github.rayaxe.day1

fun day1Part1(changes: List<String>): Int = changes.sumBy { it.toInt() }

fun day1Part2(changes: List<String>): Int {
    val frequencies: MutableSet<Int> = mutableSetOf()
    return changes
        .map(String::toInt)
        .asSequence()
        .repeat()
        .fold(0) { frequency, change ->
            if (frequencies.contains(frequency))
                return frequency
            frequencies.add(frequency)
            frequency + change
        }
}

private fun <T> Sequence<T>.repeat() = sequence { while (true) yieldAll(this@repeat) }
