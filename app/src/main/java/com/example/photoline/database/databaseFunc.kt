package com.example.photoline.database

import android.util.Log
import com.example.photoline.models.Post
import com.example.photoline.models.User
import com.example.photoline.ui.feed.FeedFragment
import com.example.photoline.utils.NULL
import com.example.photoline.utils.replaceFragment
import com.example.photoline.utils.showToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
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
    ref.addListenerForSingleValueEvent(AppValueEventListener { dataSnapshot ->
        onSuccess(dataSnapshot.getUser())
    })
}


// ---- #Posts -------
fun sendPost(post: Post) {
    // TODO: (Refactoring)
    val postsRef = REF_DATABASE_ROOT.child(NODE_POSTS)
    val postKey = postsRef.push().key!!

    val postInfo = mutableMapOf<String, Any>()
    postInfo[CHILD_POST_ID] = postKey
    postInfo[CHILD_USER_ID] = UID
    postInfo[CHILD_LIKES] = 0
    postInfo[CHILD_PHOTO_URL] = post.photoUrl
    postInfo[CHILD_TIME] = ServerValue.TIMESTAMP

    postsRef.child(postKey).setValue(postInfo)
        .addOnSuccessListener {
            showToast("Post send: Success")
        }
        .addOnFailureListener {
            showToast("Post send: Error")
        }
}

fun loadPosts(
    onAdded: (Post) -> Unit
) {
    val postsRef = REF_DATABASE_ROOT.child(NODE_POSTS)
    postsRef.addChildEventListener(AppChildEventListener { snapshot ->
        onAdded(snapshot.getValue(Post::class.java) ?: Post(NULL))
    })
}

