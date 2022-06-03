package com.example.mad_final_example.Database;

import android.provider.BaseColumns;

public final class UserProfile {
    // make the constructor private.
    private UserProfile(){}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_1= "username";
        public static final String COLUMN_2 = "dateOfBirth";
        public static final String COLUMN_3 = "password";
        public static final String COLUMN_4 = "gender";
    }
}
