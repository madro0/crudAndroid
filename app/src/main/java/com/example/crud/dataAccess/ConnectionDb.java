package com.example.crud.dataAccess;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.crud.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class ConnectionDb extends SQLiteOpenHelper {
    public ConnectionDb(@Nullable Context context) {
        super(context, "gymdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase gymdb) {
        gymdb.execSQL("Create Table user ("+"Id integer primary key autoincrement  not null,"+
                        "name text not null,"+
                        "lastname text not null,"+
                        "email text not null,"+
                        "password text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public List<UserModel> showListUsers(){

        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM user", null);

        List<UserModel>  listUsers = new ArrayList<>();

        if(cursor.moveToFirst()){
            do {
                listUsers.add(new UserModel(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(0)));
            }while (cursor.moveToNext());
        }
        return listUsers;
    }
    public boolean validateIfExistEmail(String email){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email= '"+ email+ "'Limit 1", null);
        if (cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }
    public boolean ValidateLogin(String email, String password){
        SQLiteDatabase db = getReadableDatabase();
        //Cursor cursor = db.rawQuery("Select * from user where email= '"+ email+ "' and password= '"+password+"'Limit 1", null);

        Cursor cursor = db.rawQuery("Select * from user where email= '"+ email+ "'Limit 1", null);

        if(cursor.moveToFirst()){
            return  true;
        }else{
            return false;
        }
    }
}
