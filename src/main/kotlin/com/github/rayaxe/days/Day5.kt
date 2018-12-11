package com.github.rayaxe.days

fun day5Part1(polymer: String): Int {
    val chars = polymer.toCharArray().toMutableList()
    var i = 0
    do {
        val current = chars[i]
        val next = chars[i + 1]
        if (current != next && current.toLowerCase() == next.toLowerCase()) {
            chars.removeAt(i)
            chars.removeAt(i)
            if (i > 0) {
                i--
            }
        } else {
            i++
        }
    } while (i < chars.size - 1)
    return chars.size
}

fun day5Part2(polymer: String): Int {
    var min = Int.MAX_VALUE
    for (char in 'a'..'z') {
        val stripped = polymer.toCharArray()
            .filter { it.toLowerCase() != char }
            .fold(StringBuilder(), StringBuilder::append)
            .toString()
        val size = day5Part1(stripped)
        if (min > size) {
            min = size
        }
    }
    return min
}
