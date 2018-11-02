package com.test.pokedex.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.revotrendz.eliteswap.ui.main.MyAdapter
import com.test.pokedex.R
import com.test.pokedex.data.local.Result
import com.test.pokedex.utils.EndlessRecyclerOnScrollListener
import com.test.pokedex.viewmodels.PokeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.support.v4.os.HandlerCompat.postDelayed
import android.util.Log
import android.view.View
import com.test.pokedex.data.local.PokemonsContainer
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    lateinit var allPokemons: ArrayList<Result>
    lateinit var pokemonsPart: ArrayList<Result>
    lateinit var mViewModel: PokeViewModel
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(PokeViewModel::class.java)
        mViewModel.getAllPokemons().observe(this, Observer {

            if (it != null) {
                allPokemons = it as ArrayList<Result>
                pokemonsPart = ArrayList<Result>()
                for(i in 0 ..19){
                    Log.e("i",i.toString()+" "+allPokemons.get(i).imageName);
                    pokemonsPart.add(i,allPokemons.get(i))
                }
                myAdapter = MyAdapter(R.layout.poke_item, pokemonsPart)
                // recyclerViewAdapter = RecyclerViewAdapter(ArrayList(), this)
                recyclerView!!.layoutManager = GridLayoutManager(this, 3);
                recyclerView.addOnScrollListener(object : EndlessRecyclerOnScrollListener() {
                    override fun onLoadMore() {
                        addDataToList()
                    }

                })
                recyclerView!!.adapter = myAdapter
                myAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun addDataToList() {
        item_progress_bar.setVisibility(View.VISIBLE)
        Handler().postDelayed({

            if (pokemonsPart.size + 19 < allPokemons.size) {
                for(i in pokemonsPart.size .. pokemonsPart.size+19){
                    Log.e("i",i.toString()+" "+allPokemons.get(i).imageName);
                    pokemonsPart.add(i,allPokemons.get(i))
                }

            } else if (pokemonsPart.size < allPokemons.size) {
                for(i in pokemonsPart.size ..  allPokemons.size - 1){
                    pokemonsPart.add(i,allPokemons.get(i))
                }
            }

            myAdapter.notifyDataSetChanged()
            item_progress_bar.setVisibility(View.GONE)
        }, 1500)

    }
}
