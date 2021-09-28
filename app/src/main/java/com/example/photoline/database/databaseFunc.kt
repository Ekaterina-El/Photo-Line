package com.example.photoline.database

import com.example.photoline.ui.feed.FeedFragment
import com.example.photoline.utils.replaceFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
    REF_STORAGE_ROOT = FirebaseStorage.getInstance().reference

    UID = AUTH.currentUser?.uid.toString()
}

fun registrationUser(
    email: String,
    password: String,
    onFailure: () -> Unit,
    onSuccess: () -> Unit
) {
    AUTH.createUserWithEmailAndPassword(email, password)
        .addOnSuccessListener {
            onSuccess()
        }
        .addOnFailureListener {
            onFailure
        }
}

fun signOut() {
    AUTH.signOut()
    UID = "null"
    replaceFragment(FeedFragment())
}