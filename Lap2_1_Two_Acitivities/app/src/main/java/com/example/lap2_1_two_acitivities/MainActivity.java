package com.example.lap2_1_two_acitivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    private TextView edtReplyHead;
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
                    }

                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMessage = findViewById(R.id.txtSend);

        edtReplyHead = findViewById(R.id.text_header_reply);
        edtReply = findViewById(R.id.txt_message_reply);


        Intent  intentR = getIntent();
//        mActivityLauncher.launch(intentR);
        edtReply.setText(intentR.getStringExtra(SecondActivity.EXTRA_REPLY));

        Button btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "Btn clicked from Main! ");
                Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                String message = edtMessage.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
//                startActivity(intent);
                mActivityLauncher.launch(intent);
            }
        });



    }



}