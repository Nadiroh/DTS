package com.example.pertemuan10a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Tampilan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan);
    }

    public void Klik_Internal(View v){
        Intent internal = new Intent(Tampilan.this,MainActivity.class);
        startActivity(internal);
    }

    public void Klik_External(View v){
        Intent external = new Intent(Tampilan.this,External.class);
        startActivity(external);
    }
}
