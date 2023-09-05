package com.example.giphytesttask.main_screen.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphytesttask.databinding.GifItemBinding
import com.example.giphytesttask.models.DataObject

class GifAdapter : RecyclerView.Adapter<GifAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: GifItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(item: DataObject) {
            binding.apply {
                Glide.with(itemView)
                    .load(item.images.ogImages.url)
                    .into(gifIv)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GifItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount() = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<DataObject>() {
        override fun areItemsTheSame(oldItem: DataObject, newItem: DataObject): Boolean {
            return oldItem.images.ogImages.url == newItem.images.ogImages.url
        }

        override fun areContentsTheSame(oldItem: DataObject, newItem: DataObject): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
}