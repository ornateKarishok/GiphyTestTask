package com.example.giphytesttask.models

import com.google.gson.annotations.SerializedName

data class DataObject(
    @SerializedName("title") val name : String,
    @SerializedName("images") val images: DataImage
)
