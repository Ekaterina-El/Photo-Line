package com.example.photoline.database

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

class AppChildEventListener(
    val onAdded: (DataSnapshot) -> Unit
): ChildEventListener {
    override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
        onAdded(snapshot)
    }
    override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
    override fun onChildRemoved(snapshot: DataSnapshot) {}
    override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
    override fun onCancelled(error: DatabaseError) {}
}