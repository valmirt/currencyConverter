package com.dev.valmirt.currencyconverter

import android.app.Application
import com.dev.valmirt.currencyconverter.di.component.ApplicationComponent
import com.dev.valmirt.currencyconverter.di.component.DaggerApplicationComponent
import com.dev.valmirt.currencyconverter.di.module.NetworkModule

class CCApplication: Application() {
    companion object {
        //platformStatic allow access it from java code
        @JvmStatic
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        graph = DaggerApplicationComponent
            .builder()
            .networkModule(NetworkModule(this))
            .build()

        graph.inject(this)
    }
}