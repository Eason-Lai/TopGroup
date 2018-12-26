package com.example.liyixun.TopGroup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.*;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Toolbar tb;
    private List<Gallery> galleryList = new ArrayList<>();
    private Fragment_storage fragment_storage;
    private String groupid;
    private User muser;
    private Group mgroup;

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
                    fragment_storage = new Fragment_storage();
                    replaceFragment(fragment_storage);
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

        init();


    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_layout,fragment);
        transaction.commit();
    }

    public static void actionStart(Context context, String id){
         Intent intent = new Intent(context,MainActivity.class);
         intent.putExtra("groupid",id);
         context.startActivity(intent);
    }


    private void init(){
        groupid = getIntent().getStringExtra("groupid");
        update_data();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Toast.makeText(MainActivity.this,groupid,Toast.LENGTH_LONG).show();
    }

    private void update_data() {
        muser = BmobUser.getCurrentUser(User.class);
        BmobQuery<Group> bmobQuery = new BmobQuery<Group>();
        bmobQuery.getObject(groupid, new QueryListener<Group>() {
            @Override
            public void done(Group group, BmobException e) {
                if (e==null){
                    mgroup = group;
                } else {
                    Log.e("MainActivity",e.getMessage());
                }
            }
        });
    }

    public Group getMGroup(){
        return mgroup;
    }

    public User getMuser() {
        return muser;
    }
}


