package com.test.pokedex

import android.app.Application
import android.content.Context
import com.test.pokedex.di.AppModule
import com.test.pokedex.di.DaggerPokeAppComponent
import com.test.pokedex.di.PokeAppComponent

class PokeApp: Application() {

    init {
        initDagger()
    }
    companion object {
        lateinit var context: Context
        lateinit var mAppComponent: PokeAppComponent
    }
    private fun initDagger() {
        mAppComponent = DaggerPokeAppComponent.builder()
                .appModule(AppModule())
                .build()
    }
}