package twentytwentyfive;

import java.io.File

// Part 1: 1451
// Part 2: 8701

class Day_04(path: String) {
    val input = readInputFile(path+"day_04\\input.txt")
    val inputTest = readInputFile(path+"day_04\\inputTest.txt")


    fun solution() {
        println("--- Day 2 part 1 ---")
        part_1()
        println("--- Day 2 part 2 ---")
        part_2()
    }

    fun part_1() {
        val removedRollsGrid = checkAllAdjustedPosForRolls(input)
        val numberOfRemovedRolls = countRemovedRolls(removedRollsGrid)

        println("Answer is: ${numberOfRemovedRolls}")
    }

    fun part_2() {
        var grid = checkAllAdjustedPosForRolls(input)
        var numberOfRemovedRolls = countRemovedRolls(grid)
        var totalNumberOfRemovedRolls = numberOfRemovedRolls

        while (numberOfRemovedRolls != 0) {
            grid = checkAllAdjustedPosForRolls(grid)
            numberOfRemovedRolls = countRemovedRolls(grid)
            totalNumberOfRemovedRolls += numberOfRemovedRolls
        }

        println("Answer is: ${totalNumberOfRemovedRolls}")

    }

    fun checkAllAdjustedPosForRolls(grid: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
        val outputGrid = grid.map { it.toMutableList() }.toMutableList()
        val maxRow = grid.size
        val maxColumn = grid[0].size
        val maxAdjustedRolls = 4
        var adjustedRolls: Int

        for (y in 0 until maxRow) {
            for (x in 0 until maxColumn) {
                if (grid[y][x] == "@") {

                    adjustedRolls = checkAdjustedPosForRolls(grid, maxRow, maxColumn, x, y)

                    if (adjustedRolls < maxAdjustedRolls) {
                        outputGrid[y][x] = "X"
                    }
                }
            }
        }

        return outputGrid
    }

    fun checkAdjustedPosForRolls(grid: MutableList<MutableList<String>>, maxRow: Int, maxColumn: Int, x: Int, y: Int): Int {
        var adjustedRolls = 0
        var spot: String
        var spot_x: Int
        var spot_y: Int

        for (diff_y in -1 .. 1) {
            for (diff_x in -1 .. 1) {
                if (diff_x == 0 && diff_y == 0)
                    continue

                spot_x = diff_x+x
                spot_y = diff_y+y

                if ((spot_x in 0 until maxColumn) &&
                    (spot_y in 0 until maxRow)) {


                    spot = grid[spot_y][spot_x]

                    if (spot == "@")
                        adjustedRolls += 1
                }
            }
        }

        return adjustedRolls
    }

    fun countRemovedRolls(grid: MutableList<MutableList<String>>): Int {
        var removedRolls = 0

        for (row in grid) {
            for(i in 0 until row.size)
                if (row[i] == "X") {
                    removedRolls += 1
                    row[i] = "."
                }
        }

        return removedRolls
    }

    fun readInputFile(filename: String): MutableList<MutableList<String>> {
        val fileInput = File(filename).readLines()
        val grid = mutableListOf<MutableList<String>>()
        var row: MutableList<String>

        fileInput.forEach {
            row = mutableListOf()
            it.forEach { ch -> row.add(ch.toString()) }
            grid.add(row)
        }

        return grid
    }

    fun printGrid(grid: MutableList<MutableList<String>>) {
        println("Printing grid")

        for (row in grid){
            println(row)
        }
    }
}
