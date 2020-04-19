package com.byfrunze.motozip.content.search.views

import com.byfrunze.motozip.content.search.models.TopFeedModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface SearchMotorcycleView: MvpView {
    fun loading()
    fun errorLoading()
    fun contentLoaded(listTopFeed: ArrayList<TopFeedModel>)
}