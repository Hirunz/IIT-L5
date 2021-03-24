package com.example.tut3_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    public static int picId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ImageView v1 = findViewById(R.id.im_view);
//        v1.setImageResource(R.drawable.brittany_02625);



        ImageView v1 = findViewById(R.id.im_view);
        String resource = "brittany_02625";
        int resource_id = getResources().getIdentifier(resource,
                "drawable", "com.example.tut3_task1");
        v1.setImageResource(resource_id);
        picId=1;
    }

    public void changePicture(View view) {
        ImageView v1;

        if(picId==0){
             v1 = findViewById(R.id.im_view);
             v1.setImageResource(R.drawable.brittany_02625);
             picId=1;
        }
        else{
            v1 = findViewById(R.id.im_view);
            v1.setImageResource(R.drawable.welsh_springer_spaniel_08203);
            picId=0;
        }

    }
}
