package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    DrawView drawview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button draw = (Button) findViewById(R.id.draw);
        Button animate = (Button) findViewById(R.id.animate);
        Button car = (Button) findViewById(R.id.car);
        Button forward = (Button) findViewById(R.id.forward);
        Button backward = (Button) findViewById(R.id.backward);

        final ImageView image_car = (ImageView) findViewById(R.id.image_car);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawview = (DrawView) findViewById(R.id.drawview);
                drawview.setVisibility(View.VISIBLE);
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_car.setVisibility(View.VISIBLE);
            }
        });

        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_car.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in));
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawview.animate().translationXBy(-300f).setDuration(500);
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawview.animate().translationXBy(300f).setDuration(500);
            }
        });

    }
}
