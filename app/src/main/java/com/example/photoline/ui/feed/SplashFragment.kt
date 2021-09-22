package com.example.photoline.ui.feed

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.utils.AppCountTimer
import com.example.photoline.utils.replaceFragment

class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val timerChangeReplace = AppCountTimer(3000, 1000, {}) {
            replaceFragment(FeedFragment(), false)
        }
        timerChangeReplace.start()
    }

}

