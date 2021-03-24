package com.example.tut3_task2_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mParagraphHeading;
    private TextView mParagraphText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent=getIntent();
        int paragraphId=intent.getIntExtra(MainActivity.EXTRA__MESSAGE,0);

        mParagraphHeading=findViewById(R.id.paragraph_heading);
        mParagraphText=findViewById(R.id.paragraph_text);

        if(paragraphId==1){
            mParagraphHeading.setText(R.string.paragraph1_heading);
            mParagraphText.setText(R.string.paragraph1_text);
        }else if (paragraphId==2){
            mParagraphHeading.setText(R.string.paragraph2_heading);
            mParagraphText.setText(R.string.paragraph2_text);
        }else if (paragraphId==3){
            mParagraphHeading.setText(R.string.paragraph3_heading);
            mParagraphText.setText(R.string.paragraph3_text);
        }else{
            mParagraphHeading.setText(R.string.paragraph_heading);
            mParagraphText.setText(R.string.paragraph_text);
        }

    }
}