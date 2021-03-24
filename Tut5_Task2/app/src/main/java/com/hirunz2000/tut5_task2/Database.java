package com.hirunz2000.tut5_task2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static android.provider.BaseColumns._ID;
import static com.hirunz2000.tut5_task2.Constants.EMPLOYEE_ADDRESS;
import static com.hirunz2000.tut5_task2.Constants.EMPLOYEE_AGE;
import static com.hirunz2000.tut5_task2.Constants.EMPLOYEE_NAME;
import static com.hirunz2000.tut5_task2.Constants.EMPLOYEE_POSITION;
import static com.hirunz2000.tut5_task2.Constants.TABLE_NAME;

public class Database  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="company.db";
    private static final int DATABASE_VERSION=1;

    private static String empTable="CREATE TABLE "+ TABLE_NAME +"(" +
            _ID + " INTEGER PRIMARY KEY, "+
            EMPLOYEE_NAME +" VARCHAR(25) NOT NULL, "+
            EMPLOYEE_ADDRESS +" VARCHAR(60) NOT NULL, "+
            EMPLOYEE_AGE +" INTEGER(2) NOT NULL, "+
            EMPLOYEE_POSITION +" VARCHAR(15) NOT NULL "+
            ");";

    public Database(Context ctx){
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(empTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }
}
