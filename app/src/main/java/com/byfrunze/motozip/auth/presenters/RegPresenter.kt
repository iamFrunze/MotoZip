package com.byfrunze.motozip.auth.presenters

import com.byfrunze.motozip.auth.helper.FBAuth
import com.byfrunze.motozip.auth.provides.RegProvider
import com.byfrunze.motozip.auth.views.RegView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class RegPresenter : MvpPresenter<RegView>() {

    fun check(email: String, pass1: String, pass2: String) {
        viewState.loading()
        if (!checkEmail(email = email)) viewState.error("Некорректный email")
        else if (!checkPass(pass1, pass2)) viewState.error("Пароли не совпадают")
        else RegProvider(this).registration(email = email, pass1 = pass1)

    }

    fun isSuccess(textSuccess:String) {
        viewState.successfully(textSuccess)
    }

    fun isFailed(textError: String) {
        viewState.error(textError = textError)
    }


    private fun checkPass(pass1: String, pass2: String): Boolean {
        return pass1 == pass2
    }

    private fun checkEmail(email: String): Boolean {
        return email.contains("@")
    }


//    fun getAddress(body: DadataBody){
//        RegProvider(this).loadAddress(body = body)
//    }
//    fun addressLoaded(listModel: List<AddressModel>?) {
//        Log.i("TAG_POST", listModel.toString())
//    }
//
//    fun errorLoaded(message: String?) {
//        Log.i("TAG_POST", message)
//    }
}