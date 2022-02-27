package com.example.midi.ui.components

import com.example.midi.ui.viewModel.MainViewModel
import processing.core.PApplet

class Oscilloscope(var mainViewModel: MainViewModel): PApplet() {

    //--------------values

    //var period: Float = 1.0f

    var xspacing: Int = 1
    var w: Int = 0
    var theta: Float = 0.0f
    var amplitude: Float = 40.0f
    var dx: Float = 0.0f
    lateinit var yvalues: FloatArray



    override fun setup() {
        w = width+16
    }

    override fun draw() {
        var period: Float = mainViewModel.num.value
        dx = (TWO_PI / period) * xspacing*2
        yvalues = FloatArray(w / xspacing)
        background(255f, 176f, 205f)
        calcWave()
        renderWave()
    }


    fun calcWave() {
        theta += 0.02f
        var x = theta
        for (i in 0 until yvalues.size) {
            yvalues[i] = sin(x) * amplitude
            x += dx
        }
    }

    fun renderWave() {
        noStroke()
        for (x in 0 until yvalues.size) {
            fill(2f, 116f, 189f)
            ellipse((x * xspacing).toFloat(), height / 2 + yvalues[x], 18f, 18f)
        }
    }


}