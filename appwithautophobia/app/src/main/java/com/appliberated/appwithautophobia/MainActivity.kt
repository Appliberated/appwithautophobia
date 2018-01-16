/*
 * Copyright (C) 2018 Appliberated
 * https://www.appliberated.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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