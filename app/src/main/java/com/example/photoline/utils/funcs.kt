package com.example.photoline.utils

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.photoline.R
import com.example.photoline.database.*
import com.example.photoline.ui.feed.FeedFragment

fun replaceFragment(fragment: Fragment, addToBack: Boolean = true) {
    if (addToBack) {
        MAIN_ACTIVITY.supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    } else {
        MAIN_ACTIVITY.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

fun showBottomMenu() {
    MAIN_ACTIVITY.mBottomMenu.visibility = View.VISIBLE
}

fun hideBottomMenu() {
    MAIN_ACTIVITY.mBottomMenu.visibility = View.GONE
}

fun showToast(text: String) {
    Toast.makeText(MAIN_ACTIVITY, text, Toast.LENGTH_LONG).show()
}

fun onFailureRegistration() {
    showToast("Error registration")
}

fun onSuccessRegistration(userData: MutableMap<String, Any>) {
    UID = AUTH.currentUser?.uid.toString()
    userData[CHILD_ID] = UID

    createUser(UID, userData) {
        replaceFragment(FeedFragment())
        showBottomMenu()
    }
}

fun createUser(uid: String, userData: MutableMap<String, Any>, onSuccess: () -> Unit) {
    REF_DATABASE_ROOT.child(NODE_USERS).child(uid).setValue(userData)
        .addOnSuccessListener {
            onSuccess()
        }
        .addOnFailureListener {
            showToast("Create note user in database: Error")
        }
}