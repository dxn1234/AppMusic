package com.example.administrator.appmusic.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.appmusic.R;
import com.example.administrator.appmusic.adapter.MainViewpaperAdapter;
import com.example.administrator.appmusic.fragment.FragmentTimKiem;
import com.example.administrator.appmusic.fragment.FragmentTrangChu;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        init();
    }

    private void init() {
        MainViewpaperAdapter mainViewpaperAdapter=new MainViewpaperAdapter(getSupportFragmentManager());
        mainViewpaperAdapter.addFragment(new FragmentTrangChu(),"Trang Chủ");
        mainViewpaperAdapter.addFragment(new FragmentTimKiem(),"Tìm Kiếm");
        viewPager.setAdapter(mainViewpaperAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);
    }

    private void anhXa() {
        tabLayout=findViewById(R.id.mytablayout);
        viewPager=findViewById(R.id.myviewpaper);
    }
}
