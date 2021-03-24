package com.hirunz2000.tut6_task1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.hirunz2000.tut6_task1.Constants.DATE;
import static com.hirunz2000.tut6_task1.Constants.TABLE_NAME;
import static com.hirunz2000.tut6_task1.Constants.TIME;
import static com.hirunz2000.tut6_task1.Constants.WEATHER;

public class WeatherData extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="weatherData.db";
    private static final int DATABASE_VERSION=1;

    private static String weatherTable="CREATE TABLE "+ TABLE_NAME +"(" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            WEATHER +" VARCHAR(50) NOT NULL, "+
            DATE +" DATE NOT NULL, "+
            TIME +" VARCHAR(10) NOT NULL "+
            " );";


    public WeatherData(Context ctx){
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(weatherTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }
}
