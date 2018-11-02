package com.test.pokedex.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.test.pokedex.data.local.Result


interface IPokeRepo {
    fun getAllPokemons(): MutableLiveData<List<Result>>
}