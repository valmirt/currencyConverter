package com.dev.valmirt.currencyconverter.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.dev.valmirt.currencyconverter.R
import com.dev.valmirt.currencyconverter.adapter.CurrencyAdapter
import com.dev.valmirt.currencyconverter.base.BaseActivity
import com.dev.valmirt.currencyconverter.model.Currency
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<HomeViewModel>() {

    private val adapter = CurrencyAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        viewModel?.errorMessage?.observe(this, Observer { error->
            setErrorResult(error)
        })

        viewModel?.loadingVisibility?.observe(this, Observer { visibility ->
            if (visibility != null) showLoading(visibility)
        })

        viewModel?.resultCurrency?.observe(this, Observer { result ->
            updateValues(result)
        })
    }

    private fun setErrorResult(error: String?) {
        if (error != null) Snackbar.make(layout_home, error, Snackbar.LENGTH_LONG).show()
    }

    private fun updateValues(result: Currency?) {

    }

    private fun showLoading(setVisibility: Int) {

    }

    override fun containerViewModel(): HomeViewModel? {
        return ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }
}
