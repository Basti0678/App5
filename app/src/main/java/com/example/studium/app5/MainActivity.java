package com.example.studium.app5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.content.SharedPreferences;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private TextView textview1;
    private ToggleButton toggleButton1;
    private CheckBox checkBox1;
    final static public String PREFS_NAME = "MyPrefs";
    //private Boolean toggle1Value = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview1 = (TextView) findViewById(R.id.textview1);
        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton1.setOnClickListener(this);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox1.setOnClickListener(this);

        SharedPreferences settings = getSharedPreferences("MyPrefs", 0);

       // Boolean on = settings.getBoolean("toggle1", false);
       // Toast.makeText(getApplicationContext(), on.toString(), Toast.LENGTH_LONG).show();
       // if (on) {
       //     toggleButton1.setChecked(true);
       // }
        toggleButton1.setChecked(settings.getBoolean("toggle1", false));
        checkBox1.setChecked(settings.getBoolean("check1", false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.toggleButton1) {
            if (toggleButton1.isChecked()) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("toggle1", true);
                editor.commit();

            } else {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("toggle1", false);
                editor.commit();
            }
        }
        if (v.getId() == R.id.checkBox1) {
            if (checkBox1.isChecked()) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("check1", true);
                editor.commit();
            } else {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("check1", false);
                editor.commit();
            }
        }
    }
}