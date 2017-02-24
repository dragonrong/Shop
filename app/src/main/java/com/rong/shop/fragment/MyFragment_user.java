package com.rong.shop.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rong.shop.R;
import com.rong.shop.user.LoginActivity;

/**
 * Created by Administrator on 2016/8/13.
 */
public class MyFragment_user extends BaseFragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_user,container,false);
        final Context mContext=getActivity();

        Button uButton=(Button)view.findViewById(R.id.userButton);
        uButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                mContext.startActivity(intent);
            }
        });
        TextView textView1= (TextView) view.findViewById(R.id.grtv1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"亲，您目前还没有订单哦",Toast.LENGTH_SHORT).show();
            }
        });
        TextView textView2= (TextView) view.findViewById(R.id.grtv2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"您的钱包空空如也",Toast.LENGTH_SHORT).show();
            }
        });
        TextView textView3= (TextView) view.findViewById(R.id.grtv3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"暂时没有可用优惠券",Toast.LENGTH_SHORT).show();
            }
        });
        TextView textView4= (TextView) view.findViewById(R.id.grtv4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"快去收藏宝贝吧",Toast.LENGTH_SHORT).show();
            }
        });
        TextView textView5= (TextView) view.findViewById(R.id.grtv5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"您的反馈就是对我们最大的支持",Toast.LENGTH_SHORT).show();
            }
        });
        TextView textView6= (TextView) view.findViewById(R.id.grtv6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"登录后才可用设置哦",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }
}
