package com.arghamnegargroup.core.features.item_stock.domain.util.comparator

import androidx.recyclerview.widget.DiffUtil
import com.arghamnegargroup.core.features.item_stock.domain.model.ItemStock

class ItemStockComparator : DiffUtil.ItemCallback<ItemStock>() {
    override fun areItemsTheSame(oldItem: ItemStock, newItem: ItemStock): Boolean {
        return newItem.itemId == oldItem.itemId && newItem.stockId == oldItem.stockId
    }

    override fun areContentsTheSame(oldItem: ItemStock, newItem: ItemStock): Boolean {
        return newItem.hashCode() == oldItem.hashCode()
    }

    override fun getChangePayload(oldItem: ItemStock, newItem: ItemStock): ItemStock {
        return newItem
    }
}