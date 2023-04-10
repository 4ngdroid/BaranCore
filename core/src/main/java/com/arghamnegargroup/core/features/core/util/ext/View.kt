package com.arghamnegargroup.core.features.core.util.ext

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import java.io.File
import java.io.FileOutputStream


inline var View.isVisible: Boolean
    get() = visibility == VISIBLE
    set(value) {
        visibility = if (value) VISIBLE else GONE
    }

inline var View.isHidden: Boolean
    get() = visibility == GONE
    set(value) {
        visibility = if (value) GONE else VISIBLE
    }

inline var View.isInvisible: Boolean
    get() = visibility == INVISIBLE
    set(value) {
        visibility = if (value) INVISIBLE else VISIBLE
    }

fun View.show() {
    visibility = VISIBLE
}

fun View.hide() {
    visibility = GONE
}

fun View.invisible() {
    visibility = INVISIBLE
}

fun View.enable() {
    alpha = 1f
    isEnabled = true
}

fun View.disable() {
    alpha = 0.3f
    isEnabled = false
}

fun View.focus() {
    isFocusableInTouchMode = true
    postDelayed({ requestFocus() }, 200)
}

fun View.toBitmap(): Bitmap? {
    measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
    val bitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    layout(0, 0, measuredWidth, measuredHeight)
    draw(canvas)
    saveImage(bitmap, this.context)
    return bitmap
}

private fun saveImage(finalBitmap: Bitmap, context: Context) {
    val root = context.filesDir
    val myDir = File("$root/saved_images/")
    myDir.mkdirs()
    val name = "Image-1.png"
    val file = File(myDir, name)
    if (file.exists()) file.delete()
    try {
        val out = FileOutputStream(file)
        finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
        out.flush()
        out.close()
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }
}

fun View.setSize(width: Int, height: Int) {
    val params: ViewGroup.LayoutParams = layoutParams
    params.width = width
    params.height = height
    layoutParams = params
}
