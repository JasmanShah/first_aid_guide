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
        public static String items[], items2 [];
    }

    public void onListClick(View v) {
        if (v.getId() == R.id.venom) {
            Global.items = new String[]{"Snake","Scorpion","Spider"};
            Global.items2 = new String[]{"Snake bite","Scorpion sting","Spider bite"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }

        if (v.getId() == R.id.poison) {
            Global.items = new String[]{"Chemical","Food"};
            Global.items2 = new String[]{"Chemical Poisoning","Food Poisoning"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }

        if (v.getId() == R.id.skin) {
            Global.items = new String[]{"Burn","Rash"};
            Global.items2 = new String[]{"1st degree burn","Poison Ivy"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }

        if (v.getId() == R.id.firstaidkit) {
            Global.items = new String[]{"Chemical","Food"};
            Global.items2 = new String[]{"Chemical Poisoning","Food Poisoning"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }

        if (v.getId() == R.id.emergencycall) {
            Global.items = new String[]{"Perlis","Kedah"};
            Global.items2 = new String[]{"Perlis emergency number","Not in list yet"};
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }
    }
}