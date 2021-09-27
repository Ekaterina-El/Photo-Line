package com.example.photoline.ui.feed

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FeedRecyclerDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = space
        }
    }
}