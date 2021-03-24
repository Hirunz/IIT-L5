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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView view_cocktail_search;
    private EditText text_cocktail_search;




    private static final String BASE_URL1 ="https://www.thecocktaildb.com/api/json/v1/1/filter.php?";
    private static final String BASE_URL2 ="https://www.thecocktaildb.com/api/json/v1/1/search.php?";
    private static final String QUERY_PARAM ="i";
    private static final String QUERY_PARAM2 ="s";



    private String cocktails;
    private String cocktails2;
    private  String cocktail;
    private  Cocktail cocktail2;

    private Spinner spinner;
    private ArrayAdapter<String> spinnerArrayAdapter;

    private ArrayList<String> cocktailnamesArray;
    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_cocktail_search = findViewById(R.id.view_cocktail_search);
        text_cocktail_search = findViewById(R.id.edit_search);

        cocktailnamesArray = new ArrayList<>();
        cocktailnamesArray.add("Select a Cocktail");
        spinner = findViewById(R.id.spinner);
        layout = findViewById(R.id.l1);

         spinnerArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, cocktailnamesArray);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, parent.getItemAtPosition(position).toString());
                searchCocktail(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void searchCocktail(View view) {


        new Thread(new Runnable() {
            @Override
            public void run() {

                runSearchCocktail();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(LOG_TAG,"setting the text view");

                        StringBuilder builder = new StringBuilder();


                        try {
                            JSONObject array = new JSONObject(cocktails);

                            JSONArray arr = array.getJSONArray("drinks");

                            for (int i = 0; i < arr.length(); i++) {
                                String str = arr.getJSONObject(i).getString("strDrink");
                                cocktailnamesArray.add( arr.getJSONObject(i).getString("strDrink"));

                                builder.append(str).append("\n");

                            }

                            view_cocktail_search.setText(builder.toString());

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
        Uri uri = Uri.parse(BASE_URL1).buildUpon()
                .appendQueryParameter(QUERY_PARAM, text_cocktail_search.getText().toString())
                .build();

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


    public void searchCocktail(String val) {


        new Thread(new Runnable() {
            @Override
            public void run() {

                runSearchCocktail2(val);


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(LOG_TAG,"setting the text vieew");
                        Log.d(LOG_TAG, cocktails2);


                        try {
                            JSONObject array = new JSONObject(cocktails2);

                            JSONArray arr = array.getJSONArray("drinks");

                            for (int i = 0; i < arr.length(); i++) {
                                String idDrink = arr.getJSONObject(i).getString("idDrink");
                                String strDrink = arr.getJSONObject(i).getString("strDrink");
                                String strInstructions = arr.getJSONObject(i).getString("strInstructions");
                                String strDrinkThumb = arr.getJSONObject(i).getString("strDrinkThumb");

                                cocktail2 =new Cocktail(idDrink, strDrink, strInstructions, strDrinkThumb);
                                Log.d(LOG_TAG, cocktail2.toString());
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


    public void runSearchCocktail2(String val){
        Log.d(LOG_TAG,"Thread started...");
        Uri uri = Uri.parse(BASE_URL2).buildUpon()
                .appendQueryParameter(QUERY_PARAM2, val)
                .build();


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


            cocktails2 = stringBuilder.toString();
            Log.d(LOG_TAG, stringBuilder.toString());





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
                    URL url = new URL(cocktail2.getStrDrinkThumb());
                    Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            view_cocktail_search.setText("");


                            TextView v = new TextView(getApplicationContext());
                            v.setLayoutParams(lparams);
                            v.setText(cocktail2.getStrDrink());
                            v.setGravity(Gravity.CENTER);
                            v.setTextSize(18);



                            layout.addView(v);

                            ImageView img = new ImageView(getApplicationContext());
                            img.setImageBitmap(bmp);
                            layout.addView(img);

                            v = new TextView(getApplicationContext());
                            v.setLayoutParams(lparams);
                            v.setText(cocktail2.getStrInstructions());


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
        Intent intent = new Intent(this, RandomCocktail.class);
        startActivity(intent);
    }
}