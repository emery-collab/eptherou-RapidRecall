package com.example.eptherou_rapidrecall

data class RecallCounter (
    var correct: String,
    var currentNumber: Int,
    var position: Int,

    var attempts: Int,
    var correctAttempts: Int,
    var answer: String,
    var percentage: Double,

    var numbers: IntArray = intArrayOf()
)