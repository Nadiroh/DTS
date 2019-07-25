package com.example.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt_id, txt_nama, txt_alamat ;
    dbHelper SQLite = new dbHelper(this);
    String id,nama,alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_id = findViewById(R.id.id);
        txt_nama = findViewById(R.id.nama);
        txt_alamat = findViewById(R.id.alamat);

        id = getIntent().getStringExtra(Main2Activity.Tag_Id);
        nama = getIntent().getStringExtra(Main2Activity.Tag_Nama);
        alamat = getIntent().getStringExtra(Main2Activity.Tag_Alamat);

        if (id == null || id == ""){
            setTitle("Tambah Data");
        }else {
            setTitle("Edit Data");
            txt_id.setText(id);
            txt_nama.setText(nama);
            txt_alamat.setText(alamat);
        }
    }

    public void klik_simpan(View v){
        try{
            if (txt_id.getText().toString().equals("")){
                simpan();
            } else {
                edit();
            }
        } catch (Exception e){
            Log.e("Simpan",e.toString());
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                blank();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void blank(){
        txt_nama.requestFocus();
        txt_id.setText(null);
        txt_nama.setText(null);
        txt_alamat.setText(null);
    }

    private void simpan(){
        if(String.valueOf(txt_nama.getText()).equals(null)  || String.valueOf(txt_nama.getText()).equals("")
                || String.valueOf(txt_alamat.getText()).equals(null) || String.valueOf(txt_alamat.getText()).equals("")){
            Toast.makeText(getApplicationContext(),
                    "Please input name or address ...",Toast.LENGTH_SHORT).show();
        } else {
            SQLite.tambah(txt_nama.getText().toString().trim(),txt_alamat.getText().toString().trim());
            blank();
            finish();
        }
    }

    private void edit(){
        if(String.valueOf(txt_nama.getText()).equals(null)  || String.valueOf(txt_nama.getText()).equals("")
                || String.valueOf(txt_alamat.getText()).equals(null) || String.valueOf(txt_alamat
                .getText()).equals("")){
            Toast.makeText(getApplicationContext(),
                    "Please input name or address ...",Toast.LENGTH_SHORT).show();
        } else {
            SQLite.Edit(Integer.parseInt(txt_id.getText().toString().trim()),txt_nama.getText().toString().trim(),txt_alamat.getText().toString().trim());
            blank();
            finish();
        }
    }
}
