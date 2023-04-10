package com.arghamnegargroup.core.features.stock.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.arghamnegargroup.core.databinding.SimpleTextItemBinding
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.stock.domain.util.comparator.StockComparator
import java.util.*

class DialogItemAdapter(private val interaction: Interaction) : RecyclerView.Adapter<DialogItemAdapter.ViewHolder>(),
    Filterable {

    private val diffCallback = StockComparator()
    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(newList: List<Stock>) {
        orgList = newList.toMutableList()
        differ.submitList(newList)
    }

    private var orgList = mutableListOf<Stock>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SimpleTextItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), interaction)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    class ViewHolder(
        private val binding: SimpleTextItemBinding,
        private val interaction: Interaction
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Stock) = with(binding) {
            text.text = item.name
            root.setOnClickListener {
                interaction.onItemClicked(item)
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty() || charSequence.isEmpty()) {
                    submitList(orgList)
                } else {
                    val filteredList = mutableListOf<Stock>()
                    orgList.forEach { item ->
                        val names = item.name?.trim()?.split(" ")
                        val phrases = charString.trim().split(" ")

                        var counter = 0
                        names?.forEach { name ->
                            phrases.forEach { phrase ->
                                if (name.toLowerCase(Locale.ROOT).contains(phrase.toLowerCase(Locale.ROOT)))
                                    counter++
                            }
                        }
                        if (counter >= phrases.size) filteredList.add(item)
                    }
                    submitList(filteredList)
                }

                val filterResults = FilterResults()
                filterResults.values = differ.currentList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {

            }
        }
    }


    interface Interaction {
        fun onItemClicked(item: Stock)
    }

}