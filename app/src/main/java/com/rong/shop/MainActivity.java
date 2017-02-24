package com.rong.shop;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.rong.shop.fragment.MyFragment_buy;
import com.rong.shop.fragment.MyFragment_category;
import com.rong.shop.fragment.MyFragment_home;
import com.rong.shop.fragment.MyFragment_user;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private FragmentManager fm;

    private MyFragment_home fg1;
    private MyFragment_category fg2;
    private MyFragment_buy fg3;
    private MyFragment_user fg4;

    private long mPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.guide_home_nm, "首页").setActiveColorResource(R.color.main_red))
                .addItem(new BottomNavigationItem(R.drawable.guide_tfaccount_nm, "分类").setActiveColorResource(R.color.main_red))
                .addItem(new BottomNavigationItem(R.drawable.guide_cart_nm, "购物车").setActiveColorResource(R.color.main_red))
                .addItem(new BottomNavigationItem(R.drawable.guide_account_nm, "我").setActiveColorResource(R.color.main_red))
                .setFirstSelectedPosition(0)
                .initialise();

        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }


    /** * 设置默认的 */
    private void setDefaultFragment() {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        fg1=new MyFragment_home();
        transaction.replace(R.id.ly_content, fg1);
        transaction.commit();
    }

    public void onTabSelected(int position) {

        fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (fg1 == null) {
                    fg1=new MyFragment_home();
                }
                transaction.replace(R.id.ly_content, fg1);
                break;
            case 1:
                if (fg2 == null) {
                    fg2=new MyFragment_category();
                }
                transaction.replace(R.id.ly_content, fg2);
                break;
            case 2:
                if (fg3 == null) {
                    fg3=new MyFragment_buy();
                }
                transaction.replace(R.id.ly_content, fg3);
                break;
            case 3:
                if (fg4 == null) {
                    fg4=new MyFragment_user();
                }
                transaction.replace(R.id.ly_content, fg4);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }



    public void onBackPressed() {
        long mNowTime = System.currentTimeMillis();//获取第一次按键时间
        if((mNowTime - mPressedTime) > 2000){//比较两次按键时间差
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        }
        else{//退出程序
            this.finish();
            System.exit(0);
        }
    }


}