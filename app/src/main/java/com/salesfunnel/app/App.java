package com.salesfunnel.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.salesfunnel.BuildConfig;
import com.salesfunnel.R;
import com.salesfunnel.app.utils.DefaultActivityLifecycleCallbacks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Manoj Kumar on 17-11-2018.
 */
public class App extends Application {

    private ActivityLifecycleCallbacks mLifecycleCallbacks = new DefaultActivityLifecycleCallbacks() {
        private Activity mActivity;

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onActivityStarted(Activity activity) {
            mActivity = activity;

            Boolean terminate = false;
            int terminateReason = R.string.app_expire;
            if( isExpired() ) {
                terminateReason = R.string.app_expire;
                terminate = true;
            }

            if ( terminate ) {
                Toast.makeText(App.this, activity.getResources().getString(terminateReason), Toast.LENGTH_LONG).show();
                activity.finishAndRemoveTask();

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                }, 2000);
            }
        }

        @Override
        public void onActivityStopped(Activity activity) {
            if ( mActivity == activity ) {
                mActivity = null;
                Glide.get(App.this).clearMemory();
            }
        }

        private boolean isExpired(){
            if( BuildConfig.EXPIRY_DATE != null ) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    Date expiryDate = sdf.parse(BuildConfig.EXPIRY_DATE);
                    Date today = new Date();
                    return today.after(expiryDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(mLifecycleCallbacks);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(App.this).clearMemory();
    }
}
