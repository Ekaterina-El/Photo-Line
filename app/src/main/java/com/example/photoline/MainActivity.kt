package com.example.photoline

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoline.ui.feed.SplashFragment
import com.example.photoline.utils.MAIN_ACTIVITY
import com.example.photoline.utils.replaceFragment

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MAIN_ACTIVITY = this

        replaceFragment(SplashFragment(),)
    }
}

