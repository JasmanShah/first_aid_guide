package com.example.firstaidguide.ui.gallery;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.firstaidguide.R;
import com.example.firstaidguide.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {;

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        // Configure Video
        MediaController mc= new MediaController(getActivity()); // Media player ctrl
        VideoView video = (VideoView) view.findViewById(R.id.testVideo); //VideoView id
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.ajr; //video source
        video.setVideoURI(Uri.parse(path));
        video.setMediaController(mc);
//        video.start();
//        video.requestFocus();

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}