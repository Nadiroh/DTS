package com.example.pertemuan11a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "kampus.db";
    private static final int DATABASE_VERSION = 1;
    private static final String QUERY_CREATE = "CREATE TABLE mahasiswa(nim INTEGER PRIMARY KEY AUTOINCREMENT,nama_mhs TEXT);";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
        Log.d("table", QUERY_CREATE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS 'mahasiswa'");;
        onCreate(db);
    }

   public long insertData(String input){
        SQLiteDatabase db = this.getWritableDatabase();
        //creating content values
       ContentValues values = new ContentValues();
       values.put("nama_mhs",input);

       //insert row in students table
       long insert = db.insert("mahasiswa",null,values);
       return insert;
    }

    public ArrayList<String> getAllStudentsList(){
        ArrayList<String> dataArrayList = new ArrayList<String>();
        String cache="";
        String selectQuery = "SELECT * FROM 'mahasiswa'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery,null);

        //looping through all rows and adding to List
        if (c.moveToFirst()) {
            do {
                cache = c.getString(c.getColumnIndex("nama_mhs"));

                //adding to Students List
                dataArrayList.add(cache);
            } while (c.moveToNext());
            Log.d("array", dataArrayList.toString());
        }
        return dataArrayList;
    }
}
