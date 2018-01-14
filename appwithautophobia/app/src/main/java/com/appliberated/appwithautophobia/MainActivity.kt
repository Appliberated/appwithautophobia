package com.appliberated.appwithautophobia

import android.app.Activity
import android.media.AudioManager
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Suggest that the Music audio stream volume should be changed by the hardware volume controls
        volumeControlStream = AudioManager.STREAM_MUSIC

        // Add the volume emoji to the sound tip (emoji in strings.xml crash the app on some Android versions)
        soundTip.text = getString(R.string.sound_tip, "\uD83D\uDD0A")
    }

    override fun onPause() {
        super.onPause()

        // Play the "come back to me" sound on the first indication that the user is leaving the activity,
        // but not when the activity is recreated with a new configuration (such as on screen rotation)
        if (!isChangingConfigurations) Util.playSoundRes(this, R.raw.come_back_to_me)
    }
}