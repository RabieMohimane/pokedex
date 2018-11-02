package com.test.pokedex.data.remote

import com.test.pokedex.data.local.PokemonsContainer
import io.reactivex.Single
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {
    @GET("api/v2/pokemon/")
    fun getAllPokemons(): Single<Response<PokemonsContainer>>
}