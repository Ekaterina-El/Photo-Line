package com.example.photoline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoline.ui.feed.AccountFragment
import com.example.photoline.ui.feed.FeedFragment
import com.example.photoline.ui.feed.SplashFragment
import com.example.photoline.utils.MAIN_ACTIVITY
import com.example.photoline.utils.replaceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mButtomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MAIN_ACTIVITY = this
        mButtomMenu = button_menu

        mButtomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_feed -> replaceFragment(FeedFragment())
                R.id.menu_account -> replaceFragment(AccountFragment())
            }
            true
        }

        replaceFragment(SplashFragment())
    }
}

