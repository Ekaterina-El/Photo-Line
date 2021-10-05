package com.example.photoline.database

import com.example.photoline.models.User
import com.example.photoline.ui.feed.FeedFragment
import com.example.photoline.utils.NULL
import com.example.photoline.utils.replaceFragment
import com.example.photoline.utils.showToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

// ---- #Firebase -------
fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
    REF_STORAGE_ROOT = FirebaseStorage.getInstance().reference

    UID = AUTH.currentUser?.uid.toString()
}


// ---- #Account -------
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
            onFailure()
        }
}

fun loginUser(
    email: String,
    password: String,
    onFailure: () -> Unit,
    onSuccess: () -> Unit
) {
    AUTH.signInWithEmailAndPassword(email, password)
        .addOnSuccessListener { onSuccess() }
        .addOnFailureListener { onFailure() }
}

fun signOut() {
    AUTH.signOut()
    UID = NULL
    replaceFragment(FeedFragment())
}


// ---- #Users -------
fun getUserByUID(UID: String, onSuccess: (User) -> Unit) {
    val ref = REF_DATABASE_ROOT.child(NODE_USERS).child(UID).ref
    ref.addListenerForSingleValueEvent(AppValueEventListener {dataSnapshot ->
        onSuccess(dataSnapshot.getUser())
    })
}