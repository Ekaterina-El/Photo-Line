package com.example.photoline.database

import com.example.photoline.models.User
import com.google.firebase.database.DataSnapshot

fun DataSnapshot.getUser(): User {
    return this.getValue(User::class.java) ?: User()
}