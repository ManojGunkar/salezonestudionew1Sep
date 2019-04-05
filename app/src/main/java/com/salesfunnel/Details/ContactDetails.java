package com.salesfunnel.Details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.salesfunnel.CreatePack.AddLead;
import com.salesfunnel.CustomAdapter.ContactPagerAdapter;
import com.salesfunnel.R;

/**
 * Created by krishan on 23/06/2018 AD.
 */

public class ContactDetails extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ContactPagerAdapter viewPagerAdapter;

    private FloatingActionButton addLeadBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactdetail);
        init();
    }

    private void init(){
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addLeadBtn = (FloatingActionButton) findViewById(R.id.addLeadBtn);
        viewPagerAdapter = new ContactPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addLeadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addLead = new Intent(ContactDetails.this , AddLead.class);
                startActivity(addLead);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
