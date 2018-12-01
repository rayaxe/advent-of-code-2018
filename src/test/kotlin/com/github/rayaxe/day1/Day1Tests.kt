package com.github.rayaxe.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day1Tests {

    @Nested
    inner class Day1Part1 {

        @Test
        fun example1() {
            assertEquals(3, day1Part1(listOf("+1", "+1", "+1")))
        }

        @Test
        fun example2() {
            assertEquals(0, day1Part1(listOf("+1", "+1", "-2")))
        }

        @Test
        fun example3() {
            assertEquals(-6, day1Part1(listOf("-1", "-2", "-3")))
        }
    }

    @Nested
    inner class Day1Part2 {

        @Test
        fun example1() {
            assertEquals(0, day1Part2(listOf("+1", "-1")))
        }

        @Test
        fun example2() {
            assertEquals(10, day1Part2(listOf("+3", "+3", "+4", "-2", "-4")))
        }

        @Test
        fun example3() {
            assertEquals(5, day1Part2(listOf("-6", "+3", "+8", "+5", "-6")))
        }

        @Test
        fun example4() {
            assertEquals(14, day1Part2(listOf("+7", "+7", "-2", "-7", "-4")))
        }
    }
}