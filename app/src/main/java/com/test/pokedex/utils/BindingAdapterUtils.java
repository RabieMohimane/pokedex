package com.test.pokedex.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.test.pokedex.R;


public class BindingAdapterUtils {
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
       // Picasso.get().load(url).placeholder(R.drawable.car_placeholder).into(view);
    }
}