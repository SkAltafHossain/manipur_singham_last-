package com.altaf.manipursinghamlast.ui.numberCombination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.altaf.manipursinghamlast.databinding.ItemNumberCombinationBinding

class NumberCombinationAdapter : ListAdapter<String, NumberCombinationAdapter.NumberCombinationViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberCombinationViewHolder {
        val binding = ItemNumberCombinationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberCombinationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberCombinationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NumberCombinationViewHolder(private val binding: ItemNumberCombinationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(number: String) {
            binding.tvNumber.text = number
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }
}
