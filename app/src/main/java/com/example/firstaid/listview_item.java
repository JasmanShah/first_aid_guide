package com.example.firstaid;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class listview_item extends AppCompatActivity {
    public static class Global {
        public static String title;
        public static Spanned body;
        public static String video;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.listview_item);
            ListView listView = findViewById(R.id.listView);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.Global.items);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
                if(MainActivity.Global.type.equals("simple_image")) {
                    String text = MainActivity.Global.items2[position];
                    showImageLayout (MainActivity.Global.items[position], Html.fromHtml(text), MainActivity.Global.media[position]);
                } else {
                    String text = MainActivity.Global.items2[position];
                    Global.title = MainActivity.Global.items[position];
                    Global.body = Html.fromHtml(text);
                    Global.video = MainActivity.Global.media[position];
                    Intent i = new Intent(listview_item.this, mediaActivity.class);
                    startActivity(i);
                }
            });
    }

    public void showImageLayout(String title, Spanned body, String image) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.image_popup_layout, null);
        dialogBuilder.setView(dialogView);

        ImageView imageview= dialogView.findViewById(R.id.imageView);
        TextView titleView = dialogView.findViewById(R.id.imageViewTitle);
        TextView bodyView = dialogView.findViewById(R.id.imageViewText);

        imageview.setImageResource(getResources().getIdentifier(image, "drawable", getPackageName()));
        titleView.setText(title);
        bodyView.setText(body);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }


}
