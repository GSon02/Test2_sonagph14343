package com.example.test2_sonagph14343;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgAvatar;
    private ProgressBar pgLoading;
    private TextView tvLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        pgLoading = (ProgressBar) findViewById(R.id.pgLoading);
        tvLoading = (TextView) findViewById(R.id.tvLoading);
        CountDownTimer countDownTimer = new CountDownTimer(3000,100) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}