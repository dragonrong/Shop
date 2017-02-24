package com.rong.shop.user;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/29.
 */
public class Tool {

    public static void showMessage(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
