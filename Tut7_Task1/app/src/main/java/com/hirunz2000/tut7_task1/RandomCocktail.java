package com.hirunz2000.tut7_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RandomCocktail extends AppCompatActivity {

    private static final String LOG_TAG = RandomCocktail.class.getSimpleName();
    private TextView view_cocktail_search;
    private EditText text_cocktail_search;




    private static final String BASE_URL ="https://www.thecocktaildb.com/api/json/v1/1/random.php";




    private String cocktails;
    private  Cocktail cocktail;
    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_cocktail);

        view_cocktail_search = findViewById(R.id.view_cocktail_search);
        text_cocktail_search = findViewById(R.id.edit_search);
        layout = findViewById(R.id.l1);

        searchCocktail();

    }

    public void searchCocktail() {


        new Thread(new Runnable() {
            @Override
            public void run() {

                runSearchCocktail();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(LOG_TAG,"setting the text view");



                        try {
                            JSONObject array = new JSONObject(cocktails);

                            JSONArray arr = array.getJSONArray("drinks");

                            for (int i = 0; i < arr.length(); i++) {
                                String idDrink = arr.getJSONObject(i).getString("idDrink");
                                String strDrink = arr.getJSONObject(i).getString("strDrink");
                                String strInstructions = arr.getJSONObject(i).getString("strInstructions");
                                String strDrinkThumb = arr.getJSONObject(i).getString("strDrinkThumb");

                                cocktail =new Cocktail(idDrink, strDrink, strInstructions, strDrinkThumb);
                                Log.d(LOG_TAG, cocktail.toString());
                            }
                            displayCocktails();





                        }catch (JSONException e){
                            e.printStackTrace();
                        }



                    }
                });
            }
        }).start();


    }


    public void runSearchCocktail(){
        Log.d(LOG_TAG,"Thread started...");
        Uri uri = Uri.parse(BASE_URL);


        URL requestURL;
        HttpURLConnection conn =null;
        InputStreamReader is =null;

        try {
            requestURL= new URL(uri.toString());
            conn = (HttpURLConnection) requestURL.openConnection();

            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();


//                int response = conn.getResponseCode();

            is= new InputStreamReader(conn.getInputStream());

            BufferedReader reader = new BufferedReader((is));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }


            cocktails = stringBuilder.toString();





        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.disconnect();
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    public void displayCocktails(){


            LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lparams.setMargins(0,10,0,10);



            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL(cocktail.getStrDrinkThumb());
                        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView v = new TextView(getApplicationContext());
                                v.setLayoutParams(lparams);
                                v.setText(cocktail.getStrDrink());
                                v.setGravity(Gravity.CENTER);
                                v.setTextSize(18);



                                layout.addView(v);

                                ImageView img = new ImageView(getApplicationContext());
                                img.setImageBitmap(bmp);
                                layout.addView(img);

                                v = new TextView(getApplicationContext());
                                v.setLayoutParams(lparams);
                                v.setText(cocktail.getStrInstructions());


                                layout.addView(v);
                            }
                        });
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
    }

    public void onBtn1(View view) {
        Intent intent = new Intent(this, CocktailSearch.class);
        startActivity(intent);
    }

    public void onBtn2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onBtn3(View view) {
        Intent intent = new Intent(this, RandomCocktail.class);
        startActivity(intent);
    }
}