package com.example.pertemuan9a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nim, nama, kampus;
    TextView hasil1,hasil2,hasil3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nim =  findViewById(R.id.etNim);
        nama = findViewById(R.id.etNama);
        kampus = findViewById(R.id.etKampus);
        hasil1 = findViewById(R.id.txtHASIL1);
        hasil2 = findViewById(R.id.txtHASIL2);
        hasil3 = findViewById(R.id.txtHASIL3);
    }

    public void klik_OK (View v){
        hasil1.setText("Nim : "+nim.getText());
        hasil2.setText("Nama : "+nama.getText());
        hasil3.setText("Kampus : "+kampus.getText());
    }
}
