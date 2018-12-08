package com.github.rayaxe

import com.github.rayaxe.day1.day1Part1
import com.github.rayaxe.day1.day1Part2
import com.github.rayaxe.day2.day2Part1
import com.github.rayaxe.day2.day2Part2
import com.github.rayaxe.day3.day3Part1
import com.github.rayaxe.day3.day3Part2
import java.io.File

fun main(args: Array<String>) {
    val inputDay1 = readLinesFromFile("src/main/resources/day1/input.txt")
    println(day1Part1(inputDay1))
    println(day1Part2(inputDay1))
    val inputDay2 = readLinesFromFile("src/main/resources/day2/input.txt")
    println(day2Part1(inputDay2))
    println(day2Part2(inputDay2))
    val inputDay3 = readLinesFromFile("src/main/resources/day3/input.txt")
    println(day3Part1(inputDay3))
    println(day3Part2(inputDay3))
}

private fun readLinesFromFile(pathname: String) = File(pathname).readLines()
