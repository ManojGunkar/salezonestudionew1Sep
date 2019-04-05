package com.salesfunnel.app.module.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.salesfunnel.R;
import com.salesfunnel.apiconnector.model.CrmUserApi;
import com.salesfunnel.apiconnector.presenter.ApiPresenter;
import com.salesfunnel.app.activities.HomeActivity;
import com.salesfunnel.app.utils.AppConstants;
import com.salesfunnel.app.utils.DataSource;
import com.salesfunnel.app.utils.UserCredentials;
import com.salesfunnel.app.utils.Utilities;

/**
 * Created by Manoj Kumar on 18-11-2018.
 */

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private final int REQUEST_READ_LOCATION_PERMISSION = 202;

    private Utilities utility;
    private DataSource dataSource;

    private Button btnlogIn;

    private TextView txtForgot;
    private TextView txtSignUp;

    private String username, password;

    private EditText etUserName;
    private EditText etPassword;

    private TextInputLayout mInputUserId;
    private TextInputLayout mInputPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initToolbar();
        init();
        getUserLocation();
    }

    private void getUserLocation() {
        if (ActivityCompat.checkSelfPermission(LogInActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(LogInActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions(LogInActivity.this, new
                    String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_READ_LOCATION_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_LOCATION_PERMISSION: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.d("PERMISSION GRANTED", "PERMISSION GRANTED");

                } else if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                    //once user denied and again access the permission
                    Intent i = new Intent();
                    i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    i.addCategory(Intent.CATEGORY_DEFAULT);
                    i.setData(Uri.parse("package:" + getPackageName()));
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                    startActivity(i);

                    Toast.makeText(this, "For better user experience please allow us to access your location.", Toast.LENGTH_LONG).show();
                } else {

                }
                return;
            }
        }
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sign In");
    }

    private void init() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        utility = new Utilities(LogInActivity.this);

        etUserName = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        etUserName.addTextChangedListener(new CustomTextWatcher(etUserName));
        etPassword.addTextChangedListener(new CustomTextWatcher(etPassword));

        mInputUserId = findViewById(R.id.input_username);
        mInputPassword = findViewById(R.id.input_password);

        txtSignUp = findViewById(R.id.txt_sign_up);
        txtSignUp.setOnClickListener(this::onClick);

        txtForgot = findViewById(R.id.txt_forget);
        txtForgot.setOnClickListener(this::onClick);

        btnlogIn = findViewById(R.id.btn_login);
        btnlogIn.setOnClickListener(this::onClick);


    }

    private void loginWithMVC() {
        utility.showProgressDialog();
        username = etUserName.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        CrmUserApi loginRequestBody = new CrmUserApi();
        loginRequestBody.setUserName(username);
        loginRequestBody.setUserPassword(password);
        ApiPresenter.getInstance(this).logIn(loginRequestBody, result -> {
            if (result.isSuccess()) {
                utility.hideDialog();
                CrmUserApi loginResponse = result.get();
                UserCredentials.getCredentials(this).storeLogin(loginResponse);
                dataSource=new DataSource(this);
                dataSource.saveValues(AppConstants.USERID, loginResponse.getUserId());
                dataSource.saveValues(AppConstants.FNAME, loginResponse.getFirstName());
                dataSource.saveValues(AppConstants.LNAME, loginResponse.getLastName());
                dataSource.saveValues(AppConstants.MOBILE, loginResponse.getMobileNumber());
                dataSource.saveValues(AppConstants.DOB, loginResponse.getDob());
                dataSource.saveValues(AppConstants.EMAIL, loginResponse.getEmail());
                Intent reg = new Intent(LogInActivity.this, HomeActivity.class);
                startActivity(reg);
                finish();
            }else {
                utility.hideDialog();
                mInputUserId.setError("Username or password is wrong");
                mInputPassword.setError("Username or password is wrong");
            }
        });
    }

    private boolean validateUserName() {
        String userId = etUserName.getText().toString().trim();
        if ( userId.length() > 0) {
            mInputUserId.setErrorEnabled(false);
            return true;
        } else {
            mInputUserId.setError("Enter valid UserId");
            return false;

        }

    }

    private boolean validateUserPassword() {
        String password = etUserName.getText().toString().trim();
        if ( password.length() > 0) {
            mInputUserId.setErrorEnabled(false);
            return true;
        } else {
            mInputUserId.setError("Password should be 6 or more than characters long");
            return false;

        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (Utilities.isOnline(this)){
                    if (validateUserName() && validateUserPassword())
                        loginWithMVC();
                }else {
                    Utilities.showSnackBar(v,"No internet connection.");
                }

                break;

            case R.id.txt_forget:
                Intent forget = new Intent(LogInActivity.this, ForgotPasswordActivity.class);
                startActivity(forget);
                break;

            case R.id.txt_sign_up:
                Intent reg = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(reg);
                finish();
                break;

        }
    }

    private class CustomTextWatcher implements TextWatcher {

        private View view;

        private CustomTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.et_username:
                    validateUserName();
                    break;
                case R.id.et_password:
                    validateUserPassword();
                    break;

            }
        }
    }
}
