package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Details details = new Details();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.marital_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.submitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Details Submitted", Toast.LENGTH_LONG);
                toast.show();*/
                EditText e1 = (EditText) findViewById(R.id.editText2);
                details.name = e1.getText().toString();

                EditText e2 = (EditText) findViewById((R.id.editText3));
                details.address = e2.getText().toString();

                EditText e3 = (EditText) findViewById((R.id.editText4));
                details.age = e3.getText().toString();

                DatePicker d = (DatePicker) findViewById((R.id.simpleDatePicker));
                details.dob = d;

                RadioGroup r = (RadioGroup) findViewById(R.id.RadioGroup);
                Integer rid = (Integer)r.getCheckedRadioButtonId();

                RadioButton r1 = (RadioButton) findViewById(rid);
                details.gender = r1.getText().toString();

                final Spinner s = (Spinner) findViewById(R.id.spinner);
                s.setOnItemSelectedListener(new OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String text = s.getSelectedItem().toString();
                        details.marital = text;


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        details.marital = "Null";

                    }
                });

                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, details.marital, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
