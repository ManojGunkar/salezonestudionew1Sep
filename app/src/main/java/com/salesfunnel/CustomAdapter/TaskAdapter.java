package com.salesfunnel.CustomAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salesfunnel.Beans.TasksBean;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private ArrayList<TasksBean> catDataList;
    private View v;
    private Context _ctx;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text , author , time;

        private LinearLayout leadRoot;

        public MyViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.text);
            author = (TextView) view.findViewById(R.id.author);
            time = (TextView)view.findViewById(R.id.time);
        }
    }

    public TaskAdapter(Context _ctx, ArrayList<TasksBean> catDataList ) {
        this._ctx = _ctx;
        this.catDataList = catDataList;
    }

    @Override
    public void onBindViewHolder(TaskAdapter.MyViewHolder holder, final int position) {
        final TaskAdapter.MyViewHolder myholder = (TaskAdapter.MyViewHolder) holder;
        final TasksBean note = catDataList.get(position);
        myholder.text.setText(note.getTaskTitle());
        myholder.author.setText(note.getAuthor());
        myholder.time.setText(note.getDateTime());
    }


    @Override
    public int getItemCount() {
        return catDataList.size();
    }


    @Override
    public TaskAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_tasks, parent, false);
        return new TaskAdapter.MyViewHolder(v);
    }

}

