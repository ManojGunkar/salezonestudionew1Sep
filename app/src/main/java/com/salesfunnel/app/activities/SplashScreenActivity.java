package com.salesfunnel.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.salesfunnel.R;
import com.salesfunnel.app.module.login.LogInActivity;
import com.salesfunnel.app.utils.UserCredentials;


/**
 * Created by Manoj Kumar on 18-11-2018.
 */

public class SplashScreenActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            Intent intent=null;
            if (UserCredentials.getCredentials(SplashScreenActivity.this).isUserLogged()){
                intent=new Intent(SplashScreenActivity.this , HomeActivity.class);
            }else {
                intent=new Intent(SplashScreenActivity.this , LogInActivity.class);
            }
            startActivity(intent);
            finish();

        }, 3000);

    }
}
