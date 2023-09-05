package com.example.giphytesttask.main_screen.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphytesttask.databinding.ActivityMainBinding
import com.example.giphytesttask.full_screen_gif.FullScreenGifActivity
import com.example.giphytesttask.main_screen.view_model.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val intentKeyFullScreenGif = "FULL_SCREEN_ACTIVITY"
    private val gifAdapter by lazy { GifAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.observeGifLiveData().observe(this) { gifList ->
            gifAdapter.differ.submitList(gifList.res)
        }

    }

    private fun prepareRecyclerView() {
        gifAdapter.setOnClickListener(object : GifAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val nextActivity = Intent(this@MainActivity, FullScreenGifActivity::class.java)
                nextActivity.putExtra(
                    intentKeyFullScreenGif,
                    viewModel.observeGifLiveData().value!!.res[position].images.ogImages.url
                )
                startActivity(nextActivity)
            }

        })
        binding.apply {
            gifList.apply {
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                adapter = gifAdapter
            }
        }
    }
}