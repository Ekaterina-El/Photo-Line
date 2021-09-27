package com.example.photoline.ui.auth

import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.utils.MAIN_ACTIVITY
import com.example.photoline.utils.hideBottomMenu

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    override fun onResume() {
        super.onResume()
        hideBottomMenu()
    }
}