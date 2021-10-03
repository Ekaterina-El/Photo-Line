package com.example.photoline.ui.auth

import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.database.AUTH
import com.example.photoline.database.UID
import com.example.photoline.database.loginUser
import com.example.photoline.ui.feed.FeedFragment
import com.example.photoline.utils.hideBottomMenu
import com.example.photoline.utils.replaceFragment
import com.example.photoline.utils.showBottomMenu
import com.example.photoline.utils.showToast
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onResume() {
        super.onResume()
        hideBottomMenu()

        btn_login_next.setOnClickListener {
            startLoginUser()
        }
    }

    private fun startLoginUser() {
        val email = login_et_email.text.toString().trim()
        val password = login_et_pass.text.toString().trim()

        loginUser(email, password, {
            showToast("Login: ERROR")
        }) {
            UID = AUTH.currentUser?.uid.toString()
            replaceFragment(FeedFragment())
            showBottomMenu()
        }
    }
}