package com.example.pertemuan9b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //mendeklarasikan listview var dan menginisialasi array tipe data string
    private ListView lvlitem;
    private String[] namanegara = new String[]{
            "Indonesia","Malaysia","Singapore",
            "Italia","Inggris","Belanda",
            "Argentina","Chile",
            "Mesir","Uganda" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("ListView Sederhana");//tampil judul

        //Membinding atau memformat data
        lvlitem = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,namanegara);

        //menset data di dalam listview
        lvlitem.setAdapter(adapter);

        lvlitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Memilih : "+namanegara[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}
