package com.example.tut3_task3_challenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE = 1;

    private TextView itemName;
    private TextView itemQty;

    private EditText search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.cart_empty).setVisibility(View.VISIBLE);
        search=findViewById(R.id.editText_searchStore);
    }

    public void launchShopActivity(View view) {
        Intent intent = new Intent(this, ShopActivity.class);
        Log.d(LOG_TAG,"Launching Shop Activity...");
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            if (resultCode==RESULT_OK){
                String result= data.getStringExtra(ShopActivity.REPLY);
                addToCart(result);
            }
        }
    }

    public void addToCart(String itemCode){
        findViewById(R.id.cart_empty).setVisibility(View.INVISIBLE);

        String item = "cart_item"+itemCode;
        String qty="cart_item"+itemCode+"_qty";

        int itemId = getResources().getIdentifier(item, "id", getPackageName());
        int itemQtyId = getResources().getIdentifier(qty, "id", getPackageName());


        itemName=findViewById(itemId);
        itemQty=findViewById(itemQtyId);
        Log.d(LOG_TAG,"item and qty TextViews found");

        itemName.setVisibility(View.VISIBLE);
        itemQty.setVisibility(View.VISIBLE);

        int currentQty=Integer.parseInt(itemQty.getText().toString());
        itemQty.setText(String.valueOf(currentQty+1));
        Log.d(LOG_TAG,"Qty updated");


//
//        Log.d(LOG_TAG,String.valueOf(R.id.cart_item1_qty));
//        Log.d(LOG_TAG,String.valueOf("svgdkdgs"));
//        Log.d(LOG_TAG,String.valueOf(itemQtyId));
    }

    public void clearCart(View view) {
        for (int i=0;i<10;i++){

            String item = "cart_item"+(i+1);
            String qty="cart_item"+(i+1)+"_qty";

            int itemId = getResources().getIdentifier(item, "id", getPackageName());
            int itemQtyId = getResources().getIdentifier(qty, "id", getPackageName());

            itemName=findViewById(itemId);
            itemQty=findViewById(itemQtyId);
            itemQty.setText("0");

            itemName.setVisibility(View.INVISIBLE);
            itemQty.setVisibility(View.INVISIBLE);


        }

        findViewById(R.id.cart_empty).setVisibility(View.VISIBLE);

    }

    public void searchStore(View view) {
        String loc= search.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q="+loc);
        Intent intent=new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d(LOG_TAG, "Can't handle ImplicitIntent");
        }
    }
}