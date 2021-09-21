package com.example.photoline

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoline.ui.feed.FeedFragment
import com.example.photoline.utils.MAIN_ACTIVITY

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MAIN_ACTIVITY = this

        replaceFragment(FeedFragment(), false)
    }
}

fun replaceFragment(fragment: FeedFragment, addToBack: Boolean = true) {
    if (addToBack) {
        MAIN_ACTIVITY.supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    } else {
        MAIN_ACTIVITY.supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }

}