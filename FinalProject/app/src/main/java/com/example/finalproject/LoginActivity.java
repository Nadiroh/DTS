package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editUser,editPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUser = findViewById(R.id.username);
        editPass = findViewById(R.id.pass);
    }

    public void klik_Login(View v){
        String user = editUser.getText().toString();
        String pass = editPass.getText().toString();
        if (user.equals("admin") && pass.equals("admin")){
            Intent intent = new Intent(LoginActivity.this,Main2Activity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this,"Username dan Password salah",Toast.LENGTH_SHORT).show();
        }
    }

    public void klik_Keluar(View v){
        finish();
    }
}
