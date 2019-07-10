package com.example.pertemuan7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView hasil;
    EditText nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasil =  findViewById(R.id.tHNama);
        nama = findViewById(R.id.eMNama);
    }

    public void Menampilkan(View v){
        hasil.setText("Nama Anda Adalah : "+ nama.getText());
    }
}
