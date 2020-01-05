package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.Serializable;

public class Details extends AppCompatActivity implements Serializable {

    String name, address, age, phone, gender, marital, addiction, dob, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Details details = (Details)intent.getSerializableExtra("Details");
        /*
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, details.time, Toast.LENGTH_LONG);
        toast.show();*/

        TextView t1 = (TextView) findViewById(R.id.name);
        t1.setText(details.name);

        TextView t2 = (TextView) findViewById(R.id.address);
        t2.setText(details.address);

        TextView t3 = (TextView) findViewById(R.id.age);
        t3.setText(details.age);

        TextView t4 = (TextView) findViewById(R.id.dob);
        t4.setText(details.dob);

        TextView t5 = (TextView) findViewById(R.id.gender);
        t5.setText(details.gender);

        TextView t6 = (TextView) findViewById(R.id.married);
        t6.setText(details.marital);

        TextView t7 = (TextView) findViewById(R.id.phone);
        t7.setText(details.phone);

        TextView t8 = (TextView) findViewById(R.id.time);
        t8.setText(details.time);

        TextView t9 = (TextView) findViewById(R.id.addiction);
        t9.setText(details.addiction);
    }
}
