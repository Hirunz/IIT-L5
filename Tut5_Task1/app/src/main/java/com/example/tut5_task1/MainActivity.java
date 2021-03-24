package com.example.tut5_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import static android.provider.BaseColumns._ID;
import static com.example.tut5_task1.Constants.TABLE_NAME;
import static com.example.tut5_task1.Constants.TIME;
import static com.example.tut5_task1.Constants.TITLE;

public class MainActivity extends AppCompatActivity {
    private static String[] FROM = {_ID,TIME, TITLE,};
    private static String ORDER_BY = TIME + " DESC ";
    private EventsData events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        events=new EventsData(this);
        try{
            addEvent("Hello, !");
            Cursor cursor = getEvents();
            showEvents(cursor);
        }finally {
            events.close();
        }
    }

    private void showEvents(Cursor cursor) {
        StringBuilder builder= new StringBuilder("Saved events: \n");
        while (cursor.moveToNext()){
            long id=cursor.getLong(0);
            long time=cursor.getLong(1);
            String title= cursor.getString(2);

            builder.append(id).append(": ");
            builder.append(time).append(": ");
            builder.append(title).append(": \n");

        }
        cursor.close();

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(builder);
    }

    private Cursor getEvents() {
        SQLiteDatabase db=events.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME, FROM, null, null,
                null, null,ORDER_BY);
        return cursor;
    }

    private void addEvent(String string) {
        SQLiteDatabase db=events.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TIME, System.currentTimeMillis());
        values.put(TITLE, string);
        db.insertOrThrow(TABLE_NAME, null, values);

    }
}