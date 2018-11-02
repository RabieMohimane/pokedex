package com.test.pokedex.di




import com.test.pokedex.data.remote.PokeApi
import com.test.pokedex.data.remote.PokeService
import com.test.pokedex.viewmodels.PokeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface PokeAppComponent {
    fun inject(pokeViewModel: PokeViewModel)

}