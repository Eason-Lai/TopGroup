package com.example.liyixun.TopGroup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Fragment_account extends Fragment {

    private LinearLayout ll_RG;
    private RelativeLayout rl;
    private Button btn_income;
    private Button btn_spend;
    private TextView tv_income;
    private TextView tv_spend;
    private MainActivity activity;
    private Fragment_income fragment_income;
    private Fragment_spend fragment_spend;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_account, container, false);
        init(view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化主界面

    }

    private void init(View view) {
        //设置背景颜色
        rl =(RelativeLayout) view.findViewById(R.id.rl);
        rl.setBackgroundColor(0xffFFC0CB);
        ll_RG =(LinearLayout) view.findViewById(R.id.ll_RG);
        //收入按钮
        btn_income =(Button) view.findViewById(R.id.btn_income);
        //支出按钮
        btn_spend =(Button)view.findViewById(R.id.btn_spend);
        //显示收入
        tv_income =(TextView) view.findViewById(R.id.tv_income);
        //显示支出
        tv_spend =(TextView) view.findViewById(R.id.tv_spend);

        //进入收入界面
        btn_income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_income();
            }
        });
        //进入支出界面
        btn_spend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_spend();
            }
        });


    }

    private void activity_spend() {
        fragment_spend = new Fragment_spend();
        activity.replaceFragment(fragment_spend);
    }

    private void activity_income() {
        fragment_income = new Fragment_income();
        activity.replaceFragment(fragment_income);
    }


}
