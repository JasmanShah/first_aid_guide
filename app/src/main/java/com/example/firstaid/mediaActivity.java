package com.example.firstaid;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class mediaActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = listview_item.Global.video;
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        TextView titleView = findViewById(R.id.vTitle);
        TextView bodyView = findViewById(R.id.vText);
        titleView.setText(listview_item.Global.title);
        bodyView.setText(listview_item.Global.body);
//
//        VideoView videoView = (VideoView) findViewById(R.id.videoView);
//        MediaController mediaController= new MediaController(this);
//        mediaController.setAnchorView(videoView);
//
//        Resources res = getResources();
//        int videoId = res.getIdentifier(listview_item.Global.video, "raw", getPackageName());
//        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+ videoId);
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(uri);
//        videoView.requestFocus();
//        videoView.start();
    }
}
