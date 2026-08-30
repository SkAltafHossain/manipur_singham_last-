package com.altaf.manipursingham.ui.firstPizeJodi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.altaf.manipursingham.databinding.ItemFirstPrizeHeaderBinding
import com.altaf.manipursingham.databinding.ItemFirstPrizeJodiBinding
import com.altaf.manipursingham.domain.model.FirstPrizeJodi

private const val TYPE_HEADER = 0
private const val TYPE_ITEM = 1

class FirstPrizeJodiAdapter : 
    ListAdapter<FirstPrizeJodi, RecyclerView.ViewHolder>(FirstPrizeJodiDiffCallback()) {

    private var showHeader = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(
                ItemFirstPrizeHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> ItemViewHolder(
                ItemFirstPrizeJodiBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> {
                val itemPosition = if (showHeader) position - 1 else position
                holder.bind(getItem(itemPosition))
            }
            is HeaderViewHolder -> {
                // Bind header if needed
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (showHeader && position == 0) TYPE_HEADER else TYPE_ITEM
    }

    override fun getItemCount(): Int {
        val count = super.getItemCount()
        return if (showHeader) count + 1 else count
    }

    fun submitList(list: List<FirstPrizeJodi>?, showHeader: Boolean = true) {
        this.showHeader = showHeader && !list.isNullOrEmpty()
        super.submitList(list) {
            // Submit complete callback if needed
        }
    }

    class ItemViewHolder(
        private val binding: ItemFirstPrizeJodiBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FirstPrizeJodi) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    class HeaderViewHolder(
        binding: ItemFirstPrizeHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root)
}

private class FirstPrizeJodiDiffCallback : DiffUtil.ItemCallback<FirstPrizeJodi>() {
    override fun areItemsTheSame(oldItem: FirstPrizeJodi, newItem: FirstPrizeJodi): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: FirstPrizeJodi, newItem: FirstPrizeJodi): Boolean {
        return oldItem == newItem
    }
}
