package com.example.photoline.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.ui.feed.FeedFragment
import com.example.photoline.utils.AppCountTimer
import com.example.photoline.utils.hideBottomMenu
import com.example.photoline.utils.replaceFragment
import com.example.photoline.utils.showBottomMenu

class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val timerChangeReplace = AppCountTimer(3000, 1000, {}) {
            /*if (UID != "null") {
                replaceFragment(FeedFragment(), false)
            } else {
                replaceFragment(RegistrationFragment(), false)
            }*/
            replaceFragment(FeedFragment(), false)

        }
        timerChangeReplace.start()
    }

    override fun onResume() {
        super.onResume()
        hideBottomMenu()
    }

    override fun onStop() {
        super.onStop()
        showBottomMenu()
    }
}

