package com.arghamnegargroup.core.features.licence.util.common;

import java.util.UUID;

public class UniqueIdGenerator {

    public static String getUniqueID() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }
}