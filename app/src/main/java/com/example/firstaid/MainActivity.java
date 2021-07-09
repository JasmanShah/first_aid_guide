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
        public static String[] items;
        public static String[] items2;
        public static String[] media;
        public static String type;
    }

    public void onListClick(View v) {
        if (v.getId() == R.id.venom) {
            Global.type = null;
            Global.items = new String[]{"Snake","Scorpion","Spider"};
        }

        if (v.getId() == R.id.poison) {
            Global.type = null;
            Global.items = new String[]{"Chemical","Food"};
        }

        if (v.getId() == R.id.skin) {
            Global.type = "null";
            Global.items = new String[]{"Burn","Rash"};
            Global.items2 = new String[]{"Burn","Rash"};
            Global.media = new String[]{"burn","burn"};
        }

        if (v.getId() == R.id.firstaidkit) {
            Global.type = "simple_image";
            Global.items = new String[]{
                    "Adhesive Tape",
                    "Alcohol Swab",
                    "Antibiotic Ointment",
                    "Bandage",
                    "Gauze",
                    "Glove",
                    "Plaster",
                    "Safety Pin",
                    "Scissors",
                    "Tweezers",
            };
            Global.items2 = new String[]{
                    getString(R.string.adhesive_tape),
                    getString(R.string.alcohol_swab),
                    getString(R.string.antibiotic_ointment),
                    getString(R.string.bandage),
                    getString(R.string.gauze),
                    getString(R.string.gloves),
                    getString(R.string.plaster),
                    getString(R.string.safety_pin),
                    getString(R.string.scissors),
                    getString(R.string.tweezers),
            };

            Global.media = new String[]{
                    "adhesive_tape",
                    "alcohol_swab",
                    "antibiotic_ointment",
                    "bandage",
                    "gauze",
                    "gloves",
                    "plaster",
                    "safety_pin",
                    "scissors",
                    "tweezers",
            };
        }

        if (v.getId() == R.id.emergencycall) {
            Global.type = "simple_image";
            Global.items = new String[]{"Perlis","Kedah"};
            Global.items2 = new String[]{
                    getString(R.string.perlis),
                    getString(R.string.kedah),
            };
            Global.media = new String[]{"perlis","kedah"};
        }

        Intent i = new Intent(MainActivity.this, listview_item.class);
        startActivity(i);
    }
}