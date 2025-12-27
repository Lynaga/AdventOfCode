package org.lyn.y2025

import java.io.File

// Part 1: 17535
// Part 2: 173577199527257

class Day_03(path: String) {
    val input = readInputFile(path+"day_03\\input.txt")
    val inputTest = readInputFile(path+"day_03\\inputTest.txt")

    fun solution() {
        println("--- Day 3 part 1 ---")
        part_1()
        println("--- Day 3 part 2 ---")
        part_2()
    }

    fun part_1() {
        val joltageValues: MutableList<String> = mutableListOf()
        var totalOutputJoltage = 0

        this.input.forEach {
            var highestNumIndex = 0
            var highNum = 0
            var secHighNum = 0

            for (i in 0 until it.length) {
                val num = it[i].toString().toInt()
                if (i < it.length-1 && num > highNum) {
                    highestNumIndex = i
                    highNum = num
                }
            }

            for (i in highestNumIndex+1 until it.length) {
                val num = it[i].toString().toInt()
                if (num > secHighNum) {
                    secHighNum = num
                }
            }
            joltageValues.add(highNum.toString()+secHighNum.toString())
        }

        for (joltage in joltageValues) {
            totalOutputJoltage += joltage.toInt()
        }

        println("Answer: ${totalOutputJoltage}")
    }

    fun part_2() {
        val joltageValues: MutableList<String> = mutableListOf()
        var totalOutputJoltage: Long = 0

        this.input.forEach {
            var joltageValueForLine: String = ""
            var digitNeeded = 12
            var digitLeft = digitNeeded
            var prevIndex = 0
            var currentPair: Pair<Int,Int> = Pair(0,0)

            currentPair = findHihghestNum(it, prevIndex, digitLeft)
            digitLeft -= 1
            prevIndex = currentPair.second
            joltageValueForLine += currentPair.first.toString()

            for (i in 0 until digitNeeded-1) {
                currentPair = findHihghestNum(it, prevIndex+1, digitLeft)
                digitLeft -= 1
                prevIndex = currentPair.second
                joltageValueForLine += currentPair.first.toString()
            }
            joltageValues.add(joltageValueForLine)
        }

        for(joltage in joltageValues)
            totalOutputJoltage += joltage.toLong()

        println("Answer: ${totalOutputJoltage}\n")
    }

    fun findHihghestNum(numberSequence: String, prevIndex: Int, digitLeft: Int): Pair<Int, Int> {
        var highestNum: Pair<Int,Int> = Pair(0,0)
        val numSeqLen = numberSequence.length

        for (index in prevIndex until numSeqLen) {
            if (index+digitLeft > numSeqLen)
                continue

            val num = numberSequence[index].toString().toInt()
            if (num > highestNum.first) {
                highestNum = Pair(num, index)
            }
        }

        return highestNum
    }


    fun readInputFile(filename: String): List<String> {
        val fileContent: List<String> = File(filename).readLines()

        return fileContent
    }
}