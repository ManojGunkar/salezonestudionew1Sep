package com.salesfunnel.CustomAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.salesfunnel.app.module.contacts.ContactFragmentTab;
import com.salesfunnel.app.module.followsup.fragments.FollowUpLeadFragment;
import com.salesfunnel.app.module.leads.LeadFragmentTab;
import com.salesfunnel.app.module.more.MoreTabFragment;
import com.salesfunnel.app.module.stats.StatsTabFragment;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class MainTabsAdapter extends FragmentPagerAdapter {

    public MainTabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new LeadFragmentTab();
                break;
            case 1:
                fragment = new ContactFragmentTab();
                break;
            case 2:
                fragment = new FollowUpLeadFragment();
                break;
            case 3:
                fragment = new StatsTabFragment();
                break;
            case 4:
                fragment = new MoreTabFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "Chat";
                break;
            case 1:
                title = "Home";
                break;
            case 2:
                title = "Explore";
                break;
            case 3:
                title = "Profile";
                break;
        }
        return title;
    }
}