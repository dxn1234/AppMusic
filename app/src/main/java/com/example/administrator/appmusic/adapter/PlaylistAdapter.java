package com.example.administrator.appmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.appmusic.R;
import com.example.administrator.appmusic.model.PlayList;

import java.util.ArrayList;

public class PlaylistAdapter extends BaseAdapter{
    Context context;
    int layout;
    ArrayList<PlayList>playListArrayList;

    public PlaylistAdapter(Context context, int layout, ArrayList<PlayList> playListArrayList) {
        this.context = context;
        this.layout = layout;
        this.playListArrayList = playListArrayList;
    }

    @Override
    public int getCount() {
        return playListArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(layout,null);
        TextView txttenplaylist;
        ImageView imgbackground,imgplaylist;
        txttenplaylist=convertView.findViewById(R.id.txt_tenplaylist);
        imgbackground=convertView.findViewById(R.id.img_backgroundplaylist);
        imgplaylist=convertView.findViewById(R.id.img_playlist);
        txttenplaylist.setText(playListArrayList.get(position).getTen());
        Glide.with(context).load(playListArrayList.get(position).getHinhicon()).into(imgplaylist);
        Glide.with(context).load(playListArrayList.get(position).getHinhnen()).into(imgbackground);
        return convertView;
    }
}
