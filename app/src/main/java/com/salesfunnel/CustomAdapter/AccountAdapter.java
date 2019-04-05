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

import com.salesfunnel.Beans.AccountBean;
import com.salesfunnel.Details.AccountDetails;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public abstract class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.MyViewHolder> {

    private ArrayList<AccountBean> catDataList;
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

    public AccountAdapter(Context _ctx, ArrayList<AccountBean> catDataList ) {
        this._ctx = _ctx;
        this.catDataList = catDataList;
    }

    @Override
    public void onBindViewHolder(AccountAdapter.MyViewHolder holder, final int position) {
        final AccountAdapter.MyViewHolder myholder = (AccountAdapter.MyViewHolder) holder;
        final AccountBean account = catDataList.get(position);

//        myholder.userjob.setText(account.getLocations());
//        myholder.userloc.setText(account.getOwnerName());
        myholder.username.setText(account.getOrgName());
        myholder.userStage.setText("$"+account.getPrice());
        String charq = account.getOrgName().charAt(0)+"";
        myholder.userChar.setText(charq);

        GradientDrawable bgShape = (GradientDrawable) myholder.userChar.getBackground();
        bgShape.setColor(Color.parseColor("#7AFFCC"));
        myholder.lastseen.setText(account.getTime());

        myholder.leadRoot.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                displaymoreoptions(account.getId() ,account.getLocations(),account.getCall());
                return false;
            }
        });

        myholder.leadRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acc = new Intent(_ctx , AccountDetails.class);
                _ctx.startActivity(acc);
            }
        });
    }


    @Override
    public int getItemCount() {
        return catDataList.size();
    }


    @Override
    public AccountAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_lead, parent, false);
        return new AccountAdapter.MyViewHolder(v);
    }

    public abstract void displaymoreoptions(String id , String location , String num);

}

