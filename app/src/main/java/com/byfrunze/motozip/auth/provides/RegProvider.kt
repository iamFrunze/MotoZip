package com.byfrunze.motozip.auth.provides

import com.byfrunze.motozip.auth.helper.AddressApi
import com.byfrunze.motozip.auth.helper.FBAuth
import com.byfrunze.motozip.auth.presenters.RegPresenter
import io.reactivex.disposables.Disposable

class RegProvider(var presenter: RegPresenter) {
    private val apiService by lazy {
        AddressApi.create()
    }

    var disposable: Disposable? = null

//    fun loadAddress(body: DadataBody) {
//        disposable = apiService.getAddress(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    presenter.addressLoaded(it.suggestions)
//                }, {
//                    presenter.errorLoaded(it.message)
//                })
//    }

    fun registration(email: String, pass1: String) {
        FBAuth.fbAuthInit().createUserWithEmailAndPassword(email, pass1)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        sendEmail()
                    } else {
                        presenter.isFailed(it.exception?.localizedMessage ?: "Что-то пошло не так")
                    }
                }
    }

    private fun sendEmail() {
        FBAuth.fbAuthInit().currentUser?.let {
            it.sendEmailVerification()
                    .addOnCompleteListener {
                        if(it.isSuccessful) presenter.isSuccess("Вам отправлено письмо для подтверждения")
                        else presenter.isFailed(it.exception?.localizedMessage ?: "Что-то пошло не так")
                    }
        }

    }
}