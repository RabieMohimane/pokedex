package com.test.pokedex.data.local

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result(
        @SerializedName("name")
        @Expose
        val name: String,
        @SerializedName("url")
        @Expose
        val url: String
) {
    val imageName: String
        get(){
            val indexes=url.split("/")
            return indexes.get(indexes.lastIndex-1)+".png"
        }

}