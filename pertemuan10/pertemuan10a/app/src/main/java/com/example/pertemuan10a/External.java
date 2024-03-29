package com.example.pertemuan10a;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class External extends AppCompatActivity {
    public static final String FILENAME = "externalfile.txt";
    TextView EtextBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);
        EtextBaca = findViewById(R.id.textBacaE);
    }

    public void EbuatFile(View v){
        String buat = "Coba Isi Data File Text";
        String kondisi = Environment.getExternalStorageState();

        if(!Environment.MEDIA_MOUNTED.equals(kondisi)){
            return;
        }
        File file = new File(getExternalFilesDir(null),FILENAME);

        FileOutputStream outputstream = null;
        try{
            file.createNewFile();
            outputstream = new FileOutputStream(file,true); // append menyimpan
            outputstream.write(buat.getBytes());
            outputstream.flush();
            outputstream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void EubahFile(View v){
        String update = "Update Isi Data File Text";
        String kondisi = Environment.getExternalStorageState();

        if(!Environment.MEDIA_MOUNTED.equals(kondisi)){
            return;
        }
        File file = new File(getExternalFilesDir(null),FILENAME);

        FileOutputStream outputstream = null;
        try{
            file.createNewFile();
            outputstream = new FileOutputStream(file,false); // append menimpa/overwrite
            outputstream.write(update.getBytes());
            outputstream.flush();
            outputstream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void EbacaFile(View v){
        File sdcard = getExternalFilesDir(null);
        File file = new File(getExternalFilesDir(null),FILENAME);

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
            EtextBaca.setText(text.toString());
        }
    }

    public void EhapusFile(View v){
        File file = new File(getExternalFilesDir(null),FILENAME);
        if (file.exists()){
            file.delete();
        }
    }
}
