package com.byfrunze.motozip.content.search.presenters

import android.util.Log
import com.byfrunze.motozip.auth.models.AddressModel
import com.byfrunze.motozip.auth.models.DadataBody
import com.byfrunze.motozip.content.search.providers.ParametersProvider
import com.byfrunze.motozip.content.search.views.ParametersView
import moxy.MvpPresenter

class ParametersPresenter : MvpPresenter<ParametersView>() {
    fun loadRegion(query: String) {
        ParametersProvider(this).loadRegion(DadataBody(query = query, count = 5))
    }

    fun addressLoaded(suggestions: ArrayList<AddressModel>) {
        Log.i("TAG", suggestions.toString())
        val region:ArrayList<String> = ArrayList()
        for(city in suggestions)
            region.add(city.value)
        viewState.loadRegion(region)

    }

    fun errorLoaded(message: String?) {

    }

}