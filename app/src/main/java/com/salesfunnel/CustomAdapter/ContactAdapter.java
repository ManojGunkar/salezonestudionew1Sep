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

import com.salesfunnel.Beans.ContactBean;
import com.salesfunnel.Details.ContactDetails;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public abstract class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private ArrayList<ContactBean> catDataList;
    private View v;
    private Context _ctx;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userChar , username , userjob, userloc , userStage , lastseen;

        private LinearLayout leadRoot;

        public MyViewHolder(View view) {
            super(view);
            lastseen = (TextView) view.findViewById(R.id.lastseen);
            userStage = (TextView) view.findViewById(R.id.userStage);
            userChar = (TextView)view.findViewById(R.id.userChar);
            username = (TextView) view.findViewById(R.id.username);
//            userjob = (TextView) view.findViewById(R.id.userjob);
//            userloc = (TextView) view.findViewById(R.id.userloc);
            leadRoot = (LinearLayout) view.findViewById(R.id.leadRoot);

        }
    }

    public ContactAdapter(Context _ctx, ArrayList<ContactBean> catDataList ) {
        this._ctx = _ctx;
        this.catDataList = catDataList;
    }

    @Override
    public void onBindViewHolder(ContactAdapter.MyViewHolder holder, final int position) {
        final ContactAdapter.MyViewHolder myholder = (ContactAdapter.MyViewHolder) holder;
        final ContactBean lead = catDataList.get(position);

//        myholder.userjob.setText(lead.getJob());
//        myholder.userloc.setText(lead.getLocation());
        myholder.username.setText(lead.getName());
        myholder.userStage.setText("$"+lead.getAmount());
        String charq = lead.getName().charAt(0)+"";
        myholder.userChar.setText(charq);

        GradientDrawable bgShape = (GradientDrawable) myholder.userChar.getBackground();
        bgShape.setColor(Color.parseColor("#7AFFCC"));
        myholder.lastseen.setText(lead.getLastseen());

        myholder.leadRoot.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                displaymoreoptions(lead.getId() , lead.getMail() , lead.getPhone());
                return false;
            }
        });

        myholder.leadRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contDetail = new Intent(_ctx , ContactDetails.class);
                _ctx.startActivity(contDetail);
            }
        });
    }


    @Override
    public int getItemCount() {
        return catDataList.size();
    }


    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_lead, parent, false);
        return new ContactAdapter.MyViewHolder(v);
    }

    public abstract void displaymoreoptions(String id , String email , String num);

}

