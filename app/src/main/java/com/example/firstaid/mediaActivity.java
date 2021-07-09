package com.example.firstaid;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class mediaActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);

        TextView titleView = (TextView) findViewById(R.id.vTitle);
        TextView bodyView = (TextView) findViewById(R.id.vText);
        titleView.setText(listview_item.Global.title);
        bodyView.setText(listview_item.Global.video);

        VideoView videoView = (VideoView) findViewById(R.id.vVideo);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.burn);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        //videoView.start();
    }
}
