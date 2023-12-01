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
        val newInput = mutableListOf<String>()
        for (item in input) {
            item.replace("one", "1")
            item.replace("two", "2")
            item.replace("three", "3")
            item.replace("four", "4")
            item.replace("five", "5")
            item.replace("six", "6")
            item.replace("seven", "7")
            item.replace("eight", "8")
            item.replace("nine", "9")
            newInput.add(item)
        }
        return part1(newInput)
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
