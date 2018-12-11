package com.github.rayaxe.days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day3Tests {

    @Nested
    inner class Day3Part1 {

        @Test
        fun parseClaimString() {
            val expected = Claim(1, Pair(126, 902), Pair(29, 28))
            assertEquals(expected, parseClaimString("#1 @ 126,902: 29x28"))
        }

        @Test
        fun example1() {
            assertEquals(4, day3Part1(listOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")))
        }
    }

    @Nested
    inner class Day3Part2 {

        @Test
        fun example1() {
            assertEquals(3, day3Part2(listOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")))
        }
    }
}