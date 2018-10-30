package com.dev.valmirt.currencyconverter.ui.home

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.dev.valmirt.currencyconverter.CCApplication
import com.dev.valmirt.currencyconverter.base.BaseViewModel
import com.dev.valmirt.currencyconverter.model.Currency
import com.dev.valmirt.currencyconverter.remote.CurrencyEndPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class HomeViewModel: BaseViewModel() {

    @Inject
    lateinit var api: Retrofit
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<String> = MutableLiveData()
    val resultCurrency: MutableLiveData<Currency> = MutableLiveData()
    private lateinit var subscription: Disposable

    init {
        loadingCurrency()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun loadingCurrency(){
        val call = api.create(CurrencyEndPoint::class.java)

        subscription = call.getCurrency().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveCurrencyStart() }
            .doOnTerminate { onRetrieveCurrencyFinish() }
            .subscribe (
                { result -> onSuccessResponse(result) },
                { error -> onErrorResponse(error.message) }
            )
    }

    private fun onRetrieveCurrencyFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCurrencyStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onErrorResponse(message: String?) {
        errorMessage.value = message
    }

    private fun onSuccessResponse(result: Currency?) {
        resultCurrency.value = result
    }

}