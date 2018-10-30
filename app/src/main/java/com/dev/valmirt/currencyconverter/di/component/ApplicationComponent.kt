package com.dev.valmirt.currencyconverter.di.component

import android.app.Application
import com.dev.valmirt.currencyconverter.di.module.NetworkModule
import com.dev.valmirt.currencyconverter.ui.home.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject (application: Application)

    fun inject (homeViewModel: HomeViewModel)
}