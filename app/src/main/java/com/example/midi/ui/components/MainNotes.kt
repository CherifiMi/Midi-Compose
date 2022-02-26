package com.example.midi.ui.components

import android.provider.ContactsContract
import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.midi.ui.theme.DarkPinkColor
import com.example.midi.ui.theme.LightPinkColor
import com.example.midi.ui.theme.Shapes
import com.example.midi.ui.theme.StrockColor
import com.example.midi.ui.viewModel.MainViewModel


@ExperimentalComposeUiApi
@Composable
fun MainNotes(viewModel: MainViewModel) {
    Row(
        Modifier
            .border(6.dp, StrockColor)
            .background(LightPinkColor)
            .fillMaxSize(),
    )
    {
        /*
        note(Ac, 466)
        note(Cc, 554)
        note(Dc, 622)
        note(Fc, 740)
        note(Gc, 830)

        note(ac, 932)
        note(cc, 1108)
        note(dc, 1244)*/

        Note(pitch = 440, viewModel)
        Note(pitch = 493, viewModel)
        Note(pitch = 523, viewModel)
        Note(pitch = 587, viewModel)
        Note(pitch = 659, viewModel)
        Note(pitch = 692, viewModel)
        Note(pitch = 784, viewModel)
        Note(pitch = 880, viewModel)
        Note(pitch = 986, viewModel)
        Note(pitch = 1046, viewModel)
        Note(pitch = 1174, viewModel)
        Note(pitch = 1368, viewModel)
    }
}

@ExperimentalComposeUiApi
@Composable
fun RowScope.Note(pitch: Int, viewModel: MainViewModel) {

    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier
            .fillMaxSize()
            .weight(1f)
    ){
        var x = remember{ mutableStateOf(0.dp) }
        var back = remember{ mutableStateOf(Color.White) }

        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(back.value),
            border = BorderStroke(4.dp, StrockColor),
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .fillMaxSize()
                .offset(x.value, 0.dp)
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            viewModel.startNote(pitch)
                            x.value = 4.dp
                            back.value = DarkPinkColor
                        }
                        MotionEvent.ACTION_UP -> {
                            viewModel.stopNote()
                            x.value = 0.dp
                            back.value = Color.White
                        }
                        else -> false
                    }
                    true
                }
        ){}


    }

}

