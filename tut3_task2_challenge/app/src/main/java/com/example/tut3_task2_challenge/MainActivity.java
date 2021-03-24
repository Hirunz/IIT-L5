package com.example.tut3_task2_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA__MESSAGE="com.example.tut3_task2_challenge.MainActivity.extra.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchParagraph1(View view) {
        Intent intent=new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA__MESSAGE,1);
        startActivity(intent);

    }

    public void launchParagraph2(View view) {
        Intent intent=new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA__MESSAGE,2);
        startActivity(intent);
    }

    public void launchParagraph3(View view) {
        Intent intent=new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA__MESSAGE,3);
        startActivity(intent);
    }
}