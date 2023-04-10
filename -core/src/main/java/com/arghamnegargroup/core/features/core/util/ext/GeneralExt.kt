package com.arghamnegargroup.core.features.core.util.ext

import com.arghamnegargroup.core.features.core.domain.model.General

inline val <T> General<T>?.isSuccessful get() : Boolean = this?.status == 3