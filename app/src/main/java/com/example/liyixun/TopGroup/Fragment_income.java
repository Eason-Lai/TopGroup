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

public class Fragment_income extends Fragment {

    private RelativeLayout r3;
    private Button btn_cancle_income;
    private Button btn_submit_income;
    private ImageView iv_type_income;
    private TextView tv_type_income;
    private EditText et_type_income;
    private ImageView iv_other_income;
    private ImageView iv_invest_income;
    private ImageView iv_refund_income;
    private ImageView iv_cash_income;
    private ImageView iv_redmoney_income;
    private ImageView iv_bonus_income;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.account_income, container, false);
        init(view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }

    private void init(View view) {
        r3 =(RelativeLayout) view.findViewById(R.id.r3);
        r3.setBackgroundColor(0xffFFC0CB);
        //取消“X”按钮
        btn_cancle_income =(Button) view.findViewById(R.id.btn_cancel_income);
        //提交“√”按钮
        btn_submit_income =(Button) view.findViewById(R.id.btn_submit_income);
        //收入类型图片
        iv_type_income =(ImageView) view.findViewById(R.id.iv_type_income);
        //收入类型
        tv_type_income =(TextView) view.findViewById(R.id.tv_type_income);
        //添加收入金额
        et_type_income =(EditText) view.findViewById(R.id.et_type_income);

        iv_other_income =(ImageView) view.findViewById(R.id.iv_other_income);     //其他收入
        iv_invest_income =(ImageView) view.findViewById(R.id.iv_invest);          //投资收入
        iv_refund_income =(ImageView) view.findViewById(R.id.iv_refund);          //退款收入
        iv_cash_income =(ImageView) view.findViewById(R.id.iv_cash);              //现金收入
        iv_redmoney_income =(ImageView) view.findViewById(R.id.iv_redmoney);      //红包收入
        iv_bonus_income =(ImageView) view.findViewById(R.id.iv_bonus);            //奖金收入
    }
}
