package com.dev.valmirt.currencyconverter.ui.home

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.dev.valmirt.currencyconverter.R
import com.dev.valmirt.currencyconverter.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun containerViewModel(): HomeViewModel? {
        return ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }
}
