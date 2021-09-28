package com.example.photoline.ui.account

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.database.UID
import com.example.photoline.database.signOut
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : Fragment(R.layout.fragment_account) {
    override fun onResume() {
        super.onResume()

        account_sign_out.setOnClickListener {
            signOut()
        }
    }
}