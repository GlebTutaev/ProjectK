package com.example.projectk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonSighIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSighIn = findViewById(R.id.buttonSighIn);
        buttonSighIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAuthActivity();
            }
        });
    }

    private void showAuthActivity() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Войти");
        dialog.setMessage("Введите данные для входа");

        LayoutInflater inflater = LayoutInflater.from(this);
        View authwindow = inflater.inflate(R.layout.activity_auth, null);
        dialog.setView(authwindow);

        EditText login = authwindow.findViewById(R.id.LoginField);
        EditText password = authwindow.findViewById(R.id.PasswordField);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(login.getText().toString())){

                }
            }
        });
    }
}