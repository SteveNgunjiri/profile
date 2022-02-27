package com.example.schoolproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
     DB.execSQL("create Table Userdetails(name TEXT primary key, contact TEXT, dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
    DB.execSQL("drop Table if exists Userdetails");
    }
    public Boolean insertuserdata(String name, String address, String Username, String Password){
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",name);
        contentValues.put("Username",Username);
        contentValues.put("Password",Password);
        long results=DB.insert("Userdetails",null, contentValues);
        if(results==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updateuserdata(String name, String address,String Username,String Password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username", Username);
        contentValues.put("Password", Password);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?", new String[]{name});
        if (cursor.getCount() > 0) {

            long results = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (results == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
        public Boolean deleterdata(String name) {
            SQLiteDatabase DB = this.getWritableDatabase();

            Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?", new String[]{name});
            if (cursor.getCount() > 0) {

                long results = DB.delete("Userdetails", "name=?", new String[]{name});
                if (results == -1) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
                public Cursor getdata ()
                {
                    SQLiteDatabase DB = this.getWritableDatabase();

                    Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
                    return cursor;
                }
            }