package com.example.allinoneapppractise.practice_handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.allinoneapppractise.R;

public class HandlerMainActivity extends AppCompatActivity {

    private Handler mHandler;
    private ProgressBar mProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_main);
        mHandler = new Handler();
        mProgressBar = findViewById(R.id.progressBar);
        Button mStartButton = findViewById(R.id.buttonStart);

        mStartButton.setOnClickListener(v -> {
            startProgress();
        });
    }

    private void startProgress() {
//      New thread to perform background operation
        new Thread(() -> {
            for (int i = 0; i <= 30; i++) {
                final int currentProgressCount = i;
                try {
                    Thread.sleep(500);
                    //mProgressBar.setProgress(currentProgressCount);
                    Log.i(" TAG", "Main Thread name is :" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Update the value background thread to UI thread
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.i(" TAG", "Thread Inside the handler name is :" + Thread.currentThread().getName());
                        mProgressBar.setProgress(currentProgressCount);
                    }
                }, 100);
            }
        }).start();
    }
}