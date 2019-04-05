package com.salesfunnel.CustomAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salesfunnel.Beans.LogBean;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.MyViewHolder> {

    private ArrayList<LogBean> catDataList;
    private View v;
    private Context _ctx;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text , note , time , outcome;

        private LinearLayout leadRoot;

        public MyViewHolder(View view) {
            super(view);
            outcome = (TextView) view.findViewById(R.id.outcome);
            text = (TextView) view.findViewById(R.id.text);
            note = (TextView) view.findViewById(R.id.note);
            time = (TextView)view.findViewById(R.id.time);
        }
    }

    public LogAdapter(Context _ctx, ArrayList<LogBean> catDataList ) {
        this._ctx = _ctx;
        this.catDataList = catDataList;
    }

    @Override
    public void onBindViewHolder(LogAdapter.MyViewHolder holder, final int position) {
        final LogAdapter.MyViewHolder myholder = (LogAdapter.MyViewHolder) holder;
        final LogBean log = catDataList.get(position);
        myholder.text.setText(log.getType());
        myholder.note.setText(log.getNotes());
        myholder.time.setText(log.getTime());
        myholder.outcome.setText(log.getOutCome());
    }

    @Override
    public int getItemCount() {
        return catDataList.size();
    }


    @Override
    public LogAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_log, parent, false);
        return new LogAdapter.MyViewHolder(v);
    }

}

