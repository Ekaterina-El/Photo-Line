package com.example.photoline.data

data class Post(
    var postId: String,
    var userId: String,
    var time: String,
    var photoUrl: String,
    var likes: Int
)
