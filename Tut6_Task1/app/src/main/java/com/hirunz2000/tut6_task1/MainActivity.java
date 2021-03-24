package com.hirunz2000.tut6_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.provider.BaseColumns._ID;
import static com.hirunz2000.tut6_task1.Constants.DATE;
import static com.hirunz2000.tut6_task1.Constants.TABLE_NAME;
import static com.hirunz2000.tut6_task1.Constants.TIME;
import static com.hirunz2000.tut6_task1.Constants.WEATHER;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY="ee73bf38268c1be6b2ba46b70be37d25";
    private static final String LOG_TAG= MainActivity.class.getSimpleName();

//    private String url = "https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}";

   private static final String BASE_URL ="http://api.openweathermap.org/data/2.5/weather?";
   private static final String QUERY_PARAM ="q";
   private static final String API_PARAM ="appid";

   private TextView londonWeather, weather,data;
   private EditText selected_city;

   private String city;

   private boolean displayedLondonWeather =false;


    private static String[] FROM = {_ID, WEATHER, DATE, TIME};
    private static String ORDER_BY = _ID ;
    private WeatherData database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        londonWeather = findViewById(R.id.london_weather);
        weather = findViewById(R.id.weather);
        selected_city = findViewById(R.id.editText_city);
        data = findViewById(R.id.data);

        city ="London";
        new AsyncTaskRunner().execute(city);

        database = new WeatherData(this);
    }

    public void getWeather(View view) {
        if (selected_city != null) {
            city = selected_city.getText().toString();
            new AsyncTaskRunner().execute(city);

        }
    }



    private  final class AsyncTaskRunner extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            Log.d(LOG_TAG, strings[0]);
            Uri uri = Uri.parse(BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, strings[0])
                    .appendQueryParameter(API_PARAM, API_KEY)
                    .build();

            URL requestURL;
            HttpURLConnection conn =null;
            InputStreamReader is =null;
            String JSONString = null;
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

                if (stringBuilder.length()==0){
                    return null;
                }

                 JSONString= stringBuilder.toString();



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


            return JSONString;
        }

        @Override
        protected void onPostExecute(String s) {
//            super.onPostExecute(s);

            try {
                if (s == null){
                    MainActivity.this.weather.setText("Data unavailable");
                    return;
                }
                JSONObject jsonObject = new JSONObject(s);



                JSONObject weather = jsonObject.getJSONObject("main");

                StringBuilder builder = new StringBuilder("\n"+city+" Weather \n");
                builder.append("     Temp: " + weather.getString("temp") +"\n");
                builder.append("     Pressure: " + weather.getString("pressure") +"\n");
                builder.append("     Humidity: " + weather.getString("humidity") +"\n");
                builder.append("     temp_max: " + weather.getString("temp_max") +"\n");

                if (builder != null && !displayedLondonWeather) {
                    londonWeather.setText(builder.toString());
                    displayedLondonWeather =true;
                    showData();
                }
                else if(builder != null && displayedLondonWeather){


                    weather = jsonObject.getJSONObject("sys");
                    builder.append("     Sun Rise : "+ weather.getString("sunrise")+"\n");
                    builder.append("     Sun Set : "+weather.getString("sunset")+"\n");

                    JSONArray weatherDetails = jsonObject.getJSONArray("weather");

                    for (int i = 0; i< weatherDetails.length(); i++ ){
                        builder.append("     Description : "+weatherDetails.getJSONObject(i).getString("description")+"\n\n");
                    }

                    MainActivity.this.weather.setText(builder.toString());
                    addWeather(builder.toString());
                    showData();
                }
                else {
                    MainActivity.this.weather.setText("Data unavailable");
                }


            } catch (JSONException e) {
                e.printStackTrace();

            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(),"Background thread is starting...", Toast.LENGTH_SHORT).show();
        }
    }


    public void addWeather(String weather) {
        SQLiteDatabase db=database.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(WEATHER, weather);
        values.put(DATE, String.valueOf(java.time.LocalDate.now()));
        values.put(TIME, String.valueOf(java.time.LocalTime.now()));


        db.insertOrThrow(TABLE_NAME, null, values);
        showData();
    }

    private void showData(){
        Cursor cursor = getWeather();
        StringBuilder builder = getWeatherString(cursor);

        data.setText(builder.toString());
    }

    private StringBuilder getWeatherString(Cursor cursor) {

        StringBuilder builder= new StringBuilder();
        while (cursor.moveToNext()){
            String id=cursor.getString(0);
            String weather=cursor.getString(1);
            String date= cursor.getString(2);
            String time= cursor.getString(3);


            builder.append(id).append(": ");
            builder.append(weather).append(": ");
            builder.append(date).append(": ");
            builder.append(time).append(": ");

            builder.append("\n");


        }
        cursor.close();

        return builder;
    }



    private Cursor getWeather() {
        SQLiteDatabase db=database.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME, FROM, null, null,
                null, null,ORDER_BY);
        return cursor;
    }


}


