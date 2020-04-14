package com.byfrunze.motozip.auth.provides

import com.byfrunze.motozip.auth.helper.FBAuth
import com.byfrunze.motozip.auth.presenters.SignInPresenter

class SignInProvider(var presenter: SignInPresenter) {

    fun signIn(nameUser: String, passwordUser: String) {
        FBAuth.fbAuthInit().signInWithEmailAndPassword(nameUser, passwordUser)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        presenter.successfully()
                    } else {
                        presenter.error(it.exception?.localizedMessage ?: " ")
                    }
                }
    }

}