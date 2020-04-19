package com.byfrunze.motozip.content.search.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface ParametersView : MvpView {
    fun updateCount()
    fun loadRegion(region: ArrayList<String>)
}