package com.appliberated.appwithautophobia

import android.content.Context
import android.media.MediaPlayer


object Util {

    /**
     * Play a sound resource, by creating and releasing a MediaPlayer instance.
     */
    fun playSoundRes(context: Context, resId: Int) {
        var mediaPlayer: MediaPlayer? = MediaPlayer.create(context, resId)

        fun cleanupPlayer() {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }

        mediaPlayer?.setOnCompletionListener { cleanupPlayer() }
        mediaPlayer?.setOnErrorListener { _, _, _ -> cleanupPlayer(); true }
        mediaPlayer?.start()
    }
}

