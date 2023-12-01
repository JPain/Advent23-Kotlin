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

            //wholeNumber.println()

            result += wholeNumber
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (item in input) {
            val newItem = replaceWordsWithDigits(item)
            result += part1(listOf(newItem))
        }
        return result
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()

}

fun replaceWordsWithDigits(input: String): String {
    val wordsToNumber = mapOf(
        "zero" to "0", "one" to "1", "two" to "2", "three" to "3",
        "four" to "4", "five" to "5", "six" to "6",
        "seven" to "7", "eight" to "8", "nine" to "9"
    )

    val sb = StringBuilder()
    var i = 0

    while (i < input.length) {
        var matched = false
        for ((word, number) in wordsToNumber) {
            if (input.startsWith(word, i)) {
                sb.append(number)
                i += word.length
                matched = true
                break
            }
        }
        if (!matched) {
            sb.append(input[i])
            i++
        }
    }

    return sb.toString()
}

