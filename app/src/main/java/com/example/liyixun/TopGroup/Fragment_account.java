package com.example.liyixun.TopGroup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Fragment_account extends AppCompatActivity {

    private LinearLayout ll_RG;
    private RelativeLayout rl;
    private Button btn_income;
    private Button btn_spend;
    private TextView tv_income;
    private TextView tv_spend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化主界面
        init();
    }

    private void init() {
        //设置背景颜色
        rl =(RelativeLayout)findViewById(R.id.rl);
        rl.setBackgroundColor(0xffFFC0CB);
        ll_RG =(LinearLayout) findViewById(R.id.ll_RG);
        //收入按钮
        btn_income =(Button) findViewById(R.id.btn_income);
        //支出按钮
        btn_spend =(Button)findViewById(R.id.btn_spend);
        //显示收入
        tv_income =(TextView) findViewById(R.id.tv_income);
        //显示支出
        tv_spend =(TextView) findViewById(R.id.tv_spend);

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
        Intent intent=new Intent(this,Activity_spend.class);
        startActivity(intent);
    }

    private void activity_income() {
        Intent intent=new Intent(this,Activity_income.class);
        startActivity(intent);
    }


}
