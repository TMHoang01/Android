package com.example.lap4_1_clickable_images;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder);

        TextView txtMess = findViewById(R.id.mess);
        Intent intent = getIntent();
        txtMess.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
    }

}