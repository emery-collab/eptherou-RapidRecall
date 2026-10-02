package com.example.eptherou_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RecallScreen( onRecallButton: (Int) -> IntArray,
                  clickCounter: ClickCounter,
                  state: ScreenState,
                  modifier: Modifier = Modifier
) {
    // Set any vars here if I need later
    var numbers by remember { mutableStateOf(clickCounter.numbers) }

    var userGuess by remember { mutableStateOf("") }
    var position by remember { mutableStateOf(clickCounter.position)}
    var correct by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("") }

    var attempts by remember { mutableStateOf(clickCounter.attempts) }
    var correctAttempts by remember { mutableStateOf(clickCounter.correctAttempts) }
    var percentage by remember { mutableStateOf(clickCounter.percentage) }

    // When an array of numbers has been generated for play, start displaying them 1 by 1
    LaunchedEffect(numbers) {
        position = 0

        for (i in numbers.indices) {
            position = i

            state.waiting = false
            delay(2000)

            position = -1
            delay(200)
        }

        position = 0
        state.waiting = true
    }


    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        // Display gameplay button and text field if play boolean and waiting boolean are true, since we are waiting and have displayed answers
        if (state.play) {

            if  (state.waiting) {
            OutlinedTextField(value = userGuess, onValueChange = { userGuess = it }, label = { Text("Enter the number") })

            Button(
                onClick = {
                    answer = numbers[position].toString()
                    state.waiting = true

                    if (userGuess == answer) {
                        correct = "Correct"
                        attempts++
                        correctAttempts++
                    } else {
                        correct = "Incorrect"
                        attempts++
                    }


                    position++
                    userGuess = ""
                    answer = ""

                    if (position >= numbers.size) {
                        percentage = (correctAttempts.toDouble() / attempts) * 100
                        state.waiting = false
                        state.play = false
                        state.menu = true
                    }
                }
            ) {
                Text("Enter")
            }
                }
        }

        Text(text = correct, fontSize = 32.sp)


        // Display menu buttons if the boolean for menu is true, as well as the log and summary
        if (state.menu) {
            // Text Attribute
            Text(text = "Select Challenge Level", fontSize = 40.sp)

            Row(modifier = modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.Center) {
                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(1)
                    }
                ) {
                    Text("1")
                }

                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(2)
                    }
                ) {
                    Text("2")
                }

                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(3)
                    }
                ) {
                    Text("3")
                }

                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(4)
                    }
                ) {
                    Text("4")
                }

                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(5)
                    }
                ) {
                    Text("5")
                }
            }

            Row(modifier = modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.Center) {

                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(6)
                    }
                ) {
                    Text("6")
                }

                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(7)
                    }
                ) {
                    Text("7")
                }

                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(8)
                    }
                ) {
                    Text("8")
                }

                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(9)
                    }
                ) {
                    Text("9")
                }


                Button(
                    modifier = Modifier.padding(6.dp),
                    onClick = {
                        // Start the game
                        userGuess = ""
                        correct = ""
                        position = 0
                        state.menu = false
                        state.play = true
                        state.waiting = false
                        numbers = onRecallButton(10)
                    }
                ) {
                    Text("10")
                }
            }

            Text( text = "Log: ", fontSize = 30.sp)

            Text( text = "\nSummary:\n\nAttempts $attempts\nCorrect Attempts $correctAttempts\nPercentage $percentage%", fontSize = 30.sp)

        }

        // If we are in play, and the position is valid, (not -1), and we're not waiting for input, display the number
        if (state.play && !state.waiting && position >= 0 && position < numbers.size) {
            Text( text = numbers[position].toString(), fontSize = 40.sp)
        }
    }
}
