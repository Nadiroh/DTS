package com.example.pertemuan15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editUsername,editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
    }

    public void klik_Login(View view){
        String user = editUsername.getText().toString();
        String pass = editPassword.getText().toString();
        if (user.equals("Admin") && pass.equals("ADMIN")){
            startActivity(new Intent(LoginActivity.this,MenuUtama.class));
        }else {
            Toast.makeText(LoginActivity.this,"Username dan Password anda salah",Toast.LENGTH_LONG).show();
        }
    }
}
