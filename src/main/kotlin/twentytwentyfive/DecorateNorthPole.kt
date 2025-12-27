package org.lyn.twentytwentyfive



class DecorateNorthPole {
    val resourcePath = "C:\\Users\\ander\\workspace\\AdventOfCode\\src\\main\\resources\\twentytwentyfive\\"
    val day_01 = Day_01(resourcePath)
    val day_02 = Day_02(resourcePath)
    val day_03 = Day_03(resourcePath)


    fun run() {
        day_01.solution()
        day_02.solution()
        day_03.solution()
    }
}