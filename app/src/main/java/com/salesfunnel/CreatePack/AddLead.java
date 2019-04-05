package com.salesfunnel.CreatePack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.salesfunnel.ApiModel.LeadApiModel;
import com.salesfunnel.ApiModelBuilder.LeadApiModelBuilder;
import com.salesfunnel.app.AppController;
import com.salesfunnel.app.activities.HomeActivity;
import com.salesfunnel.R;
import com.salesfunnel.app.utils.AppConstants;
import com.salesfunnel.app.utils.DataSource;
import com.salesfunnel.app.utils.Utilities;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by krishan on 19/06/2018 AD.
 */

public class AddLead extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button moreBtn;
    private LinearLayout moreLayout;
    private ImageView iv_add_lead;
    private MaterialBetterSpinner sp_finalStatus, sp_subStatus, sp_ageGroup, sp_leadSource;
    private EditText et_firstName, et_mName, et_lName, et_mobileNumber, et_dealSize, et_email, et_phone;
    private LeadApiModel leadApiModel;
    private DataSource dataSource;
    private Utilities utility;
    private String fName, mName, lName, mobile, leadStage, potential, ageGroup, leadSource, email, phone;
    private double dealSize;
    private ArrayList<String> finalStatuslist = new ArrayList<>();
    private ArrayList<String> subStatuslist = new ArrayList<>();
    private HashMap<String, String> hashMapFinalStatus = new HashMap<>();
    private HashMap<String, String> hashMapSubStatus = new HashMap<>();
    ArrayAdapter<String> subStatuaArrayAdapter;
    private boolean isFinalStatusSelected;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lead);
        init();
        initToolbar();
        getfinalStatusData();
        setfinalStatusSpinner();
        setSubStatusSpinner();
        setAgeGroupSpinner();
        setLeadSourceSpinner();

    }

    private void init(){
        dataSource = new DataSource(this);
        utility = new Utilities(this);
        moreBtn = (Button) findViewById(R.id.moreBtn);
        moreLayout = (LinearLayout) findViewById(R.id.moreLayout);
        iv_add_lead = (ImageView) findViewById(R.id.iv_add_lead);
        et_firstName = (EditText) findViewById(R.id.fname);
        et_mName = (EditText) findViewById(R.id.et_mname);
        et_lName = (EditText) findViewById(R.id.et_lname);
        et_mobileNumber = (EditText) findViewById(R.id.mobEdit);
        et_dealSize = (EditText) findViewById(R.id.dealEdit);
        et_email = (EditText) findViewById(R.id.emailEdit);
        et_phone = (EditText) findViewById(R.id.et_phone);
        sp_finalStatus = (MaterialBetterSpinner) findViewById(R.id.sp_finalStatus);
        sp_subStatus = (MaterialBetterSpinner) findViewById(R.id.sp_subStatus);
        sp_ageGroup = (MaterialBetterSpinner) findViewById(R.id.sp_ageGroup);
        sp_leadSource = (MaterialBetterSpinner) findViewById(R.id.sp_leadSource);

        iv_add_lead.setOnClickListener(this);
        sp_finalStatus.setOnItemClickListener(this);
        sp_subStatus.setOnItemClickListener(this);

    }

    private void setfinalStatusSpinner(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, finalStatuslist);
        sp_finalStatus.setAdapter(arrayAdapter);
    }

    private void setSubStatusSpinner(){
        subStatuaArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, subStatuslist);
        sp_subStatus.setAdapter(subStatuaArrayAdapter);
        sp_subStatus.setSelection(0);
    }

    private void setAgeGroupSpinner(){
        String[] ageGroup = getResources().getStringArray(R.array.ageGroupArray);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, ageGroup);
        sp_ageGroup.setAdapter(adapter);
    }

    private void setLeadSourceSpinner(){
        String[] leadSource = getResources().getStringArray(R.array.leadSourceArray);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, leadSource);
        sp_leadSource.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
      /*  moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(moreLayout.getVisibility() == View.VISIBLE) {
                    moreLayout.setVisibility(View.GONE);
                    moreBtn.setText("SHOW MORE");
                }
                else{
                    moreBtn.setText("SHOW LESS");
                    moreLayout.setVisibility(View.VISIBLE);
                }
            }
        });*/
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add LeadApi");
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

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.iv_add_lead:
                getData();
                if(mValidate()) {
                    create();
                }
                break;
        }
    }

    private boolean mValidate() {
        Utilities.hideKeypad(this);
        if (et_firstName.getText().toString().trim().equalsIgnoreCase("") || !Utilities.validateForLength(et_firstName, et_firstName.getText().toString().trim(), 1)) {
            Utilities.showToast(this, getString(R.string.error_lead_first_name));
            return false;
        } else if (et_mobileNumber.getText().toString().trim().equalsIgnoreCase("") || !Utilities.validateForLength(et_mobileNumber, et_mobileNumber.getText().toString().trim(), 10)) {
            Utilities.showToast(this, getString(R.string.error_mobile_number));
            return false;
        }else {
            return true;
        }
    }

    private void getfinalStatusData(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConstants.URL+"0", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    utility.hideDialog();
                    JSONObject jsonObject = null;
                    Log.d("FinalStatusINFO" , "FinalStatusINFO "+response.toString());
                    JSONArray jsonArray = new JSONArray(response.toString());
                    for(int i = 0; i< jsonArray.length(); i++){
                        jsonObject = jsonArray.getJSONObject(i);

                        hashMapFinalStatus.put(jsonObject.optString("leadStatusId"), jsonObject.optString("leadStatusName"));
                        finalStatuslist.add(jsonObject.optString("leadStatusName"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    utility.hideDialog();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    private void getSubStatusData(String key){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, AppConstants.URL+key, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    utility.hideDialog();
                    JSONObject jsonObject = null;
                    Log.d("SubStatusINFO" , "SubStatusINFO "+response.toString());
                    JSONArray jsonArray = new JSONArray(response.toString());
                    for(int i = 0; i< jsonArray.length(); i++){
                        jsonObject = jsonArray.getJSONObject(i);
                        hashMapSubStatus.put(jsonObject.optString("leadStatusId"), jsonObject.optString("leadStatusName"));
                        subStatuslist.add(jsonObject.optString("leadStatusName"));
                    }
                    setSubStatusSpinner();
                    isFinalStatusSelected = false;

                } catch (Exception e) {
                    e.printStackTrace();
                    utility.hideDialog();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

// Create LeadApi Info - Ankita

    private void create(){
        JSONObject jsonObj = null;

        try {
            Gson gson = new Gson();
            leadApiModel = new LeadApiModelBuilder().setFirstName(fName).setMiddleName(mName).setLastName(lName).setMobileNumber(mobile)
                    .setLeadStage(leadStage).setPotential(potential).setDealSize(dealSize).setAgeGroup(ageGroup)
                    .setLeadSource(leadSource).setEmail(email).setPhoneNumber(phone).getLeadApiModel();
            String jsonString = gson.toJson(leadApiModel);
            jsonObj = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                getString(R.string.server_url)+getString(R.string.lead_details)+getString(R.string.lead_save),jsonObj , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    utility.hideDialog();
                    Log.d("LEADINFO" , "LEADINFO "+response.toString());
                    Utilities.showToast(AddLead.this, getString(R.string.lead_created));
                    Intent reg = new Intent(AddLead.this , HomeActivity.class);
                    startActivity(reg);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    utility.hideDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                utility.hideDialog();
            }
        });
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

private void getData(){
        fName = et_firstName.getText().toString();
        mName = et_mName.getText().toString();
        lName = et_lName.getText().toString();
        mobile = et_mobileNumber.getText().toString();
        try {
            if(et_dealSize.getText().toString() != null || !(et_dealSize.getText().toString().equalsIgnoreCase(""))) {
                dealSize = Double.parseDouble(et_dealSize.getText().toString());
            }else {
                dealSize = 0;
            }
        } catch (Exception e){
            e.printStackTrace();
            dealSize = 0;
        }

        ageGroup = sp_ageGroup.getText().toString();
        leadSource = sp_ageGroup.getText().toString();
        email = et_email.getText().toString();
        phone = et_phone.getText().toString();
        leadStage = sp_finalStatus.getText().toString();
//        potential = sp_subStatus.getText().toString();

  /*  String finalStatusKey = "";
    for (Object objKey : hashMapFinalStatus.keySet()) {
        if (hashMapFinalStatus.get(objKey).equals(sp_finalStatus.getText().toString())) {
            finalStatusKey = objKey.toString();
        }
    }
    leadStage = finalStatusKey;*/

    String keySubStatus = "";
    for (Object objKey : hashMapSubStatus.keySet()) {
        if (hashMapSubStatus.get(objKey).equals(sp_subStatus.getText().toString())) {
            keySubStatus = objKey.toString();
        }
    }
    potential = keySubStatus;

 }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Object value = parent.getItemAtPosition(position);
//            leadStage = value.toString();
            String key = "";
            for (Object objKey : hashMapFinalStatus.keySet()) {
                if (hashMapFinalStatus.get(objKey).equals(value)) {
                    key = objKey.toString();
                    subStatuslist.clear();
                    isFinalStatusSelected = true;
                    break;
                }
            }
            if(isFinalStatusSelected) {
                utility.showProgressDialog();
                getSubStatusData(key);
            }
    }

}

