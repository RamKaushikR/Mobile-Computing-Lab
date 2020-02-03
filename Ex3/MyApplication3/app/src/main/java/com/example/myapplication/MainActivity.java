package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    DrawView drawview;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button draw = (Button) findViewById(R.id.draw);
        final Button zoom = (Button) findViewById(R.id.zoom);
        Button car = (Button) findViewById(R.id.car);
        final Button forward = (Button) findViewById(R.id.forward);
        final Button backward = (Button) findViewById(R.id.backward);
        Button animation = (Button) findViewById(R.id.animation);

        final ImageView image_car = (ImageView) findViewById(R.id.image_car);
        final ImageView animate = (ImageView) findViewById(R.id.animate);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawview = (DrawView) findViewById(R.id.drawview);
                drawview.setVisibility(View.VISIBLE);
                forward.setVisibility(View.VISIBLE);
                backward.setVisibility(View.VISIBLE);
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

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_car.setVisibility(View.VISIBLE);
                zoom.setVisibility(View.VISIBLE);
            }
        });

        zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_car.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in));
            }
        });

        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate.setVisibility(View.VISIBLE);

                animate.setImageResource(R.drawable.animate);
                AnimationDrawable animation_drawable = (AnimationDrawable) animate.getDrawable();
                animation_drawable.start();

            }
        });

    }
}
