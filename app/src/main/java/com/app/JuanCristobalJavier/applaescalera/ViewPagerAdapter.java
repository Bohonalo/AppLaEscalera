package com.app.JuanCristobalJavier.applaescalera;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentController;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan on 04/03/2018.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    private List<Fragment> list = new ArrayList<>();
    private List<String> titulos = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment mifragment, String titulo){
        list.add(mifragment);
        titulos.add(titulo);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
    }

}
