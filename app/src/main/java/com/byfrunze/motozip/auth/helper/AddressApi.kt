package com.byfrunze.motozip.auth.helper

import com.byfrunze.motozip.auth.models.DadataBody
import com.byfrunze.motozip.auth.models.SugModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AddressApi {

    @Headers(
            "Authorization: Token 286ebdeeae3136fb144cbddc554aa277afe3b825",
            "Content-Type: application/json",
            "Accept: application/json"
    )

    @POST("api/v2/suggest/address")
    fun getAddress(@Body body: DadataBody): Observable<SugModel>

    companion object {
        private const val URL = "https://dadata.ru/"

        fun create(): AddressApi {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(URL)
                    .build()
            return retrofit.create(AddressApi::class.java)
        }
    }
}