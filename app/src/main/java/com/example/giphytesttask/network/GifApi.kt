package com.example.giphytesttask.network

import com.example.giphytesttask.models.DataResult
import retrofit2.Call
import retrofit2.http.GET

interface GifApi {
    @GET("gifs/trending?api_key=ZptwdEM1m8XZnsdi8GsdS5bCfANbGpTM")
    fun getGifs(): Call<DataResult>
}