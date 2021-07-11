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
        Global.type = "null";
        if (v.getId() == R.id.venom) {
            Global.items = new String[]{
                    "Snake",
                    "Spider/Venom"
            };
            Global.items2 = new String[]{
                    getString(R.string.venom_snake_text),
                    getString(R.string.venom_spider_scorpion_text),
            };
            Global.media = new String[]{
                    "nH8o-bgwo_g",
                    "wdDi7KNXUNw"
            };
        }
        else if (v.getId() == R.id.poison) {
            Global.items = new String[]{
                    "Chemical Poisoning",
                    "Food Poisoning"
            };
            Global.items2 = new String[]{
                    getString(R.string.poison_chemical_text),
                    getString(R.string.poison_food_text),
            };
            Global.media = new String[]{
                    "Zo0VK1tJHAM",
                    "E-WfUmNE9BM"
            };
        }
        else if (v.getId() == R.id.skin) {
            Global.items = new String[]{
                    "First/Second Degree Skin Burn",
                    "Skin Rash"
            };
            Global.items2 = new String[]{
                    getString(R.string.skin_burn_text),
                    getString(R.string.skin_rash_text),
            };
            Global.media = new String[]{
                    "ZNWjfe-84Ig",
                    "f9_v0Kani28"
            };
        }
        else if (v.getId() == R.id.firstaidkit) {
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
        else if (v.getId() == R.id.emergencycall) {
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

    public void onPersonalInfoClick(View v) {
        Intent i = new Intent(MainActivity.this, personal_info.class);
        startActivity(i);
    }
}