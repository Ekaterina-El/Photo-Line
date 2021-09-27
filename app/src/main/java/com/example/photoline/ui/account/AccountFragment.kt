package com.example.photoline.ui.account

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.database.UID


class AccountFragment : Fragment(R.layout.fragment_account) {
    override fun onResume() {
        super.onResume()

        if (UID != "null") {
            Log.d("Authed", "Yes")
        } else {
            Log.d("Authed", "No")
        }
    }
}