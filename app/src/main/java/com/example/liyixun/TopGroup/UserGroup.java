package com.example.liyixun.TopGroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

import static cn.bmob.v3.b.From.e;

public class UserGroup extends AppCompatActivity {

    private User user;
    private EditText edt_new;
    private Button btn_new;
    private Spinner spn;
    private Button btn_select;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_usergroup);
        init();

        spn_update();

        click();
    }

    private void init(){
        Bmob.initialize(this,"03de14ff4bda451ee3108a1070c21129");
        user = BmobUser.getCurrentUser(User.class);
        //Toast.makeText(UserGroup.this,user.getNickname(),Toast.LENGTH_LONG).show();

        edt_new = (EditText) findViewById(R.id.ug_edt_new);
        btn_new = (Button) findViewById(R.id.ug_btn_new);
        spn = (Spinner) findViewById(R.id.spinner);
        btn_select = (Button) findViewById(R.id.ug_btn_select);
    }

    private void click(){
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //检验组名是否存在
                String name = edt_new.getText().toString();
                BmobQuery<Group> categoryBmobQuery = new BmobQuery<>();
                categoryBmobQuery.addWhereEqualTo("groupname", name);
                categoryBmobQuery.findObjects(new FindListener<Group>() {
                    @Override
                    public void done(final List<Group> object, BmobException e) {
                        if (e == null) {
                            if (object.size()==0){
                                //Group创建
                                Group group = new Group();
                                group.setGroupname(edt_new.getText().toString());
                                group.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        if (e==null){
                                            //用户表下添加该组
                                            user.addUnique("groupname",edt_new.getText().toString());
                                            user.update(user.getObjectId(),new UpdateListener() {
                                                @Override
                                                public void done(BmobException e) {
                                                    if(e==null){
                                                        Log.e("UG_user","update success");
                                                    }else{
                                                        Log.e("UG_user",e.getMessage());
                                                    }
                                                }
                                            });
                                            //group的跟新
                                            Group group2 = new Group();
                                            group2.add("admin",user.getObjectId());
                                            group2.add("member",user.getObjectId());
                                            group2.update(s,new UpdateListener() {
                                                @Override
                                                public void done(BmobException e) {
                                                    if(e==null){
                                                        Log.e("UG_group","update success");
                                                    }
                                                    else{
                                                        Log.e("UG_group_up",e.getMessage());
                                                    }
                                                }
                                            });
                                        } else{
                                            Log.e("UG_group_sa",e.getMessage());
                                        }
                                    }
                                });
                                spn_update();
                                Toast.makeText(UserGroup.this,"创建成功",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(UserGroup.this,"该组名已存在",Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Log.e("BMOB", e.toString());
                        }
                    }
                });
            }
        });

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void spn_update(){
        List<String> name = new ArrayList<String>();
        name = user.getGroupname();
        if (name!=null) {
            ArrayAdapter<String> adapter;
            adapter = new ArrayAdapter<String>(UserGroup.this, android.R.layout.simple_spinner_item,name);
            spn.setAdapter(adapter);
        }
    }
}
