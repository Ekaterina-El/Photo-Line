package com.example.photoline.utils

import androidx.fragment.app.Fragment
import com.example.photoline.R

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