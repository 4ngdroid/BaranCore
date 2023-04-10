package com.arghamnegargroup.core.features.stock.domain.util.comparator

import androidx.recyclerview.widget.DiffUtil
import com.arghamnegargroup.core.features.stock.domain.model.Stock

class StockComparator : DiffUtil.ItemCallback<Stock>() {
    override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun getChangePayload(oldItem: Stock, newItem: Stock): Any? {
        return newItem
    }
}