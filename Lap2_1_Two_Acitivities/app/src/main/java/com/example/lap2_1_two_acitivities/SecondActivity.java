package com.example.lap2_1_two_acitivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "hust.soict.4061.REPLY";
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private EditText edtReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "on Create");
//  receive message from MainActivity
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView txtView = findViewById(R.id.txt_message);
        txtView.setText(message);
        Button btnReply = findViewById(R.id.btn_reply);
        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtReply = findViewById(R.id.txtReply);
                String reply = edtReply.getText().toString();
                Intent replyInent = new Intent(SecondActivity.this, MainActivity.class);
                replyInent.putExtra(EXTRA_REPLY,reply);
                setResult(RESULT_OK, replyInent);
                Log.d(LOG_TAG, "on End SecondActivity");
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"on Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"on Destroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"on Stop");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"on Pause");

    }



}