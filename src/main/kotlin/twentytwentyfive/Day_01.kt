package org.lyn.twentytwentyfive

import java.io.File

// Part 1: 995
// Part 2: 5847

class Day_01(path: String) {
    val input = readInputFile(path+"day_01\\input.txt")
    val inputTest = readInputFile(path+"day_01\\inputTest.txt")
    val dialStartValue = 50
    val dialValues = 100

    fun solution() {
        println("--- Day 1 part 1 ---")
        part_1()
        println("--- Day 1 part 2 ---")
        part_2()
    }

    fun part_1() {
        var password = 0
        var dialNumber = dialStartValue

        this.input.forEach{
            dialNumber = runStep(dialNumber, it)
            if (dialNumber == 0)
                password = password + 1
        }

        println("Answer: $password")
    }

    fun runStep(dialNumber: Int, step: String): Int {
        val direction = step.get(0)
        val numberOfSteps = step.substring(1).toInt()
        var newDialNumber = 0

        when (direction) {
            'L' -> newDialNumber = (dialNumber-numberOfSteps).mod(dialValues)
            'R' -> newDialNumber = (dialNumber+numberOfSteps).mod(dialValues)
        }
        return newDialNumber
    }

    fun part_2() {
        var password = 0
        var dialNumber = dialStartValue

        this.input.forEach {
            val direction = it.get(0)
            val numberOfSteps = it.substring(1).toInt()

            for (i in 0 until numberOfSteps) {
                when (direction) {
                    'L' -> {
                        dialNumber = dialNumber - 1
                        if (dialNumber == -1)
                            dialNumber = 99
                    }
                    'R' -> {
                        dialNumber = dialNumber + 1
                        if (dialNumber == 100)
                            dialNumber = 0
                    }
                }

                if (dialNumber == 0) {
                    password = password + 1
                }
            }
        }

        println("Answer: ${password}\n")
    }

    fun readInputFile(filename: String): List<String> {
        val lines: List<String> = File(filename).readLines()

        return lines
    }
}