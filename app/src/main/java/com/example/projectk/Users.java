package com.example.projectk;

import android.provider.BaseColumns;

public class Users {

    public  static final class  UsersEntry implements BaseColumns {
        public  static final String TABLE_NAME = "Users";
        public  static final String COLUMN_ROLE = "Role";
        public  static final String COLUMN_LOGIN = "UserLogin";
        public  static final String COLUMN_PASSWORD = "UserPassword";

        public static final  String TYPE_TEXT = "TEXT";
        public static final  String TYPE_INT = "INTEGER";

        public  static final String CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "("+ _ID + " PRIMARY KEY AUTOINCREMENT, " +" " + TYPE_INT + COLUMN_ROLE + " " + TYPE_TEXT + ", " + COLUMN_LOGIN + "" +
                TYPE_TEXT + ", " + COLUMN_PASSWORD + "" + TYPE_TEXT + ")";

        public static  final String DEL_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}

}
