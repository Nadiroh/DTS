package com.example.pertemuan8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GanjilGenap extends AppCompatActivity {
    EditText Angka;
    TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganjil_genap);

        Angka = findViewById(R.id.eAngka);
        Hasil = findViewById(R.id.txtHasil);
    }

    public void Tampilkan(View v){
        int hasil;
        int angka = Integer.parseInt(Angka.getText().toString());
        hasil = angka % 2;
            if(hasil==0){
                Hasil.setText("Bilangan "+angka+" Genap");
            }else {
                Hasil.setText("Bilangan "+angka+" Ganjil");
            }

    }
}
