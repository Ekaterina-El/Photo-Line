package com.example.photoline.ui.feed

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.photoline.R
import com.example.photoline.database.getUserByUID
import com.example.photoline.models.Post
import com.example.photoline.utils.downloadImageAndSet
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

    fun addPost(post: Post) {
        this.posts.add(post)
        notifyItemInserted(this.posts.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = posts[position]
        getUserByUID(data.userId) { userData ->

            holder.feedUserImage.downloadImageAndSet(userData.photoUrl)
            holder.feedUserName.text = userData.login

            holder.feedLikeBtn.setOnClickListener {
                Log.d("TAG", "Liked")
            }


            // TODO (convert time to string)
            holder.feedDate.text = data.time.toString()
            holder.feedLikeCounter.text = data.likes.toString()
            holder.feedImage.downloadImageAndSet(data.photoUrl)
        }
    }

    override fun getItemCount(): Int = posts.size
}
