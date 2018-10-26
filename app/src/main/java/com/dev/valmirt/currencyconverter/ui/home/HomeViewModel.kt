package com.dev.valmirt.currencyconverter.ui.home

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

    private lateinit var subscription: Disposable

    init {
        loadingCurrency()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadingCurrency(){
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onRetrieveCurrencyStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onErrorResponse(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onSuccessResponse(result: Currency?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}