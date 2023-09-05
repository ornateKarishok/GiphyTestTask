package com.example.giphytesttask.full_screen_gif

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.giphytesttask.R
import com.example.giphytesttask.databinding.ActivityFullScreenGifBinding

class FullScreenGifActivity : AppCompatActivity() {
    private val intentKeyFullScreenGif = "FULL_SCREEN_ACTIVITY"
    private lateinit var binding: ActivityFullScreenGifBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_full_screen_gif)
        setData(intent.getStringExtra(intentKeyFullScreenGif))
    }

    private fun setData(gifUrl: String?) {
        binding.apply {
            Glide.with(this@FullScreenGifActivity)
                .load(gifUrl)
                .into(fullScreenGif)
        }
    }
}