package com.example.administrator.appmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.appmusic.R;
import com.example.administrator.appmusic.model.QuangCao;

import java.util.ArrayList;


public class BannerAdapter extends PagerAdapter{
    Context context;
    ArrayList<QuangCao>arrayListBannner;

    public BannerAdapter(Context context, ArrayList<QuangCao> arrayListBannner) {
        this.context = context;
        this.arrayListBannner = arrayListBannner;
    }

    @Override
    public int getCount() {
        return arrayListBannner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.dong_banner,null);
        ImageView imgbannerbackground=view.findViewById(R.id.img_bannerbackground);
        ImageView imgosngbanner=view.findViewById(R.id.img_banner);
        TextView txtTitle=view.findViewById(R.id.txt_titlebannerbaihat);
        TextView txtnoidung=view.findViewById(R.id.txt_noidung);
        Glide.with(context).load(arrayListBannner.get(position).getHinhbaihat()).into(imgosngbanner);
        Glide.with(context).load(arrayListBannner.get(position).getHinhanh()).into(imgbannerbackground);
        txtnoidung.setText(arrayListBannner.get(position).getNoidung());
        txtTitle.setText(arrayListBannner.get(position).getTenbaihat());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
