package com.example.photoline.ui.feed

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.photoline.R
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment(R.layout.fragment_feed) {

    lateinit var feedRecyclerView: RecyclerView
    lateinit var feedRecyclerAdapter: FeedAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        feedRecyclerAdapter = FeedAdapter()
        feedRecyclerView = feed_recycler_view
        feedRecyclerView.addItemDecoration(FeedRecyclerDecoration(25))
        feedRecyclerView.adapter = feedRecyclerAdapter
        feedRecyclerAdapter.setPosts(posts)
    }
}