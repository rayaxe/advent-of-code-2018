package com.github.rayaxe.day2

fun day2Part1(ids: List<String>): Int {
    var twoCount = 0
    var threeCount = 0
    ids.forEach {
        val charCount = it.groupingBy { c -> c }.eachCount().values
        if (charCount.contains(2)) twoCount++
        if (charCount.contains(3)) threeCount++
    }
    return twoCount * threeCount
}

fun day2Part2(ids: List<String>): String {
    var offset = 1
    ids.forEach { stringA ->
        val otherIds = ids.subList(offset, ids.size)
        otherIds.forEach { stringB ->
            val differences: List<Boolean> = stringA.zip(stringB) { charA, charB -> charA != charB }
            if (differences.count { it } == 1) {
                return stringA.toCharArray()
                    .zip(differences) { char, isDifferent -> if (!isDifferent) char else null }
                    .filterNotNull()
                    .joinToString(separator = "")
            }
        }
        offset++
    }
    return ""
}
