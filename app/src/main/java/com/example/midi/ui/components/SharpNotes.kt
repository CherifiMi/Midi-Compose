package com.example.midi.ui.components

import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp
import com.example.midi.ui.theme.*
import com.example.midi.ui.viewModel.MainViewModel

@ExperimentalComposeUiApi
@Composable
fun SharpNotes(viewModel: MainViewModel) {
    Row(
        Modifier
            .background(Color.Transparent)
            .fillMaxSize(),
    )
    {
        SharpNote(466, viewModel)
        Spacer(modifier = Modifier
            .background(Color.Transparent)
            .weight(1f)
            .fillMaxSize())
        SharpNote(554, viewModel)
        SharpNote(622, viewModel)
        Spacer(modifier = Modifier
            .background(Color.Transparent)
            .weight(1f)
            .fillMaxSize())
        SharpNote(740, viewModel)
        SharpNote(830, viewModel)
        SharpNote(932, viewModel)
        Spacer(modifier = Modifier
            .background(Color.Transparent)
            .weight(1f)
            .fillMaxSize())
        SharpNote(1108, viewModel)
        SharpNote(1244, viewModel)
        Spacer(modifier = Modifier
            .background(Color.Transparent)
            .weight(1f)
            .fillMaxSize())
    }
}

@ExperimentalComposeUiApi
@Composable
fun RowScope.SharpNote(pitch: Int ,viewModel: MainViewModel) {

    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier
            .fillMaxSize()
            .weight(1f)
    ){

        Box(modifier = Modifier
            .height(148.dp)
            .width(44.dp)
            .offset(26.dp, 0.dp)
            .background(DarkBlueColor, RoundedCornerShape(15))
        )


        var x = remember{ mutableStateOf(0) }

        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(LightBlueColor),
            border = BorderStroke(4.dp, StrockColor),
            shape = RoundedCornerShape(15),
            modifier = Modifier
                .height(148.dp)
                .width(44.dp)
                .offset((22 + x.value).dp, 0.dp)
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            viewModel.startNote(pitch)
                            x.value = 4
                        }
                        MotionEvent.ACTION_UP -> {
                            viewModel.stopNote()
                            x.value = 0
                        }
                        else -> false
                    }
                    true
                }
        ){}
    }


}