fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        for (line in input) {
            val digitsOnly = line.filter{ it.isDigit() }
            val combinedDigits = "${digitsOnly.first()}${digitsOnly.last()}"
            result += combinedDigits.toInt()
        }
        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0

        val thingsToFind = mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero")
        val wordsToReplace = mapOf("one" to "1", "two" to "2", "three" to "3", "four" to "4", "five" to "5", "six" to "6", "seven" to "7", "eight" to "8", "nine" to "9", "zero" to "0")

        for (line in input) {
            /*
                two1nine
                [two]1[nine]
                29

                [eight]wo[three]
                83

                abc[one]2[three]xyz
                13

                x[two]ne3[four]
                24

                [4]nineeightseven[2]
                42

                z[one]ight23[4]
                14

                [7]pqrst[six]teen
                76
                ------
                two1nine
                0:two
                3:1
                4:nine
                29

                eightwothree
                0:eight
                4:two
                7:three
                83

                abcone2threexyz
                3:one
                6:2
                7:three
                13

                xtwone3four
                1:two
                4:one
                7:3
                7:four
                24

                4nineeightseven2
                0:4
                1:nine
                5:eight
                10:seven
                15:2
                42

                zoneight234
                1:one
                3:eight
                8:2
                9:3
                10:4
                14

                7pqrstsixteen
                0:7
                6:six
                76
             */

            var resultString = "${line.findAnyOf(thingsToFind)?.second}${line.findLastAnyOf(thingsToFind)?.second}"

            for (thing in wordsToReplace) {
                resultString = resultString.replace(thing.key, thing.value)
            }

            result += resultString.toInt()
        }

        return result
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val testInput2 = readInput("Day01_test2")
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()

}

