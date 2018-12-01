package com.github.rayaxe

import com.github.rayaxe.day1.day1Part1
import com.github.rayaxe.day1.day1Part2
import java.io.File

fun main(args: Array<String>) {
    val inputDay1 = readLinesFromFile("src/main/resources/day1/input.txt")
    println(day1Part1(inputDay1))
    println(day1Part2(inputDay1))
}

private fun readLinesFromFile(pathname: String) = File(pathname).readLines()
