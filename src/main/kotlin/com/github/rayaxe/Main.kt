package com.github.rayaxe

import com.github.rayaxe.days.*
import java.io.File

fun main(args: Array<String>) {
    val inputDay1 = readLinesFromFile("input_day1.txt")
    println(day1Part1(inputDay1))
    println(day1Part2(inputDay1))
    val inputDay2 = readLinesFromFile("input_day2.txt")
    println(day2Part1(inputDay2))
    println(day2Part2(inputDay2))
    val inputDay3 = readLinesFromFile("input_day3.txt")
    println(day3Part1(inputDay3))
    println(day3Part2(inputDay3))
    val inputDay4 = readLinesFromFile("input_day4.txt")
    println(day4Part1(inputDay4))
    println(day4Part2(inputDay4))
    val inputDay5 = readLinesFromFile("input_day5.txt").first()
    println(day5Part1(inputDay5))
    println(day5Part2(inputDay5))
}

private fun readLinesFromFile(filename: String) = File("src/main/resources/days/" + filename).readLines()
