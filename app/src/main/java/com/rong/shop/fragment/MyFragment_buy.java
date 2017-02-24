package com.rong.shop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rong.shop.MapActivity;
import com.rong.shop.R;

/**
 * Created by Administrator on 2016/8/13.
 */
public class MyFragment_buy extends BaseFragment {

    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_buy,container,false);

        button= (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), MapActivity.class);
                startActivity(i);
            }
        });


        return view;
    }


    @Override
    protected int setLayoutResouceId() {
        return 0;
    }
}
