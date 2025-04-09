package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper{
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "mydb";
    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
// create notes table
        String createQuery="CREATE TABLE mytable(id INTEGER PRIMARY KEY,name TEXT, address TEXT)";
        db.execSQL(createQuery);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
// Create tables again
        onCreate(db);
    }
    //code to insert data
    public void insertData(int id,String name, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("address",address);
//inserting row
        db.insert("mytable",null,contentValues);
        db.close();
    }
    //code to select data
    public Cursor selectData(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM mytable";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }
    //code to update data
    public void updateData(String id,String name, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("address",address);
//updating row
        db.update("mytable",contentValues,"id=?",new String[]{id});
        db.close();
    }
    //code to delete data
    public void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
//deleting row
        db.delete("mytable","id=?",new String[]{id});
    }
}
