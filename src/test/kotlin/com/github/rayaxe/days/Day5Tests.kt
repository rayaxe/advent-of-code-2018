package com.github.rayaxe.days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day5Tests {

    @Nested
    inner class Day4Part1 {

        @Test
        fun example1() {
            assertEquals(10, day5Part1("dabAcCaCBAcCcaDA"))
        }
    }

    @Nested
    inner class Day4Part2 {

        @Test
        fun example1() {
            assertEquals(4, day5Part2("dabAcCaCBAcCcaDA"))
        }
    }
}