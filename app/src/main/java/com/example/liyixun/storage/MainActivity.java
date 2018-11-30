package com.example.liyixun.storage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.*;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Toolbar tb;
    private List<Gallery> galleryList = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_calendar:
                    //mTextMessage.setText(R.string.title_calendar);
                    return true;
                case R.id.navigation_account:
                    //mTextMessage.setText(R.string.title_account);
                    return true;
                case R.id.navigation_storage:
                    replaceFragment(new Fragment_storage());
                    return true;
                case R.id.navigation_me:
                    //mTextMessage.setText(R.string.title_me);
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this,"03de14ff4bda451ee3108a1070c21129");

        setContentView(R.layout.activity_main);
        //replaceFragment(new Fragment_storage());

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
       /* loadGallery();
        GalleryAdapter adapter = new GalleryAdapter(MainActivity.this,R.layout.gallery_item,galleryList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/

    }

    private void loadGallery() {
        for (int i=1; i<=50; i++) {
            Gallery p = new Gallery("测试"+i,R.drawable.ic_storage);
            galleryList.add(p);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_layout,fragment);
        transaction.commit();
    }

}


