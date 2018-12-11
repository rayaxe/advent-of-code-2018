package com.github.rayaxe.days

import java.time.LocalDateTime

private fun MatchGroupCollection.getInt(index: Int): Int = this[index]!!.value.toInt()
data class Record(val localDateTime: LocalDateTime, val guardId: Int?, val awake: Boolean = true)

fun parseRecord(record: String): Record {
    val regex = """\[(\d+)\-(\d+)\-(\d+) (\d+):(\d+)] (.*)""".toRegex()
    val matchResult = regex.find(record)
    val groups = matchResult?.groups;
    if (groups == null || groups.size < 7) {
        throw Exception("Error parsing record: ${record}");
    }

    val year = groups.getInt(1)
    val month = groups.getInt(2)
    val day = groups.getInt(3)
    val hour = groups.getInt(4)
    val minute = groups.getInt(5)
    val localDateTime = LocalDateTime.of(year, month, day, hour, minute)

    val info = groups[6]!!.value
    val guardId: Int? = parseGuardId(info)
    val awake = !info.equals("falls asleep")

    return Record(localDateTime, guardId, awake)
}

private fun parseGuardId(info: String): Int? {
    val regex = """Guard #(\d+) begins shift""".toRegex()
    val matchResult = regex.find(info)
    val groups = matchResult?.groups;
    var guardId: Int? = null
    if (groups != null && groups.size == 2) {
        guardId = groups.getInt(1)
    }
    return guardId
}

fun day4Part1(records: List<String>): Int {
    val guardsAsleep = guardsAsleep(records)
    var guardId = -1
    var maxTotalSleepMinutes = -1
    guardsAsleep.forEach {
        val sum = it.value.sum()
        if (maxTotalSleepMinutes < sum) {
            guardId = it.key
            maxTotalSleepMinutes = sum
        }
    }
    val mostFrequentMinute = guardsAsleep[guardId]!!.max()!!
    return guardId * guardsAsleep[guardId]!!.indexOf(mostFrequentMinute)
}

private fun guardsAsleep(records: List<String>): MutableMap<Int, MutableList<Int>> {
    val guardsAsleep = mutableMapOf<Int, MutableList<Int>>()
    val parsedRecords = records
        .map { record -> parseRecord(record) }
        .sortedBy { it.localDateTime }
    var guardId = -1
    var asleepFrom = LocalDateTime.now()
    for (record in parsedRecords) {
        if (record.guardId != null) {
            guardId = record.guardId
            continue
        }
        if (record.awake && record.localDateTime.minute >= 0) {
            guardsAsleep.putIfAbsent(guardId, listOfSixtyZeroes())
            for (m in asleepFrom.minute until record.localDateTime.minute) {
                guardsAsleep[guardId]!![m] += 1
            }
        }
        if (!record.awake) {
            asleepFrom = record.localDateTime
        }
    }
    return guardsAsleep
}

private fun listOfSixtyZeroes(): MutableList<Int> {
    val minutes = mutableListOf<Int>()
    for (i in 0..59) {
        minutes.add(0)
    }
    return minutes
}

fun day4Part2(records: List<String>): Int {
    val guardsAsleep = guardsAsleep(records)
    var guardId = -1
    var maxFavoriteMinutes = -1
    guardsAsleep.forEach {
        val max = it.value.max()
        if (max != null && maxFavoriteMinutes < max) {
            guardId = it.key
            maxFavoriteMinutes = max
        }
    }
    return guardId * guardsAsleep[guardId]!!.indexOf(maxFavoriteMinutes)
}
