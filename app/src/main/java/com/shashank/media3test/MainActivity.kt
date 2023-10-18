package com.shashank.media3test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.media3.common.MediaItem
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
import com.shashank.media3test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var player: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        player = ExoPlayer.Builder(this).build()
        binding.myPlayer.player= player
        val mediaItem = MediaItem.Builder()
            .setUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4")
            .build()
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()

    }

    override fun onPause() {
        super.onPause()
        player.stop()
    }

    override fun onResume() {
        super.onResume()
        player.prepare()
        player.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}