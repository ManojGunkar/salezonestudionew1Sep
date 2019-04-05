package com.salesfunnel.app.module.detailstab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesfunnel.Beans.DealBean;
import com.salesfunnel.CustomAdapter.DealAdapter;
import com.salesfunnel.R;

import java.util.ArrayList;

import static com.salesfunnel.R.id.noteRecycler;

/**
 * Created by krishan on 24/06/2018 AD.
 */

public class DealTabFragment extends Fragment {

    public DealTabFragment(){}

    private RecyclerView logRecycler;
    private ArrayList<DealBean> beanArr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        beanArr = new ArrayList<DealBean>();
        logRecycler = (RecyclerView)view.findViewById(noteRecycler);
        populateData();
    }

    private void populateData(){
        LinearLayoutManager mngr = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL, false);
        logRecycler.setLayoutManager(mngr);
        DealBean bean = new DealBean("Gold plan (Sample deal)","Tulip","Won","7000","Today","1");
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        DealAdapter adapter = new DealAdapter(getActivity() , beanArr);
        logRecycler.setAdapter(adapter);
    }
}
