 <h1 align="center">MIDI APP</h1>

<p align="center">  
 🎹 this app is a musical instrument digital interface and a musical notes Oscilloscope.
</p>
</br>

![Frame 4](https://user-images.githubusercontent.com/98290339/177842173-e72c2fce-4e51-4708-93f2-277c1e719a08.png)


#### Ui Made in [Figma](https://www.figma.com/file/mtCF10n9wphsv1JdKG00uQ/Ux-and-shi?node-id=398%3A333)



## Tech stack & Open-source libraries

- Jetpack Compose
- Architecture
  -MVVM Architecture (View - ViewBinding - ViewModel - Model)
- [Processing](https://processing.org/) for the [Sine Waves Oscilloscope](https://github.com/CherifiMi/sine-waves)
- [Audio Track](https://developer.android.com/reference/android/media/AudioTrack)
- [Full screen mode](https://developer.android.com/training/system-ui/immersive)
- [setOnTouchListener](https://developer.android.com/reference/android/view/View.OnTouchListener)
- [landscape mode](https://developer.android.com/reference/androidx/browser/trusted/ScreenOrientation)



## What I learned
- using [Audio Track](https://developer.android.com/reference/android/media/AudioTrack) to creat sound from a sine wave
- using [setOnTouchListener](https://developer.android.com/reference/android/view/View.OnTouchListener) to detect if the btn is pressed or released
- using [Full screen mode](https://developer.android.com/training/system-ui/immersive) and hiding system and navigation bars
- setting the app to be only in [landscape mode](https://developer.android.com/reference/androidx/browser/trusted/ScreenOrientation)
- saving mutableStatesOF data in the viewmodel and updaing them in real time across multiple classes


## Architecture
![image](https://user-images.githubusercontent.com/98290339/152096381-2a8898d3-c351-4032-979d-ebc836e46332.png)
