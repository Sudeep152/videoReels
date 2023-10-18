package com.shashank.media3test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shashank.media3test.adapter.VideoPlayerAdapter
import com.shashank.media3test.data.Resources
import com.shashank.media3test.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoBinding
    private lateinit var adapter: VideoPlayerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = VideoPlayerAdapter(Resources.MEDIA_OBJECTS,this)
        binding.rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rv.adapter = adapter

    }
}