package com.example.midi.ui.viewModel

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    /*
    val taskprio = mutableStateOf(0)

    fun updateIdValue(b:Int){
        this.updatetaskid.value = b
    }
    */

    //--------------------values
    var isPlaying: Boolean = false
    lateinit var Track: AudioTrack
    val Fs: Int = 44100
    val buffLength: Int = AudioTrack.getMinBufferSize(Fs, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT)

    //----------------changes
    var amplitude = 42767
    var phase = 0
    var oum = 8

    fun startNote(i: Int){
        Thread {
            initTrack()
            startPlaying()
            playback(i)
        }.start()
    }

    fun stopNote(){
        stopPlaying()
    }


    private fun initTrack() {
        Track = AudioTrack(
            AudioManager.MODE_NORMAL, Fs, AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT, buffLength, AudioTrack.MODE_STREAM
        )
    }

    private fun playback(i: Int) {
        val frame_out = ShortArray(buffLength)
        val frequency = i



        val twopi: Double = oum.toDouble() * Math.atan(1.0)
        var ph = phase.toDouble()

        while (isPlaying) {
            for (i in 0 until buffLength) {
                frame_out[i] = (amplitude * Math.sin(ph)).toInt().toShort()
                ph += twopi * frequency / Fs
                if (phase > twopi) {
                    ph -= twopi
                }
            }
            Track.write(frame_out, 0, buffLength)
        }
    }

    private fun startPlaying() {
        Track.play()
        isPlaying = true
    }

    private fun stopPlaying() {
        if (isPlaying) {
            isPlaying = false
            // Stop playing the audio data and release the resources
            Track.stop()
            Track.release()
        }
    }

}