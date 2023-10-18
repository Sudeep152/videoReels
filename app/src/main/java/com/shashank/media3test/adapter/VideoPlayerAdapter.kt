package com.shashank.media3test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.shashank.media3test.R
import com.shashank.media3test.VideoPlayerViewHolder
import com.shashank.media3test.data.VideoItem

class VideoPlayerAdapter(private val mList: List<VideoItem>, private val context: Context) :
    RecyclerView.Adapter<VideoPlayerViewHolder>() {
    private var player:ExoPlayer? = null
    init {
        player = ExoPlayer.Builder(context).build()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoPlayerViewHolder {
        return VideoPlayerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_video_single,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: VideoPlayerViewHolder, position: Int) {
        val binding = holder.binding
        val data = mList[position]
        binding.apply {
           // loadImage(imageUrl =data.thumbnails!! ,binding.myImage)
            val mediaItem = MediaItem.fromUri(data.videoUrl!!)
            player?.setMediaItem(mediaItem)
            binding.myPlayer.player =player
            player?.prepare()
            player?.play()
        }
    }

    private fun  loadImage(imageUrl:String,imageView: ImageView){
        Glide.with(context)
            .load(imageUrl)
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
            .into(imageView)

    }
}