fun main() {
    fun part1(input: List<String>): Int {
        var result = 0

        for (line in input) {
            var gameExcluded = false
            val split = line.split(": ", ", ", "; ")

            val gameNumber = split.first().filter { it.isDigit() }.toInt()

            for (thing in split.drop(1)) {
                val (numberStr, color) = thing.split(" ")
                val number = numberStr.toInt()

                val limit = when (color) {
                    "blue" -> 14
                    "green" -> 13
                    "red" -> 12
                    else -> throw IllegalArgumentException("Unknown color: $color")
                }

                if (number > limit) {
                    gameExcluded = true
                    break
                }
            }

            if (!gameExcluded) {
                result += gameNumber
            }
        }
        return result
    }



    fun part2(input: List<String>): Int {
        var result = 0

        for (line in input) {
            val split = line.split(": ", ", ", "; ")

            var maxRed = 0
            var maxGreen = 0
            var maxBlue = 0

            for (thing in split.drop(1)) {
                val (numberStr, color) = thing.split(" ")
                val number = numberStr.toInt()

                when (color) {
                    "red" -> if (number > maxRed) maxRed = number
                    "green" -> if (number > maxGreen) maxGreen = number
                    "blue" -> if (number > maxBlue) maxBlue = number
                }
            }

            result += (maxRed * maxGreen * maxBlue)

        }
        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 8)
    check(part2(testInput) == 2286)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
