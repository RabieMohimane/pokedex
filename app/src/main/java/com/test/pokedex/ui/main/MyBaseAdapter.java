package com.test.pokedex.ui.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.test.pokedex.data.local.Result;
import com.test.pokedex.databinding.PokeItemBinding;


public abstract class MyBaseAdapter
        extends RecyclerView.Adapter<MyViewHolder> {
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        PokeItemBinding binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        return new MyViewHolder(binding);
    }

    public void onBindViewHolder(MyViewHolder holder,
                                 int position) {

        Result obj = (Result) getObjForPosition(position);
        holder.bind(obj);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    protected abstract Object getObjForPosition(int position);

    protected abstract int getLayoutIdForPosition(int position);
}
