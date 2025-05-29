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
    private static final String DATABASE_NAME = "test_db";
    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
// create notes table
        String createQuery="CREATE TABLE information(name TEXT, email TEXT, phone TEXT, feedback TEXT)";
        db.execSQL(createQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
// Create tables again
        onCreate(db);
    }
    //code to insert data
    public void insertData(String name, String email, String phone, String feedback){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email", email);
        contentValues.put("phone",phone);
        contentValues.put("feedback",feedback);
//inserting row
        db.insert("information",null,contentValues);
        db.close();
    }
    //code to select data
    public Cursor selectData(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM information";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }
    //code to update data
    public void updateData(String name, String email, String phone, String feedback){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email", email);
        contentValues.put("phone",phone);
        contentValues.put("feedback",feedback);
//updating row
        db.update("information",contentValues,"phone=?",new String[]{phone});
        db.close();
    }
    //code to delete data
    public void deleteData(String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
//deleting row
        db.delete("information","phone=?",new String[]{phone});
    }
}
