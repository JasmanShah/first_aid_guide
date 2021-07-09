package com.example.firstaid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


public class listview_item extends Activity {
    public static class Global {
        public static String title;
        public static String body;
        public static String video;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.listview_item);
            ListView listView = (ListView) findViewById(R.id.listView);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.Global.items);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener((parent, view, position, id) -> {
                if(MainActivity.Global.type.equals("simple_image")) {
                    String text = String.format(MainActivity.Global.items2[position]);
                    showImageLayout (MainActivity.Global.items[position], Html.fromHtml(text), MainActivity.Global.media[position]);
                } else {
                    Global.title = String.format(MainActivity.Global.items[position]);
                    Global.body = String.format(MainActivity.Global.items2[position]);
                    Global.video = String.format(MainActivity.Global.media[position]);
                    Intent i = new Intent(listview_item.this, mediaActivity.class);
                    startActivity(i);
                }
            });
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

//    public void showVideoLayout(String title, Spanned body, String video) {
//
//        final Dialog dialog = new Dialog(listview_item.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.video_layout);
//        TextView titleView = (TextView) dialog.findViewById(R.id.mediaTitle);
//        TextView bodyView = (TextView) dialog.findViewById(R.id.mediaBody);
//        titleView.setText(title);
//        bodyView.setText(body);
//
//        VideoView videoView =(VideoView) dialog.findViewById(R.id.mediaVideo);
//
//        MediaController mediaController= new MediaController(this);
//        mediaController.setAnchorView(videoView);
//
//        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.burn);
//
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(uri);
//        videoView.requestFocus();
//        videoView.start();
//        dialog.show();
//
//    }


}
