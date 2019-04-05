package com.salesfunnel.app.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by krishan on 02/07/2018 AD.
 */

public class Utilities {
    private Context ctx;
    private ProgressDialog dialog;
    public static PendingIntent contentIntent = null;

    public Utilities(Context ctx){
        this.ctx = ctx;
    }

    public static void callThisNumber(String number , Context ctx){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
        ctx.startActivity(intent);
    }

    public static String capiTalizeWords(String text){
        String[] strArray = text.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s : strArray) {
            String cap = s.substring(0, 1).toUpperCase() + s.substring(1);
            builder.append(cap + " ");
        }

        return builder.toString().trim();
    }

    public static void downMyKeyboard(View views, Context ctx){
        if (views != null) {
            InputMethodManager imm = (InputMethodManager)ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(views.getWindowToken(), 0);
        }
    }
    public static void showSnackBar(View view , String msg){
        Snackbar.make(view , msg , Snackbar.LENGTH_LONG).show();
    }

    public static void showToast(Context ctx , String msg){
        Toast.makeText(ctx, msg , Toast.LENGTH_LONG).show();
    }

    public static void openUrl(Context ctx , String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(url));
        ctx.startActivity(browserIntent);
    }

    public static void applyLabelFont(Context ctx , TextView tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/courgette.ttf");
        tv.setTypeface(custom_font);
    }

    public static void useProLight(Context ctx  , TextView tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_light.otf");
        tv.setTypeface(custom_font);
    }

    public static void useProLightItalic(Context ctx  , TextView tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_light_italic.otf");
        tv.setTypeface(custom_font);
    }

    public static void useProMedium(Context ctx  , TextView tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_medium_normal.otf");
        tv.setTypeface(custom_font);
    }

    public static void useProMediumButton(Context ctx  , Button tv){
//        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_medium_normal.otf");
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_regular.otf");
        tv.setTypeface(custom_font);
    }

    public static void useProMediumItalic(Context ctx  , TextView tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_medium_italic.otf");
        tv.setTypeface(custom_font);
    }

    public static void useProRegular(Context ctx  , TextView tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_regular.otf");
        tv.setTypeface(custom_font);
    }
    public static void useProRegularEditText(Context ctx  , TextView tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_regular.otf");
        tv.setTypeface(custom_font);
    }

    public static void applyEditTextFont(Context ctx , EditText tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_medium_normal.otf");
        tv.setTypeface(custom_font);
    }

    public static void useProBold(Context ctx , TextView tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_next_bold.otf");
        tv.setTypeface(custom_font);
    }

    public static void useProBoldItalic(Context ctx , TextView tv){
        Typeface custom_font = Typeface.createFromAsset(ctx.getAssets(),  "fonts/pro_bold_italic.otf");
        tv.setTypeface(custom_font);
    }

    public static void overrideProRegular(final Context context, final View v) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    overrideProRegular(context, child);
                }
            } else if (v instanceof TextView ) {
                ((TextView) v).setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/pro_regular.otf"));
            }
            else if (v instanceof Button) {
                ((Button) v).setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/pro_.otf"));
            }
        } catch (Exception e) {
        }
    }

    public static void shareApp(Context ctx , String url , String subject , String chooser){
        String shareBody = url;
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        ctx.startActivity(Intent.createChooser(sharingIntent, chooser));
    }

    public static String parseMyDate(String dates){
        String formatDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date d = formatter.parse(dates);
            formatter = new SimpleDateFormat("EEE, dd MMM yyyy");
            formatDate = formatter.format(d);
            System.out.println("Today : " + formatDate);
            return formatDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void showProgressDialog(){
        dialog = new ProgressDialog(ctx);
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);
        dialog.show();
    }

    public void hideDialog(){
        if(dialog!= null && dialog.isShowing())
            dialog.dismiss();
    }


    public static void hideKeypad(final Activity context) {
        try {
            InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {

        }
    }

    public static boolean validateForLength(View view, String x_fieldValue, int default_value) {
        if (view.getVisibility() == View.VISIBLE) {
            if (x_fieldValue.length() < default_value) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public static boolean validatePhoneNumber(View view, String x_phoneNumber, int x_defaultValue) {
        if (view.getVisibility() == View.VISIBLE) {
            if (x_phoneNumber.length() < x_defaultValue) {
                return false;
            } else {
                String expression = "^[6789]\\d{9}$";
                CharSequence inputStr = x_phoneNumber;
                Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(inputStr);
                if (matcher.matches()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
