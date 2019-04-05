package com.salesfunnel.app.module.detailstab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesfunnel.Beans.NoteBean;
import com.salesfunnel.CustomAdapter.NotesAdapter;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 23/06/2018 AD.
 */
public class NoteTabFragment extends Fragment {

    public NoteTabFragment(){}

    private RecyclerView noteRecycler;
    private ArrayList<NoteBean> beanArr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        beanArr = new ArrayList<NoteBean>();
        noteRecycler = (RecyclerView)view.findViewById(R.id.noteRecycler);
        populateData();
    }

    private void populateData(){
        LinearLayoutManager mngr = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL, false);
        noteRecycler.setLayoutManager(mngr);
        NoteBean bean = new NoteBean("Hello this is dummy text" ,"Bharat arora","Yesterday at 3:34 am","1");
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        NotesAdapter adapter = new NotesAdapter(getActivity() , beanArr);
        noteRecycler.setAdapter(adapter);
    }
}
