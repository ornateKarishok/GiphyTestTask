package com.example.giphytesttask.main_screen.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.giphytesttask.databinding.ActivityMainBinding
import com.example.giphytesttask.main_screen.view_model.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val gifAdapter by lazy { GifAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.observeMovieLiveData().observe(this) { gifList ->
            gifAdapter.differ.submitList(gifList.res)
        }
    }

    private fun prepareRecyclerView() {
        binding.apply {
            gifList.apply {
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                adapter = gifAdapter
            }
        }

    }
}