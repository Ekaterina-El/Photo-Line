package com.example.photoline.database

import com.example.photoline.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference

// --- #References ----
lateinit var REF_DATABASE_ROOT: DatabaseReference
lateinit var REF_STORAGE_ROOT: StorageReference
lateinit var AUTH: FirebaseAuth

// ---- #Account data -------
lateinit var UID: String


// ---- #Node Users ----
const val NODE_USERS = "users"
const val CHILD_LOGIN = "login"
const val CHILD_EMAIL = "email"
const val CHILD_ID = "id"

// ---- #Node Posts ----
const val NODE_POSTS = "posts"
val CHILD_POST_ID = "postId"
val CHILD_USER_ID = "userId"
val CHILD_LIKES = "likes"
val CHILD_TIME = "time"
val CHILD_PHOTO_URL = "photoUrl"