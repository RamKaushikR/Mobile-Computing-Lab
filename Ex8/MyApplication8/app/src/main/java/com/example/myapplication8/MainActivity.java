package com.example.myapplication8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save = (Button) findViewById(R.id.save);
        Button load = (Button) findViewById(R.id.load);
        final EditText writefile = (EditText) findViewById(R.id.writefile);
        final EditText writecontent = (EditText) findViewById(R.id.writecontent);
        EditText readfile = (EditText) findViewById(R.id.readfile);
        EditText readcontent = (EditText) findViewById(R.id.readcontent);
        final File[] externalFile = new File[1];

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            save.setEnabled(false);
            load.setEnabled(false);
            Toast.makeText(getApplicationContext(), "No external storage found", Toast.LENGTH_SHORT).show();
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                externalFile[0] = new File(Environment.getExternalStorageDirectory(), writefile.getText().toString());
                try {
                    FileOutputStream fos = new FileOutputStream(externalFile[0]);
                    Toast.makeText(getApplicationContext(), "File saved", Toast.LENGTH_SHORT).show();
                    fos.write(writecontent.getText().toString().getBytes());
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                    //Toast.makeText(getApplicationContext(), "Failed to save file", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
