package com.example.midi

import android.content.Intent
import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.midi.ui.components.MainNotes
import com.example.midi.ui.components.SharpNotes
import com.example.midi.ui.theme.*
import com.example.midi.ui.viewModel.MainViewModel

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    //------------values
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideSystemBars()

        setContent {
            MidiTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(YellowBackColor)
                ){
                    Row(modifier = Modifier
                        .background(Color.Transparent)
                        .weight(4f)
                        .fillMaxSize()
                    ){
                        Box(modifier = Modifier
                            .weight(6f).background(LightPinkColor)
                            .fillMaxSize()
                        )
                        Box(modifier = Modifier
                            .weight(4f).background(LightBlueColor)
                            .fillMaxSize()
                        )
                    }

                    Box(modifier = Modifier
                        .weight(6f)
                        .fillMaxSize()
                    ){
                        MainNotes(mainViewModel)
                        SharpNotes(mainViewModel)
                    }

                }
            }
        }
    }

    private fun hideSystemBars() {
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return

        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

}

