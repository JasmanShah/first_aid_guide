package com.example.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class listview_item extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(MainActivity.Global.type.equals("list")){
            setContentView(R.layout.listview_item);

            ListView listView = (ListView) findViewById(R.id.listView);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.Global.items);
            listView.setAdapter(adapter);


            listView.setOnItemClickListener((parent, view, position, id) -> {
                //Toast.makeText(listview_text.this, MainActivity.Global.items[position], Toast.LENGTH_SHORT).show();
                String text = String.format(MainActivity.Global.items2[position]);
                showImageLayout (MainActivity.Global.items[position], Html.fromHtml(text), MainActivity.Global.image[position]);
            });
        }

        if(MainActivity.Global.type.equals("firstaidkit")){
            setContentView(R.layout.first_aid_kit_page);
            ImageView image = new ImageView(this);
            image = (ImageView) findViewById(R.id.gauze);
            setContentView(image);
        }
    }

    public void showImageLayout(String title, Spanned body, String image) {

        String variableValue = image;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.image_layout, null);
        dialogBuilder.setView(dialogView);

        ImageView imageview= (ImageView) dialogView.findViewById(R.id.imageView);
        TextView titleView = (TextView) dialogView.findViewById(R.id.imageViewTitle);
        TextView bodyView = (TextView) dialogView.findViewById(R.id.imageViewText);

        imageview.setImageResource(getResources().getIdentifier(variableValue, "drawable", getPackageName()));
        titleView.setText(title);
        bodyView.setText(body);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}
