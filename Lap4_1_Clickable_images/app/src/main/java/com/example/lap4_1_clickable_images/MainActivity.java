package com.example.lap4_1_clickable_images;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ImageView dountImgView = null;
    ImageView iceCreamImgView;
    ImageView freImgView;
    FloatingActionButton cartfloatingActionButton = null;
    String mOrderMessage ;
    public static final String EXTRA_MESSAGE =  "com.example.android.droidcafe.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dountImgView = findViewById(R.id.imgDount);
        dountImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(getString(R.string.donut_order_message));
            }
        });
        iceCreamImgView = findViewById(R.id.imgIcecream);
        iceCreamImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(getString(R.string.ice_cream_order_message));
            }
        });
        freImgView = findViewById(R.id.imgFroyo);
        freImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast(getString(R.string.froyo_order_message));

            }
        });

        cartfloatingActionButton = findViewById(R.id.fab);
        cartfloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OderActivity.class);
                if(mOrderMessage != null){
                    intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                }
                startActivity(intent);
            }
        });

    }

    public  void showToast(String message){
        mOrderMessage = message;
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}