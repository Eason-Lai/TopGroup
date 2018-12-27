package com.example.liyixun.TopGroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Fragment_spend extends Fragment{

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.account_spend, container, false);
        init(view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }

    private void init(View view) {
        r2 =(RelativeLayout) view.findViewById(R.id.r2);
        r2.setBackgroundColor(0xffFFC0CB);
        //取消“X”按钮
        btn_cancle_spend =(Button) view.findViewById(R.id.btn_cancel_spend);
        //提交“√”按钮
        btn_submit_spend =(Button) view.findViewById(R.id.btn_submit_spend);

        //支出类型图片
        iv_type_spend =(ImageView) view.findViewById(R.id.iv_type_spend);
        //支出类型
        tv_type_spend =(TextView) view.findViewById(R.id.tv_type_spend);
        //添加支出金额
        et_type_spend =(EditText) view.findViewById(R.id.et_type_spend);

        iv_other_spend =(ImageView) view.findViewById(R.id.iv_other_spend);       //其他支出
        iv_food_spend =(ImageView) view.findViewById(R.id.iv_food);               //餐饮支出
        iv_traffic_spend =(ImageView) view.findViewById(R.id.iv_traffic);         //交通支出
        iv_drug_spend =(ImageView) view.findViewById(R.id.iv_drug);               //药品支出
        iv_fruit_spend =(ImageView) view.findViewById(R.id.iv_fruit);             //水果支出
        iv_snacks_spend =(ImageView) view.findViewById(R.id.iv_snacks);           //零食支出
        iv_tel_spend =(ImageView) view.findViewById(R.id.iv_telephone);           //话费支出
    }
}
