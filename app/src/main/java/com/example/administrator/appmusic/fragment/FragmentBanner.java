package com.example.administrator.appmusic.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.appmusic.R;
import com.example.administrator.appmusic.adapter.BannerAdapter;
import com.example.administrator.appmusic.model.QuangCao;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentBanner extends Fragment{
    int currentItem;
    Runnable runnable;
    Handler handler;
    ArrayList<QuangCao>banner;
    View view;
    ViewPager viewPager;
    BannerAdapter bannerAdapter;
    String url="https://ducnguyenptit1909.000webhostapp.com/Server/songbanner.php";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_banner,container,false);
        anhXa();
        getData();
        return view;
    }

    private void anhXa() {
        banner=new ArrayList<>();
        viewPager=view.findViewById(R.id.viewpaper);
    }

    private void getData() {
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        Log.d("kiemtra",jsonObject.getString("Hinhanh"));
                        banner.add(new QuangCao(jsonObject.getInt("Id"),jsonObject.getString("Hinhanh"),jsonObject.getString("Noidung"),jsonObject.getInt("Idbaihat"),jsonObject.getString("TenBaiHat"),jsonObject.getString("HinhBaiHat")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                bannerAdapter=new BannerAdapter(getActivity(),banner);
                viewPager.setAdapter(bannerAdapter);
                Log.d("kiemtra11",viewPager.getCurrentItem()+"");
                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("chandoi",viewPager.getCurrentItem()+"");
                        currentItem=viewPager.getCurrentItem();
                        currentItem++;
                        if(currentItem>=viewPager.getAdapter().getCount()){
                            currentItem=0;
                        }
                        viewPager.setCurrentItem(currentItem);
                        handler.postDelayed(this,3000);
                    }
                },3000);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Lỗi", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
