package com.salesfunnel.CustomAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salesfunnel.Beans.DealBean;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.MyViewHolder> {

    private ArrayList<DealBean> catDataList;
    private View v;
    private Context _ctx;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title , price , compName , stage , time;

        private LinearLayout leadRoot;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            compName = (TextView) view.findViewById(R.id.compName);
            stage = (TextView)view.findViewById(R.id.stage);
            time = (TextView) view.findViewById(R.id.time);
        }
    }

    public DealAdapter(Context _ctx, ArrayList<DealBean> catDataList ) {
        this._ctx = _ctx;
        this.catDataList = catDataList;
    }

    @Override
    public void onBindViewHolder(DealAdapter.MyViewHolder holder, final int position) {
        final DealAdapter.MyViewHolder myholder = (DealAdapter.MyViewHolder) holder;
        final DealBean log = catDataList.get(position);
        myholder.title.setText(log.getTitle());
        myholder.price.setText("$"+log.getPrice());
        myholder.compName.setText(log.getCompName());
        myholder.stage.setText(log.getStage());
        myholder.time.setText(log.getTime());
    }

    @Override
    public int getItemCount() {
        return catDataList.size();
    }


    @Override
    public DealAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_deal, parent, false);
        return new DealAdapter.MyViewHolder(v);
    }

}

