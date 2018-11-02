package com.test.pokedex.data.repository

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.test.pokedex.data.local.PokemonsContainer
import com.test.pokedex.data.local.Result
import com.test.pokedex.data.remote.PokeService
import io.reactivex.schedulers.Schedulers
import retrofit2.Response


class PokeRepository(val pokeService: PokeService) :IPokeRepo {
    override fun getAllPokemons(): MutableLiveData<List<Result>> {
        val data = MutableLiveData<List<Result>>()
        pokeService.getAllPokemons()
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    Log.e("success", success.body().toString())
                    data.postValue(success.body()!!.results)
                }, { error ->
                    Log.e("error", error.message.toString())
                    data.postValue(null)
                })
        return data
    }
}