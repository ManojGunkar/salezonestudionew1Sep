package com.salesfunnel.app.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.salesfunnel.CreatePack.AddLead;
import com.salesfunnel.CustomAdapter.MainTabsAdapter;
import com.salesfunnel.R;
import com.salesfunnel.apiconnector.model.CrmUserApi;
import com.salesfunnel.app.module.leads.activities.AddLeadActivity;
import com.salesfunnel.app.module.login.LogInActivity;
import com.salesfunnel.app.utils.UserCredentials;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static ViewPager viewPager;
    boolean doubleBackToExitPressedOnce = false;
    private TabLayout tabLayout;
    private MainTabsAdapter viewPagerAdapter;
    private FloatingActionButton addLeadBtn;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chat");
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new MainTabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        createTabIcons();
        viewPager.setCurrentItem(0);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.menubtn, getTheme());
        toggle.setHomeAsUpIndicator(drawable);
        toggle.setToolbarNavigationClickListener(v -> {
            if (drawer.isDrawerVisible(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        init();
        View headerLayout = navigationView.getHeaderView(0);
        LinearLayout sideProfileLayout = headerLayout.findViewById(R.id.sideProfileLayout);
        TextView username = headerLayout.findViewById(R.id.username);
        TextView useremail = headerLayout.findViewById(R.id.useremail);
        TextView charText = headerLayout.findViewById(R.id.charText);

        CrmUserApi crmUserApi = UserCredentials.getCredentials(this).getUserDetails();

        username.setText(crmUserApi.getFirstName() + " " + crmUserApi.getLastName());
        useremail.setText(crmUserApi.getEmail());
        char one = username.getText().toString().trim().charAt(0);
        charText.setText(one + "");
        sideProfileLayout.setOnClickListener(view -> {
            Intent sideProfile = new Intent(HomeActivity.this, ProfileDetailActivity.class);
            startActivity(sideProfile);
        });
    }

    private void init() {
        addLeadBtn = findViewById(R.id.addLeadBtn);
    }


    private void createTabIcons() {
        LinearLayout tabOne = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        ImageView imageOne = tabOne.findViewById(R.id.tabImage);
        TextView text = tabOne.findViewById(R.id.tabText);
        text.setText("Leads");
        text.setTextColor(getResources().getColor(R.color.tab_select));
        imageOne.setImageResource(R.drawable.leads);
        imageOne.setColorFilter(ContextCompat.getColor(HomeActivity.this, R.color.tab_select));
        tabLayout.getTabAt(0).setCustomView(tabOne);

        LinearLayout tab2 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        ImageView image2 = tab2.findViewById(R.id.tabImage);
        TextView text2 = tab2.findViewById(R.id.tabText);
        text2.setText("Contacts");
        image2.setImageResource(R.drawable.contacts);
        tabLayout.getTabAt(1).setCustomView(tab2);

        LinearLayout tab3 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        TextView text3 = tab3.findViewById(R.id.tabText);
        text3.setText("FollowUps");
        ImageView image3 = tab3.findViewById(R.id.tabImage);
        image3.setImageResource(R.drawable.protect);

        tabLayout.getTabAt(2).setCustomView(tab3);

        LinearLayout tab4 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        TextView text4 = tab4.findViewById(R.id.tabText);
        text4.setText("Stats");
        ImageView image4 = tab4.findViewById(R.id.tabImage);
        image4.setImageResource(R.drawable.deals);
        tabLayout.getTabAt(3).setCustomView(tab4);

        LinearLayout tab5 = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.custom_row, null);
        TextView text5 = tab5.findViewById(R.id.tabText);
        text5.setText("More");
        ImageView image5 = tab5.findViewById(R.id.tabImage);
        image5.setImageResource(R.drawable.morebtn);
        tabLayout.getTabAt(4).setCustomView(tab5);

    }

    @Override
    protected void onResume() {
        super.onResume();

        addLeadBtn.setOnClickListener(view -> {
            Intent addLead = new Intent(HomeActivity.this, AddLeadActivity.class);
            startActivity(addLead);
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView image = view.findViewById(R.id.tabImage);
                TextView text = view.findViewById(R.id.tabText);
                text.setTextColor(getResources().getColor(R.color.tab_select));
                image.setColorFilter(ContextCompat.getColor(HomeActivity.this, R.color.tab_select));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView image = view.findViewById(R.id.tabImage);
                TextView text = view.findViewById(R.id.tabText);
                text.setTextColor(getResources().getColor(R.color.tab_unselect));
                image.setColorFilter(ContextCompat.getColor(HomeActivity.this, R.color.tab_unselect));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        getSupportActionBar().setTitle("Leads");
                        break;
                    case 1:
                        getSupportActionBar().setTitle("Contacts");
                        break;
                    case 2:
                        getSupportActionBar().setTitle("FollowUps");
                        break;
                    case 3:
                        getSupportActionBar().setTitle("Statistics");
                        break;
                    case 4:
                        getSupportActionBar().setTitle("More");
                        break;
                }
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
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
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

            case R.id.nav_dashboard:
                Intent home = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(home);
                break;

            case R.id.add_lead:
                Intent lead = new Intent(HomeActivity.this, AddLead.class);
                startActivity(lead);
                break;

            case R.id.nav_logout:
                UserCredentials.getCredentials(this).storeLogin(null);
                Intent login = new Intent(HomeActivity.this, LogInActivity.class);
                startActivity(login);
                finish();
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
