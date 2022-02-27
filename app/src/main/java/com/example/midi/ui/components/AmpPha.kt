package com.example.midi.ui.components

import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midi.R
import com.example.midi.ui.theme.*
import com.example.midi.ui.viewModel.MainViewModel


@ExperimentalComposeUiApi
@Composable
fun RowScope.AmpPha(viewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .weight(4f)
            .fillMaxSize()
    ){
        Btn(viewModel,1)
        Spacer(modifier = Modifier.height(16.dp))
        Btn(viewModel,2)
    }
}

@ExperimentalComposeUiApi
@Composable
fun Btn(viewModel: MainViewModel, i: Int) {

    Box(
        contentAlignment = Alignment.Center
    )
    {
        Card(
            modifier = Modifier
                .height(48.dp)
                .width(234.dp)
                .offset(0.dp, 6.dp),
            shape = RoundedCornerShape(100),
            backgroundColor = DarkBlueColor
        ){}


    Row() {

        var y = remember{ mutableStateOf(0.dp) }

        OutlinedButton(
            modifier = Modifier
                .height(48.dp)
                .width(64.dp)
                .offset(4.dp, y.value)
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {

                            y.value = 6.dp
                            when(i){
                                1->viewModel.setAmp(1000)
                                2->viewModel.setPha(100)
                            }

                        }
                        MotionEvent.ACTION_UP -> {

                            y.value = 0.dp

                        }
                        else -> false
                    }
                    true
                },
            colors = ButtonDefaults.buttonColors(LightBlueColor),
            border = BorderStroke(4.dp, StrockColor),
            shape = RoundedCornerShape(100,5,5,100),
            onClick = { /*TODO*/ }
        ){
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.plus),
                contentDescription ="",
                tint = StrockColor
            )
        }

        Card(
            modifier = Modifier
                .height(48.dp)
                .width(116.dp),
            border = BorderStroke(4.dp, StrockColor),
            shape = RoundedCornerShape(5),
            backgroundColor = LightBlueColor
        ) {
            Box(contentAlignment = Alignment.Center){
                Text(
                    text = when(i){
                        1->viewModel.amp.value.toString() + "A"
                        2->viewModel.pha.value.toString() + ".0V"
                        else->{""}
                    },
                    style = TextStyle(
                        color = Color(0xff004A7A),
                        fontFamily = baloo,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )
                )
            }

        }

        var _y = remember{ mutableStateOf(0.dp) }

        OutlinedButton(
            modifier = Modifier
                .height(48.dp)
                .width(64.dp)
                .offset((-4).dp, _y.value)
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            _y.value = 6.dp
                            when(i){
                                1->viewModel.setAmp(-1000)
                                2->viewModel.setPha(-100)
                            }
                        }
                        MotionEvent.ACTION_UP -> {
                            _y.value = 0.dp
                        }
                        else -> false
                    }
                    true
                }
            ,
            colors = ButtonDefaults.buttonColors(LightBlueColor),
            border = BorderStroke(4.dp, StrockColor),
            shape = RoundedCornerShape(5,100,100,5),
            onClick = { /*TODO*/ }
        ){
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.min),
                contentDescription ="",
                tint = StrockColor
            )
        }
    }
    }
}