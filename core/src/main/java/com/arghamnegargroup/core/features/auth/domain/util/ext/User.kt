package com.arghamnegargroup.core.features.auth.domain.util.ext

import com.arghamnegargroup.core.features.auth.domain.model.User
import com.arghamnegargroup.core.features.core.util.common.CoreConstants

fun User.applyPermissions() {
    val permissionList = mutableListOf(-1)
    permissions?.forEach { permission ->
        if (CoreConstants.PERMISSIONS.contains(permission.permissionID) && !permissionList.contains(permission.permissionID) && permission.accessFlag) {
            permissionList.add(permission.permissionID)
        }
    }
    selectedPermission = permissionList
}