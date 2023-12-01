fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        for (item in input) {
            var digit1 = 0
            var digit2 = 0

            for (letter in item) {
                if (letter.isDigit()) {
                    digit1 = letter.digitToInt()
                }
            }

            for (letter in item.reversed()) {
                if (letter.isDigit()) {
                    digit2 = letter.digitToInt()
                }
            }

            val wholeNumber = (digit2.toString() + digit1.toString()).toInt()

            result += wholeNumber
        }
        return result
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
