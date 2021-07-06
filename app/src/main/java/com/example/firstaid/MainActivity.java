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
        public static String items[]; public static String items2[];
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
            Global.items2 = new String[]{
                    "<b>Polis:</b> 04-908 2222<br><b>Hospital:</b> 04-973 8000<br><b>Bomba:</b> 04-976 0544",//Perlis
                    "<b>Polis:</b> 04-774 7222<br><b>Hospital:</b> 04-730 8878<br><b>Bomba:</b> 04-733 3444",//Kedah
            };
            Intent i = new Intent(MainActivity.this,listview_text.class);
            startActivity(i);
        }
    }
}