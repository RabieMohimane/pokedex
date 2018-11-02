package com.test.pokedex.data.remote

import com.test.pokedex.data.local.PokemonsContainer
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class PokeService(var webservice: PokeApi) : PokeApi {
    override fun getAllPokemons(): Single<Response<PokemonsContainer>> {
        return webservice.getAllPokemons()
    }
}