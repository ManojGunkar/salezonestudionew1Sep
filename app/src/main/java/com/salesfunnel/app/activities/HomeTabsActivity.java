package com.salesfunnel.app.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.salesfunnel.CustomAdapter.MainTabsAdapter;
import com.salesfunnel.R;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class HomeTabsActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;
    private TabLayout tabLayout;
    public static ViewPager viewPager;
    private MainTabsAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintabs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chat");
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new MainTabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        createTabIcons();
        viewPager.setCurrentItem(0);
    }

    private void createTabIcons() {
        LinearLayout tabOne = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        ImageView imageOne = (ImageView) tabOne.findViewById(R.id.tabImage);
        TextView text = (TextView) tabOne.findViewById(R.id.tabText);
        text.setText("Leads");
        text.setTextColor(getResources().getColor(R.color.tab_select));
        imageOne.setImageResource(R.drawable.leads);
        imageOne.setColorFilter(ContextCompat.getColor(HomeTabsActivity.this , R.color.tab_select));
        tabLayout.getTabAt(0).setCustomView(tabOne);

        LinearLayout tab2 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        ImageView image2 = (ImageView) tab2.findViewById(R.id.tabImage);
        TextView text2 = (TextView) tab2.findViewById(R.id.tabText);
        text2.setText("Contacts");
        image2.setImageResource(R.drawable.contacts);
        tabLayout.getTabAt(1).setCustomView(tab2);

        LinearLayout tab3 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        TextView text3 = (TextView) tab3.findViewById(R.id.tabText);
        text3.setText("Accounts");
        ImageView image3 = (ImageView) tab3.findViewById(R.id.tabImage);
        image3.setImageResource(R.drawable.protect);

        tabLayout.getTabAt(2).setCustomView(tab3);

        LinearLayout tab4 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        TextView text4 = (TextView) tab4.findViewById(R.id.tabText);
        text4.setText("Deals");
        ImageView image4 = (ImageView) tab4.findViewById(R.id.tabImage);
        image4.setImageResource(R.drawable.deals);
        tabLayout.getTabAt(3).setCustomView(tab4);

        LinearLayout tab5 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        TextView text5 = (TextView) tab5.findViewById(R.id.tabText);
        text5.setText("More");
        ImageView image5 = (ImageView) tab5.findViewById(R.id.tabImage);
        image5.setImageResource(R.drawable.morebtn);
        tabLayout.getTabAt(4).setCustomView(tab5);

    }


    @Override
    protected void onResume() {
        super.onResume();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView image = (ImageView) view.findViewById(R.id.tabImage);
                TextView text = (TextView) view.findViewById(R.id.tabText);
                text.setTextColor(getResources().getColor(R.color.tab_select));
                image.setColorFilter(ContextCompat.getColor(HomeTabsActivity.this, R.color.tab_select));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView image = (ImageView) view.findViewById(R.id.tabImage);
                TextView text = (TextView) view.findViewById(R.id.tabText);
                text.setTextColor(getResources().getColor(R.color.tab_unselect));
                image.setColorFilter(ContextCompat.getColor(HomeTabsActivity.this, R.color.tab_unselect));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch(position){
                    case 0:
                        getSupportActionBar().setTitle("Leads");
                        break;
                    case 1:
                        getSupportActionBar().setTitle("My Contacts");
                        break;
                    case 2:
                        getSupportActionBar().setTitle("My Accounts");
                        break;
                    case 3:
                        getSupportActionBar().setTitle("Deals");
                        break;
                    case 4:
                        getSupportActionBar().setTitle("More");
                        break;
                }
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(viewPager.getWindowToken(), 0);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}

