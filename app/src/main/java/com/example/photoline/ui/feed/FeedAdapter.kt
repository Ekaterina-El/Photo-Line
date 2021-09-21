package com.example.photoline.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.photoline.R
import com.example.photoline.data.Post
import com.example.photoline.utils.downloadImageAndSet
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val feedUserImage: CircleImageView = itemView.feed_user_avatar_image
        val feedUserName: TextView = itemView.feed_user_name
        val feedDate: TextView = itemView.feed_date
        val feedLikeBtn: LinearLayout = itemView.feed_like_btn
        val feedLikeCounter: TextView = itemView.feed_like_counter
        val feedImage: ImageView = itemView.feed_image
    }

    private var posts = mutableListOf<Post>()
    fun setPosts(posts: Array<Post>) {
        this.posts = posts.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = posts[position]
        var userData = getUserById(data.userId)

        if (userData != null) {
            holder.feedUserImage.downloadImageAndSet(userData.photoUrl)
            holder.feedUserName.text = userData.name
        }

        holder.feedDate.text = data.time
        holder.feedLikeCounter.text = data.likes.toString()
        holder.feedImage.downloadImageAndSet(data.photoUrl)
    }

    override fun getItemCount(): Int = posts.size
}
