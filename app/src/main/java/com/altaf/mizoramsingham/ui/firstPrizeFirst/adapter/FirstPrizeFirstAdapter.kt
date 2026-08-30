package com.altaf.manipursingham.ui.firstPrizeFirst.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.altaf.manipursingham.R
import com.altaf.manipursingham.databinding.ItemFirstPrizeFirstBinding
import com.altaf.manipursingham.databinding.ItemFirstPrizeHeaderBinding
import com.altaf.manipursingham.domain.model.FirstPrizeFirst

private const val TYPE_HEADER = 0
private const val TYPE_ITEM = 1

class FirstPrizeFirstAdapter :
    ListAdapter<FirstPrizeFirst, RecyclerView.ViewHolder>(FirstPrizeFirstDiffCallback()) {

    private var showHeader = true
    private var searchQuery = ""

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
                holder.bind(getItem(itemPosition), searchQuery)
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

    fun setSearchQuery(query: String) {
        this.searchQuery = query
        notifyDataSetChanged()
    }

    class ItemViewHolder(
        private val binding: ItemFirstPrizeFirstBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FirstPrizeFirst, searchQuery: String) {
            binding.item = item
            binding.executePendingBindings()

            if (searchQuery.isNotEmpty()) {
                highlightTextView(binding.header1130, item.time1130, searchQuery)
                highlightTextView(binding.header1500, item.time1500, searchQuery)
                highlightTextView(binding.header1700, item.time1700, searchQuery)
                highlightTextView(binding.header2030, item.time2030, searchQuery)
                highlightTextView(binding.header2200, item.time2200, searchQuery)
            } else {
                resetTextView(binding.header1130)
                resetTextView(binding.header1500)
                resetTextView(binding.header1700)
                resetTextView(binding.header2030)
                resetTextView(binding.header2200)
            }
        }

        private fun highlightTextView(textView: android.widget.TextView, text: String?, searchQuery: String) {
            if (text != null && text.contains(searchQuery, ignoreCase = true)) {
                textView.setBackgroundColor(Color.parseColor("#FFD700"))
                textView.setTextColor(Color.RED)
            } else {
                resetTextView(textView)
            }
        }

        private fun resetTextView(textView: android.widget.TextView) {
            textView.setBackgroundResource(R.drawable.box_drawable)
            textView.setTextColor(ContextCompat.getColor(textView.context, R.color.black))
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
