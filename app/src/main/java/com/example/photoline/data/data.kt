package com.example.photoline.data

val users = arrayListOf(
    User(
        "id1",
        "https://images.unsplash.com/photo-1586287011575-a23134f797f9?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80",
        "vasa_na_sene"
    ),
    User(
        "id2",
        "https://images.unsplash.com/photo-1597225156148-b82b8b4d0c7e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80",
        "mir.ko"
    )
)

fun getUserById(id: String): User? {
    for (user in users) {
        if (user.userId == id) {
            return user
        }
    }
    return null
}

var posts = arrayOf(
    Post(
        "id1",
        "id1",
        "13:31",
        "https://images.unsplash.com/photo-1631962633037-622e125d6318?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
        124
    ),
    Post(
        "id2",
        "id2",
        "13:01",
        "https://images.unsplash.com/photo-1631728884184-98ba78f39d1c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80",
        81
    ),

    Post(
        "id1",
        "id2",
        "12:58",
        "https://images.unsplash.com/photo-1632252387383-2e53ff6bfd62?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=387&q=80",
        143
    ),
)