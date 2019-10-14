package com.example.elearning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BrowseFragment extends Fragment {

    private String content;

    public BrowseFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_browse,container,false);
        VideoView video_view = (VideoView) view.findViewById(R.id.video_view);
        video_view.setVideoPath("https://www.bilibili.com/video/av51931596?from=search&seid=15920434273557919435");
        video_view.requestFocus();
        video_view.start();

        return view;
    }
}
