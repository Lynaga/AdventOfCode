package twentytwentyfive;

import java.io.File

class Day_04(path: String) {
    val input = readInputFile(path+"day_04\\input.txt")
    val inputTest = readInputFile(path+"day_04\\inputTest.txt")

    fun solution() {
        println("--- Day 2 part 1 ---")
        part_1()
        println("--- Day 2 part 2 ---")
        part_2()
    }

    fun part_1() {}

    fun part_2() {}

    fun readInputFile(filename: String): List<String> {
        val fileInput = File(filename).readText()
        val productIds: List<String> = fileInput.split(',')

        return productIds
    }
}
