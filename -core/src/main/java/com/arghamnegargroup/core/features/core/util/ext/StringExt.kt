package com.arghamnegargroup.core.features.core.util.ext

fun String?.toLatinDigits(): String? {
    return this?.replace('٠', '0')
        ?.replace('١', '1')
        ?.replace('٢', '2')
        ?.replace('٣', '3')
        ?.replace('٤', '4')
        ?.replace('٥', '5')
        ?.replace('٦', '6')
        ?.replace('٧', '7')
        ?.replace('٨', '8')
        ?.replace('٩', '9')
}