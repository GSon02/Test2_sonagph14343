package com.example.test2_sonagph14343.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.test2_sonagph14343.Fragment.DanhSachFragment;
import com.example.test2_sonagph14343.Fragment.ThemGhiChuFragment;

public class PageTabAdapter extends FragmentStatePagerAdapter {
    public PageTabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DanhSachFragment();
            case 1:
                return new ThemGhiChuFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Hiển Thị";
            case 1:
                return "Thêm Ghi Chú";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
