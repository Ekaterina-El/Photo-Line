package com.example.photoline.ui.account

import android.view.View
import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.database.UID
import com.example.photoline.database.getUserByUID
import com.example.photoline.database.sendPost
import com.example.photoline.database.signOut
import com.example.photoline.models.Post
import com.example.photoline.models.User
import com.example.photoline.ui.auth.LoginFragment
import com.example.photoline.ui.auth.RegistrationFragment
import com.example.photoline.utils.NULL
import com.example.photoline.utils.downloadImageAndSet
import com.example.photoline.utils.replaceFragment
import com.example.photoline.utils.showBottomMenu
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : Fragment(R.layout.fragment_account) {
    private lateinit var userData: User

    override fun onResume() {
        super.onResume()

        showBottomMenu()
        caseView()
    }

    private fun caseView() {
        if (UID != NULL) {
            viewProfile()
        } else {
            viewUnauthorizedProfile()
        }
    }

    private fun viewUnauthorizedProfile() {
        viewLinksForLogin()
        addListenersForLogin()
    }

    private fun addListenersForLogin() {
        account_log_in.setOnClickListener { replaceFragment(LoginFragment(), false) }
        account_registration.setOnClickListener {
            replaceFragment(
                RegistrationFragment(),
                false
            )
        }
    }

    private fun viewLinksForLogin() {
        authorized_profile.visibility = View.GONE
        unauthorized_profile.visibility = View.VISIBLE
    }

    private fun viewProfile() {
        viewProfileData()
        getUserData()
        addListenerForAuthProfile()
    }

    private fun addListenerForAuthProfile() {
        account_sign_out.setOnClickListener {
            signOut()
        }

        account_new_post.setOnClickListener {
            sendPost(
                Post(
                    "",
                    "",
                    "",
                    "https://images.unsplash.com/photo-1421218108559-eb1ff78357f5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1332&q=80",
                    0
                )
            )
        }
    }

    private fun getUserData() {
        getUserByUID(UID) { user ->
            userData = user
            updateUIAccount()
        }
    }

    private fun viewProfileData() {
        authorized_profile.visibility = View.VISIBLE
        unauthorized_profile.visibility = View.GONE
    }

    private fun updateUIAccount() {
        account_profile_image.downloadImageAndSet(userData.photoUrl)
        account_profile_login.text = userData.login
    }
}