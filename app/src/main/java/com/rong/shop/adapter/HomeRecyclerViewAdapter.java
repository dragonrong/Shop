package com.rong.shop.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rong.shop.R;
import com.rong.shop.bean.CardViewDates;

import java.util.List;

/**
 * Created by Administrator on 2017/2/11.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {
    private static int ViewType_L=0;
    private static int ViewType_R=1;

    private LayoutInflater mInflater;
    private List<CardViewDates> mDatas;

    public OnCardViewClickListener mListener;
    public void setOnCardViewClickListener(OnCardViewClickListener listener){
        this.mListener = listener;
    }


    public HomeRecyclerViewAdapter(List<CardViewDates> mdatas) {
        this.mDatas = mdatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        mInflater=LayoutInflater.from(viewGroup.getContext());
        if(type == ViewType_R){
            return  new ViewHolder(mInflater.inflate(R.layout.template_home_cardview2,viewGroup,false));
        }
        return new ViewHolder(mInflater.inflate(R.layout.template_home_cardview1,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        CardViewDates cardViewDates = mDatas.get(i);
        viewHolder.text_title.setText(cardViewDates.getName());
        viewHolder.imgview_big.setImageResource(cardViewDates.getImgBig());
        viewHolder.imgview_small_top.setImageResource(cardViewDates.getImgSmallTop());
        viewHolder.imgview_small_bottom.setImageResource(cardViewDates.getImgSmallBottom());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0) {
            return ViewType_L;
        }
        else return ViewType_R;
    }


     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView text_title;
        ImageView imgview_big;
        ImageView imgview_small_top;
        ImageView imgview_small_bottom;


        public ViewHolder(View itemView) {
            super(itemView);

            text_title= (TextView) itemView.findViewById(R.id.text_title);
            imgview_big= (ImageView) itemView.findViewById(R.id.imgview_big);
            imgview_small_top= (ImageView) itemView.findViewById(R.id.imgview_small_top);
            imgview_small_bottom= (ImageView) itemView.findViewById(R.id.imgview_small_bottom);

            imgview_big.setOnClickListener(this);
            imgview_small_top.setOnClickListener(this);
            imgview_small_bottom.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mListener !=null){
                mListener.onItemClick();
            }
        }

    }

    public  interface OnCardViewClickListener{
        void onItemClick();
    }
}
