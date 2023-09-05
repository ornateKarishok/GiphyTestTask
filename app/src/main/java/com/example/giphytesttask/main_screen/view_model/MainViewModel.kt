package com.example.giphytesttask.main_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.giphytesttask.model.MainModel
import com.example.giphytesttask.models.DataResult

class MainViewModel : ViewModel() {
    private var gifLiveData = MainModel().getGifs()

    fun observeMovieLiveData(): LiveData<DataResult> {
        return gifLiveData
    }
}