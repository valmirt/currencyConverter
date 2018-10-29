package com.dev.valmirt.currencyconverter.di.component

import com.dev.valmirt.currencyconverter.di.module.NetworkModule
import com.dev.valmirt.currencyconverter.ui.home.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject (homeViewModel: HomeViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}