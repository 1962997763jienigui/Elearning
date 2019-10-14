package com.example.elearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Data> course_list;
    private Context mContext;

    public MyAdapter(List<Data> course_list, Context mContext){
        this.course_list = course_list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return course_list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.text_item_title = (TextView) view.findViewById(R.id.item_content);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.text_item_title.setText(course_list.get(position).getCourse_title());
        return view;
    }

    private class ViewHolder{
        TextView text_item_title;
    }
}
