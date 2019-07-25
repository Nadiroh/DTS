package com.example.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.finalproject.Adapter;
import com.example.finalproject.dbHelper;
import com.example.finalproject.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> listitem = new ArrayList<Data>();
    Adapter adapter;
    dbHelper SQLite = new dbHelper(this);

    public static final String Tag_Id = "id";
    public static final String Tag_Nama = "nama";
    public static final String Tag_Alamat = "alamat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        SQLite = new dbHelper(getApplicationContext());
        adapter = new Adapter(Main2Activity.this,listitem);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final String idx = listitem.get(position).getId();
                final String namax = listitem.get(position).getListnama();
                final String alamatx = listitem.get(position).getListalamat();

                final CharSequence[] dialogitem = {"Edit","Hapus"};
                dialog = new AlertDialog.Builder(Main2Activity.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                                intent.putExtra(Tag_Id,idx);
                                intent.putExtra(Tag_Nama,namax);
                                intent.putExtra(Tag_Alamat,alamatx);
                                startActivity(intent);
                                break;
                            case 1:
                                SQLite.hapus(Integer.parseInt(idx));
                                listitem.clear();
                                semuaData();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
        semuaData();
    }

    private void semuaData(){
        ArrayList<HashMap<String,String>> baris = SQLite.getSemuaData();

        for(int i=0; i<baris.size();i++){
            String idd = baris.get(i).get(Tag_Id);
            String namaa = baris.get(i).get(Tag_Nama);
            String alamatt = baris.get(i).get(Tag_Alamat);

            Data data = new Data();

            data.setId(idd);
            data.setListnama(namaa);
            data.setListalamat(alamatt);

            listitem.add(data);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listitem.clear();
        semuaData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.logout){
            startActivity(new Intent(Main2Activity.this,LoginActivity.class));
        }
        return true;
    }

}
