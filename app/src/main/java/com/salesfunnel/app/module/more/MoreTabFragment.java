package com.salesfunnel.app.module.more;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salesfunnel.R;
import com.salesfunnel.app.module.more.activities.NotificationActivity;
import com.salesfunnel.app.utils.AppConstants;
import com.salesfunnel.app.utils.DataSource;
import com.salesfunnel.app.module.more.activities.SettingActivity;
import com.salesfunnel.app.module.more.activities.SupportActivity;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class MoreTabFragment extends Fragment {

    public MoreTabFragment(){}

    private LinearLayout supportLayout , settingsLayout , notiLayout;


    private TextView username , charText , useremail;
    private DataSource dataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        dataSource = new DataSource(getActivity());
        settingsLayout = (LinearLayout) view.findViewById(R.id.settingsLayout);
        supportLayout = (LinearLayout) view.findViewById(R.id.supportLayout);
        notiLayout = (LinearLayout) view.findViewById(R.id.notiLayout);
        username = (TextView) view.findViewById(R.id.username);
        charText = (TextView) view.findViewById(R.id.charText);
        useremail = (TextView) view.findViewById(R.id.useremail);

        useremail.setText(dataSource.getValue(AppConstants.EMAIL));
        username.setText(dataSource.getValue(AppConstants.FNAME) +" "+dataSource.getValue(AppConstants.LNAME));
        char one = username.getText().toString().trim().charAt(0);
        charText.setText(one+"");
    }

    @Override
    public void onResume() {
        super.onResume();
        notiLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noti = new Intent(getActivity() , NotificationActivity.class);
                startActivity(noti);
            }
        });
        settingsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent support = new Intent(getActivity() , SettingActivity.class);
                startActivity(support);
            }
        });
        supportLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent support = new Intent(getActivity() , SupportActivity.class);
                startActivity(support);
            }
        });
    }
}