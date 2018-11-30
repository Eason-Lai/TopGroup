package com.example.liyixun.storage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;


public class Fragment_storage extends Fragment {
    private List<Gallery> galleryList = new ArrayList<>();
    public Fragment_storage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storage,container,false);
        loadGallery();
        GalleryAdapter adapter = new GalleryAdapter(this.getContext(),R.layout.gallery_item,galleryList);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this.getContext(),"03de14ff4bda451ee3108a1070c21129");
    }

    private void loadGallery() {
        for (int i=1; i<=50; i++) {
            Gallery p = new Gallery("测试"+i,R.drawable.ic_storage);
            galleryList.add(p);
        }
    }

}
