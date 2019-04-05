package com.salesfunnel.CustomAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salesfunnel.Beans.NoteBean;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private ArrayList<NoteBean> catDataList;
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

    public NotesAdapter(Context _ctx, ArrayList<NoteBean> catDataList ) {
        this._ctx = _ctx;
        this.catDataList = catDataList;
    }

    @Override
    public void onBindViewHolder(NotesAdapter.MyViewHolder holder, final int position) {
        final NotesAdapter.MyViewHolder myholder = (NotesAdapter.MyViewHolder) holder;
        final NoteBean note = catDataList.get(position);
        myholder.text.setText(note.getText());
        myholder.author.setText("By "+note.getAuthor());
        myholder.time.setText(note.getTime());
    }


    @Override
    public int getItemCount() {
        return catDataList.size();
    }


    @Override
    public NotesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_note, parent, false);
        return new NotesAdapter.MyViewHolder(v);
    }

}

