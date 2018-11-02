package com.revotrendz.eliteswap.ui.main


import com.test.pokedex.data.local.Result
import com.test.pokedex.ui.main.SingleLayoutAdapter

class MyAdapter(layoutId: Int, private var pokemons: List<Result>?) : SingleLayoutAdapter(layoutId) {

    override fun getObjForPosition(position: Int): Any? {
        if (pokemons != null)
            return pokemons!!.get(position)
        return null
    }

    override fun getItemCount(): Int {

        return pokemons?.count() ?: 0

    }

    fun addItems(cars: List<Result>) {
        pokemons = cars
    }

    fun getItem(position: Int): Result? {
        if (pokemons != null)
            return pokemons!!.get(position)
        else
            return null
    }
}
