package com.example.pertemuan10a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String FILENAME = "namafile.txt";
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBaca = findViewById(R.id.textBaca);
    }

    public void buatFile(View v){
        String isiFile = "Coba Isi Data File Text";
        File file = new File(getFilesDir(),FILENAME);

        FileOutputStream outputstream = null;
        try{
            file.createNewFile();
            outputstream = new FileOutputStream(file,true); // append menyimpan
            outputstream.write(isiFile.getBytes());
            outputstream.flush();
            outputstream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ubahFile(View v){
        String ubah = "Update Isi Data File Text";

        File file = new File(getFilesDir(),FILENAME);

        FileOutputStream outputstream = null;
        try{
            file.createNewFile();
            outputstream = new FileOutputStream(file,false); // append menimpa/overwrite
            outputstream.write(ubah.getBytes());
            outputstream.flush();
            outputstream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void bacaFile(View v){
        File sdcard = getFilesDir();
        File file = new File(sdcard,FILENAME);

        if (file.exists()){
            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();

                while (line != null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e){
                System.out.println("Error "+ e.getMessage());
            }
            textBaca.setText(text.toString());
        }
    }

    public void hapusFile(View v){
        File file = new File(getFilesDir(),FILENAME);
        if (file.exists()){
            file.delete();
        }
    }
}
