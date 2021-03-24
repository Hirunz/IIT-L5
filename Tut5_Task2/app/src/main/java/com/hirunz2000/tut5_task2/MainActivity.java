package com.hirunz2000.tut5_task2;
import com.hirunz2000.tut5_task2.Constants;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.BaseColumns._ID;
import static com.hirunz2000.tut5_task2.Constants.EMPLOYEE_ADDRESS;
import static com.hirunz2000.tut5_task2.Constants.EMPLOYEE_AGE;
import static com.hirunz2000.tut5_task2.Constants.EMPLOYEE_NAME;
import static com.hirunz2000.tut5_task2.Constants.EMPLOYEE_POSITION;
import static com.hirunz2000.tut5_task2.Constants.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    private static String[] FROM = {_ID, EMPLOYEE_NAME, EMPLOYEE_ADDRESS, EMPLOYEE_AGE, EMPLOYEE_POSITION};
    private static String ORDER_BY = _ID ;
    private Database database;

    private EditText id,name,address,age,position;
    private TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(this);

        id= findViewById(R.id.db_id);
        name= findViewById(R.id.db_name);
        address= findViewById(R.id.db_address);
        age= findViewById(R.id.db_age);
        position= findViewById(R.id.db_position);
        data=findViewById(R.id.db_data);

        showData();
    }

    public void addEmployee(View view) {
        SQLiteDatabase db=database.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(_ID, Integer.parseInt(id.getText().toString()));
        values.put(EMPLOYEE_NAME, name.getText().toString());
        values.put(EMPLOYEE_ADDRESS, address.getText().toString());
        values.put(EMPLOYEE_AGE, Integer.parseInt(age.getText().toString()));
        values.put(EMPLOYEE_POSITION, position.getText().toString());

        db.insertOrThrow(TABLE_NAME, null, values);
        showData();
    }

    private StringBuilder getEmployeesString(Cursor cursor) {

        StringBuilder builder= new StringBuilder();
        while (cursor.moveToNext()){
            String id=cursor.getString(0);
            String name=cursor.getString(1);
            String address= cursor.getString(2);
            String age= cursor.getString(3);
            String position= cursor.getString(4);

            builder.append(id).append(": ");
            builder.append(name).append(": ");
            builder.append(address).append(": ");
            builder.append(age).append(": ");
            builder.append(position).append(": \n");

        }
        cursor.close();

        return builder;
    }

    private void showData(){
        Cursor cursor = getEmployees();
        StringBuilder builder = getEmployeesString(cursor);

        data.setText(builder.toString());
    }

    private Cursor getEmployees() {
        SQLiteDatabase db=database.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME, FROM, null, null,
                null, null,ORDER_BY);
        return cursor;
    }



    public void updateEmp(View view) {

        SQLiteDatabase db=database.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(EMPLOYEE_NAME, name.getText().toString());
        values.put(EMPLOYEE_ADDRESS, address.getText().toString());
        values.put(EMPLOYEE_AGE, Integer.parseInt(age.getText().toString()));
        values.put(EMPLOYEE_POSITION, position.getText().toString());

        db.update(TABLE_NAME,values,
                " _ID = ? " , new String[]{id.getText().toString()}
        );
        showData();



    }

    public void deleteEmp(View view) {
        SQLiteDatabase db=database.getWritableDatabase();
        db.delete(TABLE_NAME, " _ID = ? ", new String[]{id.getText().toString()});
        showData();
    }
}