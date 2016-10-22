package com.example.elfatahwashere.storage;

import android.content.Context;

import io.realm.RealmConfiguration;

/**
 * Created by elfatahwashere on 9/22/2016.
 */

public class RealmConfig {
    private final static String DB_NAME="movie_db";
    public static RealmConfiguration getRealmConfiguration(Context context) {
        return new RealmConfiguration
                .Builder(context)
                .name(DB_NAME)
                .deleteRealmIfMigrationNeeded()
                .build();
    }
}