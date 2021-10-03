package com.example.photoline.ui.auth

import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.utils.hideBottomMenu

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onResume() {
        super.onResume()
        hideBottomMenu()
    }
}