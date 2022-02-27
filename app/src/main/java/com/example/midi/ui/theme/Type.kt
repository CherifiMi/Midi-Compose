package com.example.midi.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.midi.R

// Set of Material typography styles to start with

val baloo = FontFamily(
    Font(R.font.baloo_regular, weight = FontWeight.Normal),
    Font(R.font.baloo_medium, weight = FontWeight.Medium),
    Font(R.font.baloo_bold, weight = FontWeight.Bold),
    Font(R.font.baloo_semibold, weight = FontWeight.SemiBold),
    Font(R.font.baloo_extrabold, weight = FontWeight.ExtraBold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)