package com.arghamnegargroup.core.features.core.util.ext

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.arghamnegargroup.core.R
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent


fun Activity.hideKeyboard() {
    if (KeyboardVisibilityEvent.isKeyboardVisible(this)) {
        val imm: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view: View? = currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Activity.copy(label: String?, text: String?) {
    val clipboard: ClipboardManager? = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
    val clip: ClipData = ClipData.newPlainText(label, text)
    clipboard?.setPrimaryClip(clip)
}

fun Activity.showMessage(text: String?) {
    text?.let {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}

fun Activity.showMessage(text: Int?) {
    text?.let {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}