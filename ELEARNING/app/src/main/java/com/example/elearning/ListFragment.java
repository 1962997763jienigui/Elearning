package com.example.elearning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private FragmentManager fragmentManager;
    private ArrayList<Data> courses;
    private ListView list_course;

    public ListFragment(FragmentManager fragmentManager, ArrayList<Data> courses){
        this.fragmentManager = fragmentManager;
        this.courses = courses;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_course_list, container, false);
        list_course = (ListView) view.findViewById(R.id.list_course);
        MyAdapter myAdapter = new MyAdapter(courses, getActivity());
        list_course.setAdapter(myAdapter);
        list_course.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        course_content_fragment contentFragment = new course_content_fragment();
        Bundle bd = new Bundle();
        bd.putString("content", courses.get(i).getCourse_content());
        contentFragment.setArguments(bd);

        //获取Activity的控件
        TextView item_content = (TextView) getActivity().findViewById(R.id.item_content);
        item_content.setText(courses.get(i).getCourse_content());
        //加上Fragment替换动画
        //fragmentTransaction.setCustomAnimations(an, R.anim.fragment_slide_left_exit);
        fragmentTransaction.replace(R.id.ly_content, contentFragment);
        //调用addToBackStack将Fragment添加到栈中
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
