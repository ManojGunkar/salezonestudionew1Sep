package com.salesfunnel.app.module.more.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.salesfunnel.Beans.Notification;
import com.salesfunnel.CustomAdapter.NotificationAdapter;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 19/06/2018 AD.
 */

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView notiRecycler;
    private ArrayList<Notification> notiArr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        init();
        initToolbar();
    }

    private void init(){
        notiArr = new ArrayList<Notification>();
        notiRecycler = (RecyclerView) findViewById(R.id.notiRecycler);
        populateArr();
    }

    private void populateArr(){
        Notification noti1 = new Notification("Reminder","Follow-up with Paras due in 15 mins", "Yesterday at 3:15 PM" , "1");
        Notification noti2 = new Notification("Reminder","Follow-up with Lovish due in 15 mins", "Yesterday at 3:15 PM" , "2");
        Notification noti3 = new Notification("Reminder","Follow-up with Bharat due in 15 mins", "Yesterday at 3:15 PM" , "3");
        notiArr.add(noti1);notiArr.add(noti2);notiArr.add(noti3);

        LinearLayoutManager mngr = new LinearLayoutManager(NotificationActivity.this , LinearLayoutManager.VERTICAL , false);
        notiRecycler.setLayoutManager(mngr);
        NotificationAdapter adapter = new NotificationAdapter(NotificationActivity.this , notiArr);
        notiRecycler.setAdapter(adapter);
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("NotificationActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
