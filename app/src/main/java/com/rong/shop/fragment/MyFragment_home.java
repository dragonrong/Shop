package com.rong.shop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.rong.shop.DetailActivity;
import com.rong.shop.DetailActivity1;
import com.rong.shop.R;
import com.rong.shop.adapter.HomeRecyclerViewAdapter;
import com.rong.shop.bean.CardViewDates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class MyFragment_home extends BaseFragment implements BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener{
    //GridView
   /* private GridView gridview;
    private List<Map<String,Object>> listitem;
    private SimpleAdapter gAdapter;
    private int[] imgIds;*/

    //slider
    private SliderLayout mDemoSlider;

    //RecyclerView
    private RecyclerView mRecyclerView;
    private HomeRecyclerViewAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_home, container, false);

       /* //GridView
        gridview = (GridView)view.findViewById(R.id.gridview);

        listitem= new ArrayList<>();
        imgIds = new int[]{
                R.drawable.fg_home_gridview_1, R.drawable.fg_home_gridview_2,
                R.drawable.fg_home_gridview_3, R.drawable.fg_home_gridview_4,
                R.drawable.fg_home_gridview_5, R.drawable.fg_home_gridview_6,
                R.drawable.fg_home_gridview_7, R.drawable.fg_home_gridview_8,
        };
        for (int i = 0; i < imgIds.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("image", imgIds[i]);
            listitem.add(showitem);
        }

        gAdapter = new SimpleAdapter(this.getActivity(), listitem, R.layout.fg_home_gridview_item,
                new String[] { "image" }, new int[]{R.id.gridview_image});
        gridview.setAdapter(gAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getActivity(), DetailActivity.class);
                startActivity(i);
            }
        });
*/


        //slider
        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("新品",R.drawable.fg_home_1);
        file_maps.put("国货",R.drawable.fg_home_2);
        file_maps.put("大牌拼单",R.drawable.fg_home_3);
        file_maps.put("女装", R.drawable.fg_home_4);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this.getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Intent i=new Intent(getActivity(), DetailActivity.class);
                    startActivity(i);
                }
            });
            mDemoSlider.addSlider(textSliderView);
        }
        initRecyclerView(view);
        return view;
    }

    //RecyclerView
    private void initRecyclerView(View view){
        mRecyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);

        List<CardViewDates> Datas = new ArrayList<>(15);
        CardViewDates cardViewDates =new CardViewDates("热门活动",R.drawable.fg_home_cardview_big_1,R.drawable.fg_home_cardview_small_1,R.drawable.fg_home_cardview_small_2);
        Datas.add(cardViewDates);
        CardViewDates cardViewDates1 =new CardViewDates("有利可图",R.drawable.fg_home_cardview_big_2,R.drawable.fg_home_cardview_small_4,R.drawable.fg_home_cardview_small_3);
        Datas.add(cardViewDates1);
        CardViewDates cardViewDates2 =new CardViewDates("品牌街",R.drawable.fg_home_cardview_big_1,R.drawable.fg_home_cardview_small_5,R.drawable.fg_home_cardview_small_6);
        Datas.add(cardViewDates2);
        CardViewDates cardViewDates3 =new CardViewDates("金融街",R.drawable.fg_home_cardview_big_2,R.drawable.fg_home_cardview_small_8,R.drawable.fg_home_cardview_small_7);
        Datas.add(cardViewDates3);
        CardViewDates cardViewDates4 =new CardViewDates("超值购",R.drawable.fg_home_cardview_big_1,R.drawable.fg_home_cardview_small_1,R.drawable.fg_home_cardview_small_2);
        Datas.add(cardViewDates4);

        mAdapter=new HomeRecyclerViewAdapter(Datas);
        mAdapter.setOnCardViewClickListener(new HomeRecyclerViewAdapter.OnCardViewClickListener() {
            @Override
            public void onItemClick() {
                Intent i=new Intent(getActivity(), DetailActivity1.class);
                startActivity(i);
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        /*mRecyclerView.addItemDecoration(new CardViewtemDecortion());*/

    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}