package com.example.eptherou_rapidrecall


class RecallButton() {
    fun generateNumbers(digits: Int): IntArray {

        val numbers = IntArray(digits)

        for (i in numbers.indices){
            numbers[i] = ((1..9).random())
        }

        return numbers
    }
}
