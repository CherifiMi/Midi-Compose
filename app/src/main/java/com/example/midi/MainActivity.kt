package com.example.midi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.FragmentActivity
import com.example.midi.ui.components.*
import com.example.midi.ui.theme.*
import com.example.midi.ui.viewModel.MainViewModel
import processing.android.CompatUtils
import processing.android.PFragment
import processing.core.PApplet

@ExperimentalComposeUiApi
class MainActivity : FragmentActivity() {

    //------------values
    private val mainViewModel: MainViewModel by viewModels()
    var sketch: PApplet? = null


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

                        Card(
                            shape = RoundedCornerShape(32),
                            modifier = Modifier
                                .weight(6f)
                                .background(Color.Transparent)
                                .fillMaxSize()
                                .padding(32.dp)
                                .border(6.dp,
                                    StrockColor,
                                    RoundedCornerShape(32))
                                .background(LightPinkColor,
                                    RoundedCornerShape(32))
                        )
                        {
                            AndroidView(
                                factory = { context: Context ->
                                    val view = LayoutInflater.from(context)
                                        .inflate(R.layout.wave_layout, null, false)

                                    view.id = CompatUtils.getUniqueViewId()
                                    sketch = Oscilloscope(mainViewModel)
                                    val fragment = PFragment(sketch)
                                    fragment.setView(view, this@MainActivity)

                                    view
                                })
                        }

                        AmpPha(mainViewModel)
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

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        sketch?.onRequestPermissionsResult(
            requestCode, permissions, grantResults
        )
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }
}