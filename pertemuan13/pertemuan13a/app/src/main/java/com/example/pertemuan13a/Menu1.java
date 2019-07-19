package com.example.pertemuan13a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Menu1 extends AppCompatActivity {
    EditText nim,nama;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        nim = findViewById(R.id.ketik_nim);
        nama = findViewById(R.id.ketik_nama);
        hasil = findViewById(R.id.txt_Hasil);
    }

    public void klik_Hasil(View v){
        hasil.setText(nim.getText()+ "\n" +nama.getText());
    }
}
