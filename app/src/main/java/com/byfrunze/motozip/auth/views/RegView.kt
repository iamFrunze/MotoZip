package com.byfrunze.motozip.auth.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface RegView: MvpView {
    fun loading()
    fun successfully(textSuccess: String)
    fun error(textError: String)
}