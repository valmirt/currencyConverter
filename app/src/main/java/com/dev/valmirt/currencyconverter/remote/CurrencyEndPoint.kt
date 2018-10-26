package com.dev.valmirt.currencyconverter.remote

import com.dev.valmirt.currencyconverter.model.Currency
import com.dev.valmirt.currencyconverter.utils.Constants.Companion.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyEndPoint {

    @GET("latest")
    fun getCurrency(@Query("access_key") string: String = API_KEY): Observable<Currency>
}