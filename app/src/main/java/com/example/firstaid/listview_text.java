package com.example.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

public class listview_text extends Activity {
//    String items [] = {"LAN2","MAN","WAN"};
//    String items2 []=new String[]{"LOCAL AREA NETWORK","METROPOLITAN AREA NETWORK","WIDE AREA NETWORK"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_text);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.Global.items);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(listview_text.this, MainActivity.Global.items[position], Toast.LENGTH_SHORT).show();
                String text = String.format(MainActivity.Global.items2[position]);
                showMessage (MainActivity.Global.items[position], Html.fromHtml(text), MainActivity.Global.image[position]);
            }
        });
    }

    public void showMessage(String title, Spanned body, String image) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(body);
//        builder.show();

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
