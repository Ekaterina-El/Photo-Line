package com.example.photoline.ui.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.photoline.R
import com.example.photoline.data.Post
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {
    private val posts = arrayOf(
        Post(
            "id1",
            "13:01",
            "https://images.unsplash.com/photo-1631962633037-622e125d6318?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
            124
        ),
        Post(
            "id2",
            "13:01",
            "https://images.unsplash.com/photo-1631728884184-98ba78f39d1c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
            81
        )
    )

    lateinit var feedRecyclerView: RecyclerView
    lateinit var feedRecyclerAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        feedRecyclerAdapter = FeedAdapter()
        feedRecyclerView = feed_rv
        feedRecyclerView.addItemDecoration(FeedRecyclerDecoration(25))
        feedRecyclerView.adapter = feedRecyclerAdapter
        feedRecyclerAdapter.setPosts(posts)
    }
}