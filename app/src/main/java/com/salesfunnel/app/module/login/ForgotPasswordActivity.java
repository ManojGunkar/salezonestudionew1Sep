package com.salesfunnel.app.module.login;

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

import com.salesfunnel.R;
import com.salesfunnel.app.utils.Utilities;


/**
 * Created by Manoj Kumar on 18-11-2018.
 */

public class ForgotPasswordActivity extends AppCompatActivity {

    private Button saveBtn;

    private TextInputLayout mInputEmail;
    private EditText etEmail;


    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-z]+";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        initToolbar();
        init();
    }

    private void init(){
        saveBtn = findViewById(R.id.saveBtn);

        etEmail = findViewById(R.id.et_email);
        etEmail.addTextChangedListener(new CustomTextWatcher(etEmail));

        mInputEmail = findViewById(R.id.input_email);

    }

    private void initToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Forgot Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        saveBtn.setOnClickListener(view -> {
            if (validateEmail()){
                Utilities.showSnackBar(view,"Under construction.");
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

    private boolean validateEmail() {
        String emailid = etEmail.getText().toString().trim();
        if (emailid.matches(EMAIL_PATTERN) && emailid.length() > 0) {
            mInputEmail.setErrorEnabled(false);
            return true;
        } else {
            mInputEmail.setError("Enter valid Email Id");
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
                case R.id.et_email:
                    validateEmail();
                    break;


            }
        }
    }
}

