package com.rong.shop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.rong.shop.DetailActivity;
import com.rong.shop.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/13.
 */
public class MyFragment_category extends  BaseFragment  {
    private String [] names=new String[] {"食品保健","服饰鞋包","家电数码","母婴玩具","运动健康","珠宝钟表","个护美妆","家居生活"};
    private String[] discribtion=new String[]{"食品礼券/中外名酒","时尚女装/潮流男装","生活电器/数码配件","奶粉/营养品","户外装备/户外鞋服","钟表/饰品","身体护理/面部护理","家纺/生活用品"};
    private int [] icons =new int[]{
            R.drawable.fg_category_food,R.drawable.fg_category_clothes,
            R.drawable.fg_category_jiadian,R.drawable.fg_category_baby,
            R.drawable.fg_category_sport,R.drawable.fg_category_diamond,
            R.drawable.fg_category_huazhung,R.drawable.fg_category_jiajv
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_category,container,false);

        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", icons[i]);
            showitem.put("name", names[i]);
            showitem.put("says", discribtion[i]);
            listitem.add(showitem);
        }

        SimpleAdapter myAdapter = new SimpleAdapter(getActivity(), listitem, R.layout.fg_category_listview,
                new String[]{"touxiang", "name", "says"}, new int[]{R.id.imgtou, R.id.name, R.id.says});
        ListView listView = (ListView) view.findViewById(R.id.categoryListView);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getActivity(), DetailActivity.class);
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
