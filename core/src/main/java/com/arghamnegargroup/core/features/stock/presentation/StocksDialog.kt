package com.arghamnegargroup.core.features.stock.presentation

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.arghamnegargroup.core.R
import com.arghamnegargroup.core.databinding.DialogSelectBinding
import com.arghamnegargroup.core.features.core.util.ext.hideKeyboard
import com.arghamnegargroup.core.features.core.util.ext.textChanges
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.stock.presentation.adapter.DialogItemAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class StocksDialog(val stocks: List<Stock>?, val onStockClicked: (Stock) -> Unit) : DialogFragment() {

    @OptIn(FlowPreview::class)
    @ExperimentalCoroutinesApi
    @SuppressLint("DialogFragmentCallbacksDetector")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        val view: View = layoutInflater.inflate(R.layout.dialog_select, null)
        builder.setView(view)
        val bind = DialogSelectBinding.bind(view)
        val dialog: AlertDialog = builder.create()

        val mAdapter = DialogItemAdapter(object : DialogItemAdapter.Interaction {
            override fun onItemClicked(item: Stock) {
                onStockClicked(item)
                dialog.dismiss()
            }
        })

        mAdapter.submitList(stocks ?: listOf())

        bind.searchBar.textChanges()
            .debounce(200)
            .onEach {
                if (it.toString().trim().isEmpty())
                    mAdapter.submitList(stocks ?: listOf())
                else mAdapter.filter.filter(it)
            }
            .launchIn(lifecycleScope)

        bind.title.text = getString(R.string.stocks)
        bind.recyclerView.adapter = mAdapter
        bind.closeBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setOnDismissListener {
            requireActivity().hideKeyboard()
        }
        return dialog
    }
}