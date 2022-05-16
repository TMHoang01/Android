package com.example.lap2_1_two_acitivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "hust.soict.4061.MESSAGE";
//    public static final int TEXT_REQUEST = 1;

    private EditText edtMessage ;
    private TextView edtReplyHead = null;
    private TextView edtReply;

    final private ActivityResultLauncher<Intent> mActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d(LOG_TAG, "Btn clicked from Second");


                    if(result.getResultCode() == RESULT_OK){
                        Intent intent = result.getData();
                        String strReply = intent.getStringExtra(SecondActivity.EXTRA_REPLY);
                        edtReply.setText(strReply);
                        edtReply.setVisibility(View.VISIBLE);
                        edtReplyHead.setVisibility(View.VISIBLE);
                    }
                }
            });



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(edtReplyHead.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_visible", true);
            String strContent =edtReply.getText().toString();
            outState.putString("reply_content", strContent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "on Create");
        setContentView(R.layout.activity_main);
        edtMessage = findViewById(R.id.txtSend);
        edtReplyHead = findViewById(R.id.text_header_reply);
        edtReply = findViewById(R.id.txt_message_reply);
        
//        edtReply.getText();





        Intent  intentR = getIntent();
//        mActivityLauncher.launch(intentR);
        edtReply.setText(intentR.getStringExtra(SecondActivity.EXTRA_REPLY));


        //        restore the state
        if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if(isVisible){
                edtReplyHead.setVisibility(View.VISIBLE);
                edtReply.setVisibility(View.VISIBLE);
                String content = savedInstanceState.getString("reply_content");
                edtReply.setText(content);
            }

        }


//        send Activity second
        Button btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(LOG_TAG, "Btn clicked from Main! ");
                Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                String message = edtMessage.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
//                startActivity(intent);
                mActivityLauncher.launch(intent);
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