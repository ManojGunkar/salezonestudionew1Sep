package com.salesfunnel.app.module.detailstab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.salesfunnel.app.AppController;
import com.salesfunnel.app.module.leads.activities.LeadDetailActivity;
import com.salesfunnel.R;
import com.salesfunnel.app.utils.Utilities;

import org.json.JSONObject;


/**
 * Created by krishan on 23/06/2018 AD.
 */

public class BasicInfoTabFragment extends Fragment {

    public BasicInfoTabFragment(){}
    private String num ="", email = "";
    private TextView leadText , srcText , locText , ownText;

    private ProgressBar mProgressBar;
    private LinearLayout llBasicInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basicinfo, container, false);
        init(view);
        getLeadDetailsApi();
        return view;
    }

    private void init(View view){
        mProgressBar=view.findViewById(R.id.progress_basic_details);
        llBasicInfo=view.findViewById(R.id.ll_info_basic_details);
        ownText = view.findViewById(R.id.ownText);
        leadText= view.findViewById(R.id.leadText);
        srcText = view.findViewById(R.id.srcText);
        locText = view.findViewById(R.id.locText);
    }

    private void getLeadDetailsApi(){
        mProgressBar.setVisibility(View.VISIBLE);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                getString(R.string.server_url)+getString(R.string.lead_details)+getActivity().getIntent().getStringExtra("LEADID"), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mProgressBar.setVisibility(View.GONE);
                llBasicInfo.setVisibility(View.VISIBLE);
                try {
                    Log.d("BASICINFO" ,"BASICINFO "+ response.toString());
                    LeadDetailActivity.username.setText(response.getString("firstName")+" "+response.getString("lastName"));
                    LeadDetailActivity.useremail.setText(response.getString("email"));
                    char one = LeadDetailActivity.username.getText().toString().trim().charAt(0);
                    LeadDetailActivity.charText.setText(one+"");
                    num = response.getString("mobileNumber");
                    email = response.getString("email");
                    leadText.setText(response.getString("leadStage"));
                    srcText.setText(response.getString("leadSource"));
                    ownText.setText(response.getString("brokerName"));
                    locText.setText(response.getString("addressLine1") +" "+response.getString("addressLine2") +", "+response.getString("city")+", "+response.getString("state")+" - "+response.getString("postalCode"));
                } catch (Exception e) {
                    e.printStackTrace();
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        }, error ->                 mProgressBar.setVisibility(View.GONE));

        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
