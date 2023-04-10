package com.arghamnegargroup.core.features.core.util.ext

import android.os.Looper

inline fun <T> ensureNotOnMainThread(block: () -> T): T {
    check(Thread.currentThread() != Looper.getMainLooper().thread) { "This function cannot be called on main thread" }
    return block()
}


inline fun <T> ensureOnMainThread(block: () -> T): T {
    check(Thread.currentThread() == Looper.getMainLooper().thread) { "This function cannot be called on main thread" }
    return block()
}

