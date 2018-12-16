package com.way.rapid.myapplication;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        Bean bean = (Bean) getItem(position);
        LayoutView layoutView = new LayoutView();
        View view;
        if(convertView == null){
            view =LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            layoutView.titleView =  view.findViewById(R.id.title);
            layoutView.priceView =  view.findViewById(R.id.price);
            layoutView.imageView =  view.findViewById(R.id.img);
            view.setTag(layoutView);
        }else {
            view = convertView;
            layoutView = (LayoutView) view.getTag();
        }
        layoutView.titleView.setText(bean.getTitle());
        layoutView.priceView.setText(bean.getPrice());
        layoutView.imageView.setImageResource(bean.getImg());
        return view;
    }
    class LayoutView{
        private TextView titleView;
        private TextView priceView;
        private ImageView imageView;
    }
}
