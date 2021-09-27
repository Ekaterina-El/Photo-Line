package com.example.photoline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoline.database.initFirebase
import com.example.photoline.ui.account.AccountFragment
import com.example.photoline.ui.feed.FeedFragment
import com.example.photoline.ui.splash.SplashFragment
import com.example.photoline.utils.MAIN_ACTIVITY
import com.example.photoline.utils.replaceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mBottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFirebase()
        MAIN_ACTIVITY = this
        initBottomMenu()

        replaceFragment(SplashFragment())
    }

    private fun initBottomMenu() {
        mBottomMenu = button_menu
        mBottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_feed -> replaceFragment(FeedFragment())
                R.id.menu_account -> replaceFragment(AccountFragment())
            }
            true
        }
    }
}

