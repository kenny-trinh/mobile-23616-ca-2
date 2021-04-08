package com.example.kotlinyoutubelbta

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<MainViewHolder>() {

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return MainViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val video = homeFeed.videos.get(position)
        holder.itemView.textView_video_title?.text = video.name
        holder.itemView.textView_channel_name?.text =
            video.channel.name

        val thumbnailImageView = holder.itemView.imageView_video_thumbnail
        Picasso.with(holder.itemView.context).load(video.imageUrl).into(thumbnailImageView)

        val channelProfileImageView = holder.itemView.imageView_channel_profile
        Picasso.with(holder.itemView.context).load(video.channel.profileimageUrl)
            .into(channelProfileImageView)

        holder.video = video
    }
}

class MainViewHolder(val view: View, var video: Video? = null) : RecyclerView.ViewHolder(view) {

    companion object {
        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CourseDetailActivity::class.java)
            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)
            view.context.startActivity(intent)
        }
    }

}