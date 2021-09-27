package com.example.photoline.database

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
    REF_STORAGE_ROOT = FirebaseStorage.getInstance().reference

    UID = AUTH.currentUser?.uid.toString()
}