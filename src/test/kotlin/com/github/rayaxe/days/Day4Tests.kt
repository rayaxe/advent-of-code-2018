package com.github.rayaxe.days

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class Day4Tests {

    @Nested
    inner class Day4Part1 {

        @Test
        fun parseRecordGuardBeginsShift() {
            val actual = parseRecord("[1518-11-01 00:00] Guard #10 begins shift")
            val localDateTime = LocalDateTime.of(1518, 11, 1, 0, 0)
            assertEquals(Record(localDateTime, 10, true), actual)
        }

        @Test
        fun parseRecordGuardFallsAsleep() {
            val actual = parseRecord("[1518-11-01 00:05] falls asleep")
            val localDateTime = LocalDateTime.of(1518, 11, 1, 0, 5)
            assertEquals(Record(localDateTime, null, false), actual)
        }

        @Test
        fun parseRecordGuardWakesUp() {
            val actual = parseRecord("[1518-11-01 00:25] wakes up")
            val localDateTime = LocalDateTime.of(1518, 11, 1, 0, 25)
            assertEquals(Record(localDateTime, null, true), actual)
        }

        @Test
        fun example1() {
            val input: List<String> = listOf(
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-05 00:45] falls asleep",
                "[1518-11-05 00:55] wakes up"
            )
            assertEquals(240, day4Part1(input))
        }
    }

    @Nested
    inner class Day4Part2 {

        @Test
        fun example1() {
            val input: List<String> = listOf(
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-05 00:45] falls asleep",
                "[1518-11-05 00:55] wakes up"
            )
            assertEquals(4455, day4Part2(input))
        }
    }
}