package com.example.eptherou_rapidrecall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.eptherou_rapidrecall.ui.theme.EptherouRapidRecallTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val recallButton = RecallButton()
        val recallCounter = RecallCounter("Correct?", 0, 0, 0, 0, "", 0.0)
        val state = ScreenState()
        setContent {
            EptherouRapidRecallTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecallScreen(
                        onRecallButton = { digits -> recallButton.generateNumbers(digits) },
                        recallCounter = recallCounter,
                        state = state,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}