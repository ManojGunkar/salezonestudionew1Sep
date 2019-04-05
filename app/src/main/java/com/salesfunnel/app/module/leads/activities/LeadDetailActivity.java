package com.salesfunnel.app.module.leads.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.salesfunnel.CustomAdapter.DetailPagerAdapter;
import com.salesfunnel.R;
import com.salesfunnel.app.utils.DataSource;
import com.salesfunnel.app.utils.Utilities;

/**
 * Created by krishan on 23/06/2018 AD.
 */

public class LeadDetailActivity extends AppCompatActivity {

    public static TextView username, useremail, charText;
    public static ImageView callIcon, emailIcon;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DetailPagerAdapter viewPagerAdapter;
    private Spinner stageSpin;
    private Utilities utility;
    private DataSource dataSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaddetail);
        init();
    }

    private void init() {
        utility = new Utilities(LeadDetailActivity.this);
        dataSource = new DataSource(LeadDetailActivity.this);
        charText = findViewById((R.id.txt_char_name_details));
        username = findViewById(R.id.txt_user_name_details);
        useremail = findViewById(R.id.txt_user_email_details);
        stageSpin = findViewById(R.id.spin_lead_details);
        callIcon = findViewById(R.id.img_call_details);
        emailIcon = findViewById(R.id.img_email_details);
        viewPager = findViewById(R.id.viewpager_details);
        viewPagerAdapter = new DetailPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tab_details);
        tabLayout.setupWithViewPager(viewPager);
        populateData();

    }

    private void populateData() {
        String[] countries = getResources().getStringArray(R.array.stageArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row_stage, R.id.text, countries);
        stageSpin.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
