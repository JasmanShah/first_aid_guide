package com.example.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
                Toast.makeText(listview_text.this, MainActivity.Global.items[position], Toast.LENGTH_SHORT).show();
                String text = String.format(MainActivity.Global.items2[position]);
                showMessage (MainActivity.Global.items[position], Html.fromHtml(text));
            }
        });
    }

    public void showMessage(String title, Spanned body) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(body);
        builder.show();
    }
}
