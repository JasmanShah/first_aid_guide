package com.example.firstaidguide.ui.skinburn;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.firstaidguide.R;
import com.example.firstaidguide.databinding.FragmentSkinBurnBinding;

public class SkinBurnFragment extends Fragment {;

//    private GalleryViewModel galleryViewModel;
    private FragmentSkinBurnBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skin_burn, container, false);
        // Configure Video
        MediaController mc= new MediaController(getActivity()); // Media player ctrl
        VideoView video = (VideoView) view.findViewById(R.id.testVideo); //VideoView id
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.ajr; //video source
        video.setVideoURI(Uri.parse(path));
        video.setMediaController(mc);
        mc.setAnchorView(video);
        video.requestFocus();

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}