package com.example.giphytesttask.main_screen.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.giphytesttask.models.DataResult
import com.example.giphytesttask.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel {
    var gifLiveData = MutableLiveData<DataResult>()

    fun getGifs(): MutableLiveData<DataResult> {
        RetrofitInstance.api.getGifs().enqueue(object : Callback<DataResult> {
            override fun onResponse(
                call: Call<DataResult>,
                response: Response<DataResult>
            ) {
                if (response.body() != null) {
                    gifLiveData.value = response.body()!!
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<DataResult>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })
        return gifLiveData
    }
}