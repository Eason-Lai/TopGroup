package com.example.liyixun.storage;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.b.I;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private List<Gallery> mGalleryList;

    static class  ViewHolder extends RecyclerView.ViewHolder {
        View galleryview;
        ImageView gallery_image;
        TextView gallery_title;

        public ViewHolder(View view) {
            super(view);
            galleryview = view;
            gallery_image = (ImageView) view.findViewById(R.id.gallery_image);
            gallery_title = (TextView) view.findViewById(R.id.gallery_title);
        }
    }

    public GalleryAdapter(List<Gallery> galleryList) {
        mGalleryList = galleryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        //点击
        holder.galleryview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position = holder.getAdapterPosition();
               Gallery gallery = mGalleryList.get(position);
               Toast.makeText(v.getContext(),"you clicked image" + gallery.getTitle(),Toast.LENGTH_LONG).show();
           }
        });

        //长按
        holder.galleryview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                Gallery gallery = mGalleryList.get(position);
                Toast.makeText(v.getContext(),"you longclicked image" + gallery.getTitle(),Toast.LENGTH_LONG).show();
                return true;
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Gallery gallery = mGalleryList.get(position);
        holder.gallery_image.setImageResource(gallery.getImageId());
        holder.gallery_title.setText(gallery.getTitle());
    }

    @Override
    public int getItemCount(){
        return mGalleryList.size();
    }
}

/*public class GalleryAdapter extends ArrayAdapter<Gallery>{
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
}*/


