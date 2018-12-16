package com.way.rapid.myapplication;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FirstAdapter extends ArrayAdapter {

    private int resourceId;
    public FirstAdapter(@NonNull Context context,
                        int resource,
                        @NonNull List objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        com.way.rapid.myapplication.Bean bean = (com.way.rapid.myapplication.Bean) getItem(position);
        LayoutView layoutView = new LayoutView();
        View view;
        if(convertView == null){
            view =LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            layoutView.nameView = (TextView) view.findViewById(R.id.name);
            layoutView.contentView = (TextView) view.findViewById(R.id.content);
            layoutView.imageView = (ImageView) view.findViewById(R.id.img);
            view.setTag(layoutView);
        }else {
            view = convertView;
            layoutView = (LayoutView) view.getTag();
        }
        layoutView.nameView.setText(bean.getName());
        layoutView.contentView.setText(bean.getContent());
        layoutView.imageView.setImageResource(bean.getImg());
        return view;
    }
    class LayoutView{
        private TextView nameView;
        private TextView contentView;
        private ImageView imageView;
    }
}
