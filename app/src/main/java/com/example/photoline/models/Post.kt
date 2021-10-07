package com.example.photoline.models

data class Post(
    var postId: String = "",
    var userId: String = "",
    var time: Long = 0,
    var photoUrl: String = "",
    var likes: Int = 0
)
