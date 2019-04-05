package com.salesfunnel.CustomAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salesfunnel.Beans.Notification;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private ArrayList<Notification> catDataList;
    private View v;
    private Context _ctx;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title , time , body;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            time = (TextView) view.findViewById(R.id.time);
            body = (TextView) view.findViewById(R.id.body);
        }
    }

    public NotificationAdapter(Context _ctx, ArrayList<Notification> catDataList ) {
        this._ctx = _ctx;
        this.catDataList = catDataList;
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.MyViewHolder holder, final int position) {
        final NotificationAdapter.MyViewHolder myholder = (NotificationAdapter.MyViewHolder) holder;
        final Notification account = catDataList.get(position);
        myholder.title.setText(account.getTitle());
        myholder.time.setText(account.getTime());
        myholder.body.setText(account.getBody());
    }

    @Override
    public int getItemCount() {
        return catDataList.size();
    }


    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_notification, parent, false);
        return new NotificationAdapter.MyViewHolder(v);
    }

}

