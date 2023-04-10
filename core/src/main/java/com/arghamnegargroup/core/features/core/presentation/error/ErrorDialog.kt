package com.arghamnegargroup.core.features.core.presentation.error

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.arghamnegargroup.core.R
import com.arghamnegargroup.core.databinding.DialogErrorBinding
import com.arghamnegargroup.core.features.core.util.ext.hide

class ErrorDialog(val message: String?) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        val view: View = layoutInflater.inflate(R.layout.dialog_error, null)
        builder.setView(view)
        val bind = DialogErrorBinding.bind(view)
        val dialog: AlertDialog = builder.create()

        bind.text.text = message
        bind.negativeButton.hide()
        bind.positiveButton.setText(R.string.ok)
        bind.positiveButton.setOnClickListener {
            dismiss()
        }

        return dialog
    }
}