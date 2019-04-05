package com.salesfunnel.CustomAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.salesfunnel.app.module.detailstab.AppointTabFragment;
import com.salesfunnel.app.module.detailstab.BasicInfoTabFragment;
import com.salesfunnel.app.module.detailstab.LogTabFragment;
import com.salesfunnel.app.module.detailstab.TaskTabFragment;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class DetailPagerAdapter extends FragmentPagerAdapter {

    public DetailPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch(position){
            case 0:
                fragment = new BasicInfoTabFragment();
                break;
            case 1:
                fragment = new TaskTabFragment();
                break;
            case 2:
                fragment = new AppointTabFragment();
                break;
            case 3:
                fragment = new LogTabFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch(position){
            case 0:
                title = "BASIC INFO";
                break;
          /*  case 1:
                title = "ACTIVITIES";
                break;
            case 2:
                title = "NOTES";
                break;*/
            case 1:
                title = "Tasks";
                break;
            case 2:
                title = "Appointments";
                break;
            case 3:
                title = "Call logs";
                break;

        }
        return title;
    }
}