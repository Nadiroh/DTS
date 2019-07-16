package com.example.pertemuan11a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnStore, btnGetall;
    private EditText etname;
    private DatabaseHelper databaseHelper;
    private TextView tvnames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        tvnames = findViewById(R.id.tvnames);

        btnStore = findViewById(R.id.btnstore);
        btnGetall = findViewById(R.id.btnget);
        etname = findViewById(R.id.etname);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.insertData(etname.getText().toString());
                etname.setText("");
                Toast.makeText(MainActivity.this,"Stored Successfully!",Toast.LENGTH_SHORT).show();
            }
        });

        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentsList();
                tvnames.setText("");
                for (int i = 0; i < arrayList.size(); i++){
                    if (i == 0){
                        tvnames.setText(arrayList.get(i));
                    } else {
                        tvnames.setText(tvnames.getText().toString() + ", " + arrayList.get(i));
                    }
                }
            }
        });
    }
}
