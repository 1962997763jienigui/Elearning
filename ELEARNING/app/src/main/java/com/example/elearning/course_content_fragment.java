package com.example.elearning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class course_content_fragment extends Fragment {
    course_content_fragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_item, container, false);
        TextView textView = (TextView) view.findViewById(R.id.item_content);
        //getArgument获取传递过来的Bundle对象
        textView.setText(getArguments().getString("content"));
        return view;
    }
}
