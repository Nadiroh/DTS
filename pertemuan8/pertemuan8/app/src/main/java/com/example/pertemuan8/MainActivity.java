package com.example.pertemuan8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Angka1, Angka2;
    TextView Hasil;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Angka1 = findViewById(R.id.edAngka1);
        Angka2 = findViewById(R.id.edAngka2);
        Hasil = findViewById(R.id.txHasil1);
    }

    public void Tambah(View v) {
        if (Angka1.getText().length() > 0 && Angka2.getText().length() > 0) {
            int angka1 = Integer.parseInt(Angka1.getText().toString());
            int angka2 = Integer.parseInt(Angka2.getText().toString());
            int hasil;
            hasil = angka1 + angka2;
            Hasil.setText(Integer.toString(hasil));
        } else{
            Toast toast = Toast.makeText(MainActivity.this,"Mohon Masukkan Angka",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void Kurang(View v){
        if (Angka1.getText().length() > 0 && Angka2.getText().length() > 0) {
            int angka1 = Integer.parseInt(Angka1.getText().toString());
            int angka2 = Integer.parseInt(Angka2.getText().toString());
            int hasil;
            hasil = angka1 - angka2;
            Hasil.setText(Integer.toString(hasil));
        }else{
            Toast toast = Toast.makeText(MainActivity.this,"Mohon Masukkan Angka",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void Kali(View v){
        if (Angka1.getText().length() > 0 && Angka2.getText().length() > 0) {
            int angka1 = Integer.parseInt(Angka1.getText().toString());
            int angka2 = Integer.parseInt(Angka2.getText().toString());
            int hasil;
            hasil = angka1 * angka2;
            Hasil.setText(Integer.toString(hasil));
        }else{
            Toast toast = Toast.makeText(MainActivity.this,"Mohon Masukkan Angka",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void Bagi(View v){
        if (Angka1.getText().length() > 0 && Angka2.getText().length() > 0) {
            int angka1 = Integer.parseInt(Angka1.getText().toString());
            int angka2 = Integer.parseInt(Angka2.getText().toString());
            int hasil;
            hasil = angka1 / angka2;
            Hasil.setText(Integer.toString(hasil));
        }else{
            Toast toast = Toast.makeText(MainActivity.this,"Mohon Masukkan Angka",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void Bersih(View v){
        Angka1.setText("");
        Angka2.setText("");
        Hasil.setText("");
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.ganjilgenap){
            Intent gg = new Intent(this,GanjilGenap.class);
            startActivity(gg);
        }
        return true;
    }
}
