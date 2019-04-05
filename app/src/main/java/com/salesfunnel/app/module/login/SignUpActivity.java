package com.salesfunnel.app.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.salesfunnel.R;
import com.salesfunnel.app.activities.HomeActivity;
import com.salesfunnel.app.utils.Utilities;

/**
 * Created by Manoj Kumar on 18-11-2018.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-z]+";

    private TextView txtLogin;
    private Button btnSignUp;

    private TextInputLayout mInputFname;
    private TextInputLayout mInputLname;
    private TextInputLayout mInputOrg;
    private TextInputLayout mInputMobile;
    private TextInputLayout mInputEmail;
    private TextInputLayout mInputPassword;

    private EditText mEtFname;
    private EditText mEtLname;
    private EditText mEtOrg;
    private EditText mEtMobile;
    private EditText mEtEmail;
    private EditText mEtPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initToolbar();
        init();
    }

    private void init() {
        btnSignUp = findViewById(R.id.btn_signup);
        btnSignUp.setOnClickListener(this::onClick);
        txtLogin = findViewById(R.id.txt_login_signup);
        txtLogin.setOnClickListener(this::onClick);

        mEtFname = findViewById(R.id.et_first_name_sign);
        mEtLname = findViewById(R.id.et_lname_sign);
        mEtOrg = findViewById(R.id.et_org_sign);
        mEtMobile = findViewById(R.id.et_mobile_sign);
        mEtEmail = findViewById(R.id.et_email_sign);
        mEtPassword = findViewById(R.id.et_password_sign);

        mEtFname.addTextChangedListener(new CustomTextWatcher(mEtFname));
        mEtLname.addTextChangedListener(new CustomTextWatcher(mEtLname));
        mEtOrg.addTextChangedListener(new CustomTextWatcher(mEtOrg));
        mEtMobile.addTextChangedListener(new CustomTextWatcher(mEtMobile));
        mEtEmail.addTextChangedListener(new CustomTextWatcher(mEtEmail));
        mEtPassword.addTextChangedListener(new CustomTextWatcher(mEtPassword));

        mInputFname = findViewById(R.id.input_first_name_sign);
        mInputLname = findViewById(R.id.input_lname_sign);
        mInputOrg = findViewById(R.id.input_org_sign);
        mInputMobile = findViewById(R.id.input_mobile_sign);
        mInputEmail = findViewById(R.id.input_email_sign);
        mInputPassword = findViewById(R.id.input_password_sign);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_login_signup:
                Intent login = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(login);
                finish();
                break;

            case R.id.btn_signup:
               if (validateFirstName()
                       &&validateLastName()
                       &&validateOrg()
                       &&validateMobile()
                       &&validateEmail()
                       &&validateUserPassword()){
                   Utilities.showSnackBar(v,"SignUp's api is not consumed.");

               }
                break;
        }
    }

    private boolean validateFirstName() {
        String name = mEtFname.getText().toString().trim();
        if (name.length() > 0) {
            mInputFname.setErrorEnabled(false);
            return true;
        } else {
            mInputFname.setError("Enter valid Name");
            return false;

        }

    }

    private boolean validateLastName() {
        String name = mEtLname.getText().toString().trim();
        if (name.length() > 0) {
            mInputLname.setErrorEnabled(false);
            return true;
        } else {
            mInputLname.setError("Enter valid Name");
            return false;

        }

    }

    private boolean validateOrg() {
        String org = mEtOrg.getText().toString().trim();
        if (org.length() > 0) {
            mInputOrg.setErrorEnabled(false);
            return true;
        } else {
            mInputOrg.setError("Enter valid Organisation Name");
            return false;

        }

    }

    private boolean validateMobile() {
        String mobile = mEtMobile.getText().toString().trim();
        if (mobile.length() <= 10) {
            mInputMobile.setError("Enter valid mobile");
            return false;

        } else {
            mInputMobile.setErrorEnabled(false);
            return true;

        }

    }

    private boolean validateEmail() {
        String emailid = mEtEmail.getText().toString().trim();
        if (emailid.matches(EMAIL_PATTERN) && emailid.length() > 0) {
            mInputEmail.setErrorEnabled(false);
            return true;
        } else {
            mInputEmail.setError("Enter valid Email Id");
            return false;

        }
    }

    private boolean validateUserPassword() {
        String password = mEtPassword.getText().toString().trim();
        if ( password.length() > 0) {
            mInputPassword.setErrorEnabled(false);
            return true;
        } else {
            mInputPassword.setError("Password should be 6 or more than characters long");
            return false;
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
                case R.id.et_first_name_sign:
                    validateFirstName();
                    break;

                case R.id.et_last_name:
                    validateLastName();
                    break;

                case R.id.et_org_sign:
                    validateOrg();
                    break;

                case R.id.et_mobile_sign:
                    validateMobile();
                    break;

                case R.id.et_email_sign:
                    validateEmail();
                    break;

                case R.id.et_password_sign:
                    validateUserPassword();
                    break;

            }
        }
    }

}
