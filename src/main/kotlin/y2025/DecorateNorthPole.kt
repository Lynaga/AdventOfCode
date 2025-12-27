package org.lyn.y2025


class DecorateNorthPole {
    val resourcePath = "C:\\Users\\ander\\workspace\\AdventOfCode\\src\\main\\resources\\y2025\\"
    val day_01 = Day_01(resourcePath)
    val day_02 = Day_02(resourcePath)
    val day_03 = Day_03(resourcePath)
    val day_04 = Day_04(resourcePath)


    fun run() {
        day_01.solution()
        day_02.solution()
        day_03.solution()
        day_04.solution()
    }
}