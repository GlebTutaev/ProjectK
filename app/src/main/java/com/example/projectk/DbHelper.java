package com.example.projectk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import Basa.User;

public class DbHelper extends SQLiteOpenHelper {

    private  static final String DB_NAME = "TimeTable.db";
    private  static final int DB_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Users.UsersEntry.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(Users.UsersEntry.DEL_TABLE);
        onCreate(db);
    }

    public void addUser(User user){
        //https://www.youtube.com/watch?v=7bbE2kxIPBk
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Users.UsersEntry.COLUMN_ROLE, user.getRole());
        contentValues.put(Users.UsersEntry.COLUMN_LOGIN, user.getLogin());
        contentValues.put(Users.UsersEntry.COLUMN_PASSWORD, user.getPassword());

        db.insert(Users.UsersEntry.TABLE_NAME,  null, contentValues);
        db.close();
    }

    public User getUser(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Users.UsersEntry.TABLE_NAME, new String[]{Users.UsersEntry._ID, Users.UsersEntry.COLUMN_ROLE, Users.UsersEntry.COLUMN_PASSWORD, Users.UsersEntry.COLUMN_LOGIN},
                Users.UsersEntry._ID + "=? ", new String[]{String.valueOf(id)}, null, null, null, null);
    }

}
