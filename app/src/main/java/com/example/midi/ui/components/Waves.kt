package com.example.midi.ui.components

import android.content.Context
import android.view.LayoutInflater
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.midi.R
import com.example.midi.ui.components.osilloscope.Oscilloscope
import com.example.midi.ui.theme.LightPinkColor
import com.example.midi.ui.theme.StrockColor
import com.example.midi.ui.viewModel.MainViewModel
import processing.android.PFragment

lateinit var sketch: Oscilloscope

@Composable
fun RowScope.Waves() {
    Box(modifier = Modifier
        .weight(6f)
        .background(Color.Transparent)
        .fillMaxSize()
        .padding(32.dp)
        .border(6.dp, StrockColor, RoundedCornerShape(32))
        .background(LightPinkColor, RoundedCornerShape(32))
    ){

    }
}

