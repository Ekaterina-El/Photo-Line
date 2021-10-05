package com.example.photoline.database

import com.example.photoline.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference

lateinit var REF_DATABASE_ROOT: DatabaseReference
lateinit var REF_STORAGE_ROOT: StorageReference
lateinit var AUTH: FirebaseAuth

lateinit var UID: String

const val NODE_USERS = "users"
const val CHILD_LOGIN = "login"
const val CHILD_EMAIL = "email"
const val CHILD_ID = "id"

