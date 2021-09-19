package com.example.photoline.data

data class Post(
    var ownerId: String,
    var time: String,
    var photoUrl: String,
    var likes: Int
)
