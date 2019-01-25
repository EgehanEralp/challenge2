package com.example.egehaneralp.challenge2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv=findViewById(R.id.tv);

        Thread t=new Thread(){
            @Override
            public void run(){
                while(!isInterrupted()){

                    try {
                        Thread.sleep(1000);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                tv.setText(String.valueOf(count));
                                if(count==15){

                                    finish();
                                    moveTaskToBack(true);
                                    Intent intent = new Intent(Intent.ACTION_DELETE);
                                    intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
                                    startActivity(intent);
                                }
                            }
                        });


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        };
        t.start();


    }
}
