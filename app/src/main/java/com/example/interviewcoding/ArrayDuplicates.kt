package com.example.interviewcoding

fun main() {
    println(getDuplicates(listOf(16, 22, 99, 57, 62, 100, 12, 88, 100, 46, 99)))
}

fun getDuplicates(input: List<Int>): List<Int> {
    val duplicates = mutableSetOf<Int>()
    var current: Int
    for(i in input.indices) {
        current = input[i]
        for (j in input.indices) {
            if (i != j && input[j] == current) {
                duplicates.add(input[j])
            }
        }
    }
    return duplicates.toList()
}