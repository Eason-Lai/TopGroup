package com.example.liyixun.storage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.bmob.v3.b.I;

public class GalleryAdapter extends ArrayAdapter<Gallery>{
    private int resourceId;
    public GalleryAdapter(Context context, int textViewResourceId, List<Gallery> objects) {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        Gallery gallery = getItem(position);
        View view;
        if ( converView == null ) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }
        else {
            view = converView;
        }
        ImageView gallery_image = (ImageView) view.findViewById(R.id.gallery_image);
        TextView gallery_title = (TextView) view.findViewById(R.id.gallery_title);
        gallery_image.setImageResource(gallery.getImageId());
        gallery_title.setText(gallery.getTitle());
        return view;
    }
    class ViewHolder {
        ImageView gallery_image;
        TextView gallery_title;
    }
}
