package com.example.fornt_end_development;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class login extends AppCompatActivity {

    ViewPager viewPager;
    //add images from drawable to array
    int images[] = {R.drawable.f1, R.drawable.f2, R.drawable.f3};

    int currentPageCunter = 0;
    Button home;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup=findViewById(R.id.textView9);
        home=findViewById(R.id.button2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(login.this,signup.class);
                startActivity(i);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(login.this,order.class);
                startActivity(i);
            }
        });











        //find view by id
        viewPager = findViewById(R.id.viewpager);
        //add adapter
        viewPager.setAdapter(new SliderAdapter(images, login.this));

        //auto change image
        final Handler handler = new Handler();
        final Runnable update  = new Runnable() {
            @Override
            public void run() {
                if (currentPageCunter == images.length){
                    currentPageCunter = 0 ;

                }

                viewPager.setCurrentItem(currentPageCunter++,true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },2500,2500);




    }

}