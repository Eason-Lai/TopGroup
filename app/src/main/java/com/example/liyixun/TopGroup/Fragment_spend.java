package com.example.liyixun.TopGroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity_spend extends AppCompatActivity{

    private RelativeLayout r2;
    private Button btn_cancle_spend;
    private Button btn_submit_spend;
    private ImageView iv_type_spend;
    private TextView tv_type_spend;
    private EditText et_type_spend;
    private ImageView iv_other_spend;
    private ImageView iv_food_spend;
    private ImageView iv_traffic_spend;
    private ImageView iv_drug_spend;
    private ImageView iv_fruit_spend;
    private ImageView iv_snacks_spend;
    private ImageView iv_tel_spend;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_spend);

        Intent intent=getIntent();

        //初始化支出界面
        init();
    }

    private void init() {
        r2 =(RelativeLayout)findViewById(R.id.r2);
        r2.setBackgroundColor(0xffFFC0CB);
        //取消“X”按钮
        btn_cancle_spend =(Button) findViewById(R.id.btn_cancel_spend);
        //提交“√”按钮
        btn_submit_spend =(Button) findViewById(R.id.btn_submit_spend);

        //支出类型图片
        iv_type_spend =(ImageView) findViewById(R.id.iv_type_spend);
        //支出类型
        tv_type_spend =(TextView) findViewById(R.id.tv_type_spend);
        //添加支出金额
        et_type_spend =(EditText) findViewById(R.id.et_type_spend);

        iv_other_spend =(ImageView) findViewById(R.id.iv_other_spend);       //其他支出
        iv_food_spend =(ImageView) findViewById(R.id.iv_food);               //餐饮支出
        iv_traffic_spend =(ImageView) findViewById(R.id.iv_traffic);         //交通支出
        iv_drug_spend =(ImageView) findViewById(R.id.iv_drug);               //药品支出
        iv_fruit_spend =(ImageView) findViewById(R.id.iv_fruit);             //水果支出
        iv_snacks_spend =(ImageView) findViewById(R.id.iv_snacks);           //零食支出
        iv_tel_spend =(ImageView) findViewById(R.id.iv_telephone);           //话费支出
    }
}
