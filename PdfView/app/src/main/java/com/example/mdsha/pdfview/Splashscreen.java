package com.example.mdsha.pdfview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Splashscreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private  int Progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        progressBar= findViewById(R.id.proBarid);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                statApp();
            }
        });
        thread.start();
    }

    private void statApp() {
        Intent intent = new Intent(Splashscreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void doWork(){
        for(Progress=20;Progress<=100;Progress=Progress+20){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(Progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
