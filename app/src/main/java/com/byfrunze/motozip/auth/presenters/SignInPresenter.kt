package com.byfrunze.motozip.auth.presenters

import com.byfrunze.motozip.auth.provides.SignInProvider
import com.byfrunze.motozip.auth.views.SignInView
import moxy.MvpPresenter

class SignInPresenter : MvpPresenter<SignInView>() {
    fun signInUser(nameUser: String, passwordUser: String) {
        if (nameUser.trim().isEmpty() || passwordUser.trim().isEmpty()) {
            viewState.signInError("Заполните данные")
        } else {
            viewState.signInLoading()
            SignInProvider(this).signIn(nameUser = nameUser, passwordUser = passwordUser)
        }
    }

    fun successfully() {
        viewState.signInSuccessfully()
    }

    fun error(textError: String) {
        viewState.signInError(textError = textError)
    }
}
