package com.dev.valmirt.currencyconverter.base

import android.arch.lifecycle.ViewModel
import com.dev.valmirt.currencyconverter.di.component.DaggerViewModelInjector
import com.dev.valmirt.currencyconverter.di.component.ViewModelInjector
import com.dev.valmirt.currencyconverter.di.module.NetworkModule
import com.dev.valmirt.currencyconverter.ui.home.HomeViewModel

abstract class BaseViewModel: ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is HomeViewModel -> injector.inject(this)
        }
    }
}