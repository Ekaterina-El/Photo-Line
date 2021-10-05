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

fun getUserByUID(UID: String, onSuccess: (User) -> Unit) {
    val ref = REF_DATABASE_ROOT.child(NODE_USERS).child(UID).ref
    ref.addListenerForSingleValueEvent(AppValueEventListener {dataSnapshot ->
        onSuccess(dataSnapshot.getUser())
    })
}

// TODO (вырнестни в отдельный файл)
class AppValueEventListener(
    val onError: (DatabaseError) -> Unit = {},
    val onSuccess: (DataSnapshot) -> Unit
) : ValueEventListener {
    override fun onDataChange(snapshot: DataSnapshot) {
        onSuccess(snapshot)
    }

    override fun onCancelled(error: DatabaseError) {
        onError(error)
    }

}
// TODO (вырнестни в отдельный файл)
fun DataSnapshot.getUser(): User {
    return this.getValue(User::class.java) ?: User()
}