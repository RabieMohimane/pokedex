package com.test.pokedex.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.test.pokedex.data.local.Result
import com.test.pokedex.data.repository.PokeRepository
import com.test.pokedex.di.DaggerPokeAppComponent
import javax.inject.Inject


class PokeViewModel : ViewModel() {
@Inject
lateinit var  myRepository: PokeRepository
init {
    DaggerPokeAppComponent.create().inject(this)
}

    fun getAllPokemons(): LiveData<List<Result>> {
        return myRepository.getAllPokemons()
    }

}