package com.dev.valmirt.currencyconverter.base

import android.arch.lifecycle.ViewModel
import com.dev.valmirt.currencyconverter.CCApplication
import com.dev.valmirt.currencyconverter.ui.home.HomeViewModel

abstract class BaseViewModel: ViewModel() {

    init {
        injector()
    }

    private fun injector() {
        when(this){
            is HomeViewModel -> CCApplication.graph.inject(this)
        }
    }
}