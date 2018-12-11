package com.github.rayaxe.days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day2Tests {

    @Nested
    inner class Day2Part1 {

        @Test
        fun example1() {
            assertEquals(12,
                day2Part1(
                    listOf(
                        "abcdef",
                        "bababc",
                        "abbcde",
                        "abcccd",
                        "aabcdd",
                        "abcdee",
                        "ababab"
                    )
                )
            )
        }
    }

    @Nested
    inner class Day2Part2 {

        @Test
        fun example1() {
            assertEquals("fgij",
                day2Part2(listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"))
            )
        }
    }
}