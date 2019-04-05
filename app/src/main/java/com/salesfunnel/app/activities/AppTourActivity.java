package com.salesfunnel.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.salesfunnel.app.module.login.LogInActivity;
import com.salesfunnel.app.module.login.SignUpActivity;
import com.salesfunnel.R;
import com.salesfunnel.app.utils.DataSource;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class AppTourActivity extends AppCompatActivity {

    private CarouselView customCarouselView;
    int NUMBER_OF_PAGES = 3;
    private DataSource dataSource;
    private  Button logbtn , regbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apptour);
        dataSource = new DataSource(AppTourActivity.this);
        customCarouselView = (CarouselView) findViewById(R.id.carouselView);
        logbtn = (Button) findViewById(R.id.loginBtn);
        regbtn = (Button) findViewById(R.id.regBtn);
        customCarouselView.setPageCount(NUMBER_OF_PAGES);
        customCarouselView.setViewListener(viewListener);
    }

    @Override
    protected void onResume() {
        super.onResume();

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent login = new Intent(AppTourActivity.this , LogInActivity.class);
                startActivity(login);
                finish();
            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent login = new Intent(AppTourActivity.this , SignUpActivity.class);
                startActivity(login);
                finish();
            }
        });
    }

    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {
            View customView = getLayoutInflater().inflate(R.layout.helper_custom_view, null);
            ImageView image = (ImageView) customView.findViewById(R.id.tagImage);

            switch(position){
                case 0:
                    Glide.with(AppTourActivity.this).load(R.drawable.sales).into(image);
                    break;
                case 1:
                    Glide.with(AppTourActivity.this).load(R.drawable.sales2).into(image);
                    break;
                case 2:
                    Glide.with(AppTourActivity.this).load(R.drawable.salesconversion).into(image);
                    break;
            }

            return customView;
        }
    };
}

