package com.byfrunze.motozip.auth.helper

import com.google.firebase.auth.FirebaseAuth

object FBAuth {
    fun fbAuthInit() = FirebaseAuth.getInstance()
}