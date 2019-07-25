package com.example.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class dbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "final.db";
    public static final String TABLE_SQLite = "sqlite";

    public static final String Kolom_Id= "id";
    public static final String Kolom_Nama = "nama";
    public static final String Kolom_Alamat = "alamat";

    public dbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_Buat_Tabel = "CREATE TABLE final (id integer primary key autoincrement, nama text not null, alamat text not null)";
        db.execSQL(SQL_Buat_Tabel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS final");
        onCreate(db);
    }

    public ArrayList<HashMap<String,String>> getSemuaData(){
        ArrayList<HashMap<String,String>> listdata;
        listdata = new ArrayList<HashMap<String, String>>();
        String pilihQuery = "SELECT *FROM final";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(pilihQuery,null);

        if (cursor.moveToFirst()){
            do {
                HashMap<String,String> map = new HashMap<String, String>();
                map.put(Kolom_Id,cursor.getString(0));
                map.put(Kolom_Nama,cursor.getString(1));
                map.put(Kolom_Alamat,cursor.getString(2));
                listdata.add(map);
            } while (cursor.moveToNext());
        }

        Log.e("pilih sqlite ","" + listdata);

        database.close();
        return listdata;
    }

    public void tambah(String nama, String alamat){
        SQLiteDatabase database = this.getWritableDatabase();
        String queryvalues = "INSERT INTO final(nama,alamat) VALUES ('" + nama + "','" + alamat + "')";

        Log.e("tambah sqlite ",""+queryvalues);
        database.execSQL(queryvalues);
        database.close();
    }

    public void Edit(int id, String nama, String alamat){
        SQLiteDatabase database = this.getWritableDatabase();

        String editData = "UPDATE final set nama = '" + nama + "',alamat = '" + alamat + "' WHERE id = '" + id +"'";
        Log.e("data di Edit ",editData);
        database.execSQL(editData);
        database.close();
    }

    public void hapus(int id){
        SQLiteDatabase database = this.getWritableDatabase();

        String editData = "DELETE FROM final WHERE id = '" + id + "'";
        Log.e("data di edit ",editData);
        database.execSQL(editData);
        database.close();
    }

}
