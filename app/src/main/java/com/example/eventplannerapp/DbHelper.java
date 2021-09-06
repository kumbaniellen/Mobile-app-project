package com.example.eventplannerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

import java.text.Normalizer;

public class DbHelper extends SQLiteOpenHelper {


    public DbHelper(@Nullable Context context) {
        super(context, "EventPlanner.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Register_Admin (FName text, E_mail text primary key, Number text, Pin text) ");
        db.execSQL("Create table Register_Supplier (FullName text, Email text primary key, Contact text, Password text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Register_Admin");
        db.execSQL("drop table if exists Register_Supplier");


    }

    Boolean insertSupplier(String fullName, String email, String contact, String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FullName", fullName);
        contentValues.put("Email", email);
        contentValues.put("Contact", contact);
        contentValues.put("Password", password);

        long inset = database.insert("Register_Supplier", null, contentValues);
        if (inset == -1) return false;
        else return true;

    }


    public Boolean checkMail(String Email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Register_Supplier WHERE  Email=? ", new String[]{Email});
        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean checkEmailPass(String Email, String Password) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Register_Supplier WHERE Email=? and Password=? ", new String[]{Email, Password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

}