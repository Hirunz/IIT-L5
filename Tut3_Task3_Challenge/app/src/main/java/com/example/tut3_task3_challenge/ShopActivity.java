package com.example.tut3_task3_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ShopActivity extends AppCompatActivity {


    public static final String REPLY="ShopActivity";
    public static final String LOG_TAG="ShopActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
    }

    public void addItem(View view) {
        String chosenItem = view.getTag().toString();
        Intent intent = new Intent();
        intent.putExtra(REPLY, chosenItem);
        setResult(RESULT_OK,intent);
        Log.d(LOG_TAG,"Finishing shop activity");
        finish();
    }


}