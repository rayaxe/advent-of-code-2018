package com.github.rayaxe.days

// FIXME `overlap` should not be a property of this class
data class Claim(val id: Int, val pos: Pair<Int, Int>, val size: Pair<Int, Int>, var overlap: Boolean = false)

private fun MatchGroupCollection.getInt(index: Int): Int = this[index]!!.value.toInt()
private fun intRange(offset: Int, size: Int) = offset until offset + size

fun parseClaimString(claimString: String): Claim {
    val regex = """#(\d+) @ (\d+),(\d+): (\d+)x(\d+)""".toRegex()
    val matchResult = regex.find(claimString)

    val groups = matchResult?.groups;
    if (groups == null || groups.size < 6) {
        throw Exception("Error parsing claim: ${claimString}");
    }

    val pos = Pair(groups.getInt(2), groups.getInt(3))
    val size = Pair(groups.getInt(4), groups.getInt(5))
    return Claim(groups.getInt(1), pos, size)
}

fun day3Part1(claims: List<String>): Int {
    val result: MutableMap<String, Int> = mutableMapOf()
    claims.forEach { claimString ->
        val claim: Claim = parseClaimString(claimString)
        for (x in intRange(claim.pos.first, claim.size.first)) {
            for (y in intRange(claim.pos.second, claim.size.second)) {
                val key = x.toString() + '_' + y.toString()
                result[key] = 1 + result.getOrDefault(key, 0)
            }
        }
    }
    return result.values.stream()
        .filter { count -> count > 1 }
        .count().toInt()
}

fun day3Part2(claims: List<String>): Int {
    val result: MutableMap<String, MutableSet<Claim>> = mutableMapOf()
    claims.forEach { claimString ->
        val claim: Claim = parseClaimString(claimString)
        for (x in intRange(claim.pos.first, claim.size.first)) {
            for (y in intRange(claim.pos.second, claim.size.second)) {
                val key = x.toString() + '_' + y.toString()
                val set = result[key]
                if (set == null) {
                    result[key] = mutableSetOf(claim)
                } else {
                    set.add(claim)
                    set.forEach { c -> c.overlap = true }
                }
            }
        }
    }
    return result.values
        .filter { claimSets -> claimSets.size == 1 }
        .flatMap { it }
        .filter { claim -> !claim.overlap }
        .first().id
}
