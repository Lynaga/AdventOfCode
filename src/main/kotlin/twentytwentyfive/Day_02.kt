package org.lyn.twentytwentyfive

import java.io.File
import kotlin.collections.plusAssign

// Part 1: 31210613313
// Part 2: 41823587546

class Day_02(path: String) {
    val input = readInputFile(path+"day_02\\input.txt")
    val inputTest = readInputFile(path+"day_02\\inputTest.txt")

    fun solution() {
        println("--- Day 2 part 1 ---")
        part_1()
        println("--- Day 2 part 2 ---")
        part_2()
    }

    fun part_1() {
        val invalidProductIds: MutableList<String> = mutableListOf()
        this.input.forEach { invalidProductIds += getInvalidProductIdsPartOne(it) }

        println("Answer: ${addingAllInvalidProductIds(invalidProductIds)}")
    }

    // Rule. Product Id is invalid if a sequence of digits repeat twice.
    // example:
    // 11-22: 11 and 22 are invalid
    // 998-1012: 1010 is invalid (10 repeat twice)
    fun getInvalidProductIdsPartOne(productRange: String): MutableList<String> {
        val invalidProductIds: MutableList<String> = mutableListOf()

        val productIdRange: List<String> = productRange.split('-')
        val productIdFrom = productIdRange.first().toLong()
        val productIdTo = productIdRange.last().toLong()

        for (number in productIdFrom..productIdTo) {
            val numberString = number.toString()
            val numberDigits = numberString.length

            if (numberDigits.mod(2) == 1)
                continue

            if (checkProductIdForInvalidId(numberString))
                invalidProductIds.add(numberString)
        }
        return invalidProductIds
    }

    fun addingAllInvalidProductIds(invalidProductIds: MutableList<String>): Long {
        var result: Long = 0

        invalidProductIds.forEach { result += it.toLong() }

        return result
    }

    fun checkProductIdForInvalidId(number: String): Boolean {
        val halfLength = number.length/2
        val firstHalf = number.substring(0,halfLength)
        val secondHalf = number.substring(halfLength)

        return firstHalf.equals(secondHalf)
    }

    fun part_2() {
        val invalidProductIds: MutableList<String> = mutableListOf()
        this.input.forEach { invalidProductIds += getInvalidProductIdsPartTwo(it) }

        println("Answer: ${addingAllInvalidProductIds(invalidProductIds)}\n")
    }

    // Rule. Product Id is invalid if a sequence of digits repeat at least twice.
    // example:
    // 11-22: 11 and 22 are invalid
    // 998-1012: 999 and 1010 is invalid (999 repeat three times and 10 repeat twice)
    fun getInvalidProductIdsPartTwo(productRange: String): MutableList<String> {
        val invalidProductIds: MutableList<String> = mutableListOf()
        val productIdRange:List<String> = productRange.split('-')
        val productIdFrom = productIdRange.first().toLong()
        val productIdTo = productIdRange.last().toLong()

        for (prodId in productIdFrom..productIdTo) {
            val productId = prodId.toString()
            if (checkProductId(productId))
                invalidProductIds.add(productId)
        }
        return invalidProductIds
    }

    fun checkProductId(productId: String): Boolean {
        val numLength = productId.length

        for (i in 1 until numLength) {
            val amountOfSplits = numLength.mod(i)
            if (amountOfSplits != 0)
                continue

            if (isProductIdInvalid(productId, i))
                return true
        }
        return false
    }

    fun isProductIdInvalid(productId: String, amountOfSplits: Int): Boolean {
        val productIdChunks = productId.chunked(amountOfSplits)

        for(i in 0 until productIdChunks.size-1)
            if (productIdChunks[i] != productIdChunks[i+1])
                return false

        return true
    }

    fun readInputFile(filename: String): List<String> {
        val fileInput = File(filename).readText()
        val productIds: List<String> = fileInput.split(',')

        return productIds
    }
}