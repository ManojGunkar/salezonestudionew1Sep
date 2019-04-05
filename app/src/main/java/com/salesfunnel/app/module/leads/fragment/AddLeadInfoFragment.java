package com.salesfunnel.app.module.leads.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.salesfunnel.R;
import com.salesfunnel.apiconnector.model.LeadStatusApi;
import com.salesfunnel.apiconnector.presenter.ApiPresenter;
import com.salesfunnel.app.utils.Utilities;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manoj Kumar on 25-11-2018.
 * Copyright (C) 2018. Global Delight Technologies Pvt. Ltd. All rights reserved.
 */
public class AddLeadInfoFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.[a-z]+";
    private MaterialBetterSpinner mSpinFinalStatus;
    private MaterialBetterSpinner mSpinSubStatus;
    private MaterialBetterSpinner mSpinAgeGroup;
    private MaterialBetterSpinner mSpinLeadSource;

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

    private List<String> mFinalStatusList = new ArrayList<>();
    private List<String> mSubStatusList = new ArrayList<>();

    private Map<String, String> mMapFinalStatus = new HashMap<>();
    private Map<String, String> mMapSubStatus = new HashMap<>();
    private boolean isFinalStatusSelected = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_lead, null, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mSpinFinalStatus = view.findViewById(R.id.spin_final_status_add_lead);
        mSpinSubStatus = view.findViewById(R.id.spin_sub_status_add_lead);
        mSpinAgeGroup = view.findViewById(R.id.spin_age_add_lead);
        mSpinLeadSource = view.findViewById(R.id.spin_sorce_add_lead);

        mSpinFinalStatus.setOnItemClickListener(this);
        mSpinSubStatus.setOnItemClickListener(this);

        mEtFname = view.findViewById(R.id.et_first_name_add_lead);
        mEtLname = view.findViewById(R.id.et_lname_add_lead);
        mEtOrg = view.findViewById(R.id.et_org_add_lead);
        mEtMobile = view.findViewById(R.id.et_mobile_add_lead);
        mEtEmail = view.findViewById(R.id.et_email_add_lead);
        mEtPassword = view.findViewById(R.id.et_password_add_lead);

        mEtFname.addTextChangedListener(new CustomTextWatcher(mEtFname));
        mEtLname.addTextChangedListener(new CustomTextWatcher(mEtLname));
        mEtOrg.addTextChangedListener(new CustomTextWatcher(mEtOrg));
        mEtMobile.addTextChangedListener(new CustomTextWatcher(mEtMobile));
        mEtEmail.addTextChangedListener(new CustomTextWatcher(mEtEmail));
        mEtPassword.addTextChangedListener(new CustomTextWatcher(mEtPassword));

        mInputFname = view.findViewById(R.id.input_first_name_add_lead);
        mInputLname = view.findViewById(R.id.input_lname_add_lead);
        mInputOrg = view.findViewById(R.id.input_org_add_lead);
        mInputMobile = view.findViewById(R.id.input_mobile_add_lead);
        mInputEmail = view.findViewById(R.id.input_email_add_lead);
        mInputPassword = view.findViewById(R.id.input_password_add_lead);
    }

    private void getLeadStatus(String statusID, boolean isFinal) {
        ApiPresenter.getInstance(getActivity()).getLeadStatus(statusID, result -> {
            if (result.isSuccess()) {
                for (LeadStatusApi status : result.get()) {
                    if (isFinal) {
                        mFinalStatusList.add(status.getLeadStatusName());
                        mMapFinalStatus.put(String.valueOf(status.getLeadStatusId()), status.getLeadStatusName());
                    } else {
                        mSubStatusList.add(status.getLeadStatusName());
                        mMapSubStatus.put(String.valueOf(status.getLeadStatusId()), status.getLeadStatusName());
                    }
                }
                if (isFinal)
                    setSpinAdapter(mSpinFinalStatus, mFinalStatusList);
                else {
                    isFinalStatusSelected = false;
                    setSpinAdapter(mSpinSubStatus, mSubStatusList);
                }
            }
        });
    }

    private void setSpinAdapter(MaterialBetterSpinner spinner, List<String> list) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, list);
        spinner.setAdapter(arrayAdapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object value = parent.getItemAtPosition(position);
        String statusId = null;
        for (Object objKey : mMapFinalStatus.keySet()) {
            if (mMapFinalStatus.get(objKey).equals(value)) {
                statusId = objKey.toString();
                mSubStatusList.clear();
                isFinalStatusSelected = true;
                break;
            }
        }
        if (isFinalStatusSelected) {
            getLeadStatus(statusId, false);
        }
    }

    private void jumpToNext(){
        if (validateFirstName()
                &&validateLastName()
                &&validateOrg()
                &&validateMobile()
                &&validateEmail()
                &&validateUserPassword()){
            Utilities.showSnackBar(getActivity().getCurrentFocus(),"SignUp's api is not consumed.");

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
        if (password.length() > 0) {
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
                case R.id.et_first_name_add_lead:
                    validateFirstName();
                    break;

                case R.id.et_last_name:
                    validateLastName();
                    break;

                case R.id.et_org_add_lead:
                    validateOrg();
                    break;

                case R.id.et_mobile_add_lead:
                    validateMobile();
                    break;

                case R.id.et_email_add_lead:
                    validateEmail();
                    break;

                case R.id.et_password_add_lead:
                    validateUserPassword();
                    break;

            }
        }
    }
}
