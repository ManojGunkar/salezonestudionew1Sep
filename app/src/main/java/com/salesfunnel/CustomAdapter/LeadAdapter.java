package com.salesfunnel.CustomAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salesfunnel.Beans.LeadBean;
import com.salesfunnel.app.module.leads.activities.LeadDetailActivity;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public abstract class LeadAdapter extends RecyclerView.Adapter<LeadAdapter.MyViewHolder> {

    private ArrayList<LeadBean> catDataList;
    private View v;
    private Context _ctx;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userChar , username , tv_mobile, tv_email, tv_dealSize , userStage , lastseen;

        private LinearLayout leadRoot;

        public MyViewHolder(View view) {
            super(view);
            lastseen = (TextView) view.findViewById(R.id.lastseen);
            userStage = (TextView) view.findViewById(R.id.userStage);
            userChar = (TextView)view.findViewById(R.id.userChar);
            username = (TextView) view.findViewById(R.id.username);
            tv_mobile = (TextView) view.findViewById(R.id.tv_mobile);
            tv_email = (TextView) view.findViewById(R.id.tv_email);
            tv_dealSize = (TextView) view.findViewById(R.id.tv_deal_size);
            leadRoot = (LinearLayout) view.findViewById(R.id.leadRoot);

        }
    }

    public LeadAdapter(Context _ctx, ArrayList<LeadBean> catDataList ) {
        this._ctx = _ctx;
        this.catDataList = catDataList;
    }

    @Override
    public void onBindViewHolder(LeadAdapter.MyViewHolder holder,final int position) {
        final LeadAdapter.MyViewHolder myholder = (LeadAdapter.MyViewHolder) holder;
        final LeadBean lead = catDataList.get(position);

        myholder.tv_mobile.setText(lead.getPhone());
        myholder.tv_email.setText(lead.getMail());
        myholder.username.setText(lead.getName());
        myholder.userStage.setText(lead.getStage());
        myholder.tv_dealSize.setText(lead.getDealSize());
        String charq = lead.getName().charAt(0)+"";
        myholder.userChar.setText(charq);

        GradientDrawable bgShape = (GradientDrawable) myholder.userChar.getBackground();
        bgShape.setColor(Color.parseColor("#7AFFCC"));
        myholder.lastseen.setText(lead.getLastseen());

        myholder.leadRoot.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                displaymoreoptions(lead.getId() , lead.getMail() , lead.getPhone() , lead.getNotes());
                return false;
            }
        });

        myholder.leadRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(_ctx , LeadDetailActivity.class);
                detail.putExtra("LEADID", lead.getId());
                _ctx.startActivity(detail);
            }
        });
    }


    @Override
    public int getItemCount() {
        return catDataList.size();
    }


    @Override
    public LeadAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_lead, parent, false);
        return new LeadAdapter.MyViewHolder(v);
    }

    public abstract void displaymoreoptions(String id , String email , String num, String notes);

}

