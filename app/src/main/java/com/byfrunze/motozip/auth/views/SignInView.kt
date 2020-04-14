package com.byfrunze.motozip.auth.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface SignInView : MvpView{
    fun signInSuccessfully()
    fun signInError(textError: String)
    fun signInLoading()
}