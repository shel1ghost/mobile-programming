package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "pncdb";
    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    // create notes table
        String createQuery="CREATE TABLE users(username TEXT,password TEXT, email TEXT)";
        db.execSQL(createQuery);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
    // Create tables again
        onCreate(db);
    }
    //code to insert data
    public void insertData(String username,String password, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("email",email);
    //inserting row
        db.insert("users",null,contentValues);
        db.close();
    }
    //code to select data
    public Cursor selectData(String email, String password){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM users WHERE email='"+email+"' AND password='"+password+"';";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }

}
