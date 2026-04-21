package com.altaf.haryanalast.ui.firstPrizeFirst.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.altaf.haryanalast.databinding.ItemFirstPrizeFirstBinding
import com.altaf.haryanalast.databinding.ItemFirstPrizeHeaderBinding
import com.altaf.haryanalast.domain.model.FirstPrizeFirst

private const val TYPE_HEADER = 0
private const val TYPE_ITEM = 1

class FirstPrizeFirstAdapter :
    ListAdapter<FirstPrizeFirst, RecyclerView.ViewHolder>(FirstPrizeFirstDiffCallback()) {

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
                ItemFirstPrizeFirstBinding.inflate(
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

    fun submitList(list: List<FirstPrizeFirst>?, showHeader: Boolean = true) {
        this.showHeader = showHeader && !list.isNullOrEmpty()
        super.submitList(list) {
            // Submit complete callback if needed
        }
    }

    class ItemViewHolder(
        private val binding: ItemFirstPrizeFirstBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FirstPrizeFirst) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    class HeaderViewHolder(
        binding: ItemFirstPrizeHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root)
}

private class FirstPrizeFirstDiffCallback : DiffUtil.ItemCallback<FirstPrizeFirst>() {
    override fun areItemsTheSame(oldItem: FirstPrizeFirst, newItem: FirstPrizeFirst): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: FirstPrizeFirst, newItem: FirstPrizeFirst): Boolean {
        return oldItem == newItem
    }
}
