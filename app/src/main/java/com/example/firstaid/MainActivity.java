package com.example.firstaid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class Global {
        public static String items[];
    }

    public void onListClick(View v) {
        if (v.getId() == R.id.venom) {
            Global.items = new String[]{"Snake","Scorpion","Spider"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }

        if (v.getId() == R.id.poison) {
            Global.items = new String[]{"Chemical","Food"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }

        if (v.getId() == R.id.skin) {
            Global.items = new String[]{"Burn","Rash"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }

        if (v.getId() == R.id.firstaidkit) {
            Global.items = new String[]{"Chemical","Food"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }

        if (v.getId() == R.id.emergencycall) {
            Global.items = new String[]{"Perlis","Kedah"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }
    }
}