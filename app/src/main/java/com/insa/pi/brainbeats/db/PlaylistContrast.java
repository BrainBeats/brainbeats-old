package com.insa.pi.brainbeats.db;


import android.provider.BaseColumns;

public class PlaylistContrast {

    public PlaylistContrast() {}

    /* Inner class that defines the table contents */
    public static abstract class PlaylistEntry implements BaseColumns {
        public static final String TABLE_NAME = "playlist";
        public static final String COLUMN_NAME_LIST = "listname";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PlaylistEntry.TABLE_NAME + " (" +
                    PlaylistEntry._ID + " INTEGER PRIMARY KEY," +
                    PlaylistEntry.COLUMN_NAME_LIST + TEXT_TYPE + COMMA_SEP +
                    PlaylistEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PlaylistEntry.TABLE_NAME;
}
