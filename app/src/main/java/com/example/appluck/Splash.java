package com.example.appluck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mProgress=(ProgressBar) findViewById(R.id.splash_screen_progress_bar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
                finish();
            }

            private void startApp() {
                Intent intent=new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
            }

            private void doWork() {
                for (int progress=0; progress <100; progress+=10){
                    try {
                        Thread.sleep(1000);
                        mProgress.setProgress(progress);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread mythread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        mythread.start();
    }
}
