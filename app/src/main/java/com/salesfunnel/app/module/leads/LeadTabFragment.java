package com.salesfunnel.app.module.leads;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.salesfunnel.app.AppController;
import com.salesfunnel.Beans.LeadBean;
import com.salesfunnel.CreatePack.AddNote;
import com.salesfunnel.CustomAdapter.LeadAdapter;
import com.salesfunnel.R;
import com.salesfunnel.app.utils.AppConstants;
import com.salesfunnel.app.utils.DataSource;
import com.salesfunnel.app.utils.Utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class LeadTabFragment extends Fragment {

    public LeadTabFragment(){}
    private ArrayList<LeadBean> leadArr;
    private RecyclerView leadRecycler;
    private Utilities utility;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lead, container, false);
        init(view);
        utility.showProgressDialog();
        getAllLeads();
        return view;
    }

    private void init(View view){
        utility = new Utilities(getActivity());
        leadArr = new ArrayList<LeadBean>();
        leadRecycler = (RecyclerView) view.findViewById(R.id.leadRecycler);

        populateArr();
    }

    private void populateArr(){
        LinearLayoutManager mngr = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false);
        leadRecycler.setLayoutManager(mngr);
        LeadAdapter adapter = new LeadAdapter(getActivity(), leadArr) {
            @Override
            public void displaymoreoptions(String id, String email, String num, String notes) {
                displayOptions(num,email , notes);
            }
        };
        leadRecycler.setAdapter(adapter);
    }

    private void getAllLeads(){
        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET,
                getString(R.string.server_url)+getString(R.string.show_all_leads)+ new DataSource(getContext()).getValue(AppConstants.USERID), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    utility.hideDialog();
                    int size = response.length();
                    for(int i=0; i<size ;i++){
                        JSONObject jobj = response.getJSONObject(i);
                        LeadBean bean = new LeadBean(jobj.getString("firstName")+" "+jobj.getString("middleName")+" "+jobj.getString("lastName"), jobj.getString("company"), jobj.getString("leadStage")+"/"+jobj.getString("subLeadStageName"),
                                jobj.getString("state")+","+jobj.getString("country"),jobj.getString("lastModifiedDate").split("T")[0], jobj.getString("mobileNumber"), jobj.getString("email"),
                                jobj.getString("leadId"), jobj.getString("notes"), jobj.getString("dealSize"));
                        leadArr.add(bean);
                    }
                    populateArr();
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


    private void displayOptions(final String call ,final String email ,final String notes){
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(getActivity());

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        arrayAdapter.add("Call");
        arrayAdapter.add("Mail");
        arrayAdapter.add("Add Note");
        arrayAdapter.add("Change Stage");

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                   if(strName.equalsIgnoreCase("Add Note")){
                       Intent addnote = new Intent(getActivity() , AddNote.class);
                       addnote.putExtra("NOTES", notes);
                       startActivity(addnote);
                   }
                   else if(strName.equalsIgnoreCase("Call")){
                      Utilities.callThisNumber(call, getActivity());
                   }
                   else if(strName.equalsIgnoreCase("Mail")){
                       String arr[]  = {email};
                       Intent intent = new Intent(Intent.ACTION_SEND);
                       intent.setType("text/plain");
                       intent.putExtra(Intent.EXTRA_EMAIL, arr);
                       intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                       intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

                       startActivity(Intent.createChooser(intent, "Send Email"));
                   }
            }
        });
        builderSingle.show();
    }
}
