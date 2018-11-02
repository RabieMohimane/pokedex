package com.test.pokedex.ui.main;

import android.support.v7.widget.RecyclerView;

import com.test.pokedex.data.local.Result;
import com.test.pokedex.databinding.PokeItemBinding;

public class MyViewHolder extends RecyclerView.ViewHolder {
    final PokeItemBinding binding;


    public MyViewHolder(PokeItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;


    }

    public void bind(Result item) {
        binding.setPoke(item);
        binding.executePendingBindings();

    }
}