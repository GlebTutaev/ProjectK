package com.example.projectk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class AutActivity extends AppCompatActivity {

    EditText edt_Login;
    EditText edt_Password;
    Button btn_Login;
    Button btn_Back;

    private DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        dbHelper = new DbHelper(this);
        try {
            dbHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            sqLiteDatabase = dbHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }


        btn_Login = findViewById(R.id.Login);
        btn_Back = findViewById(R.id.GoBack);
        edt_Login = findViewById(R.id.LoginField);
        edt_Password = findViewById(R.id.PasswordField);





        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users", null);
               // if(){

               // }
            }
        });
    }
    public void OnClick(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}