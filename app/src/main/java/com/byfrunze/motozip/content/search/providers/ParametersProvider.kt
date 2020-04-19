package com.byfrunze.motozip.content.search.providers

import com.byfrunze.motozip.auth.helper.AddressApi
import com.byfrunze.motozip.auth.models.DadataBody
import com.byfrunze.motozip.content.search.presenters.ParametersPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ParametersProvider(var presenter: ParametersPresenter) {
    private val apiService by lazy {
        AddressApi.create()
    }
    var disposable: Disposable? = null

    fun loadRegion(body: DadataBody) {
        disposable = apiService.getAddress(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    presenter.addressLoaded(it.suggestions)
                }, {
                    presenter.errorLoaded(it.message)
                })

    }
}