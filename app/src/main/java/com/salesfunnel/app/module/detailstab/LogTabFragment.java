package com.salesfunnel.app.module.detailstab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesfunnel.Beans.LogBean;
import com.salesfunnel.CustomAdapter.LogAdapter;
import com.salesfunnel.R;

import java.util.ArrayList;

import static com.salesfunnel.R.id.noteRecycler;

/**
 * Created by krishan on 24/06/2018 AD.
 */

public class LogTabFragment extends Fragment {

    public LogTabFragment(){}

    private RecyclerView logRecycler;
    private ArrayList<LogBean> beanArr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        beanArr = new ArrayList<LogBean>();
        logRecycler = (RecyclerView)view.findViewById(noteRecycler);
        populateData();
    }

    private void populateData(){
        LinearLayoutManager mngr = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL, false);
        logRecycler.setLayoutManager(mngr);
        LogBean bean = new LogBean("Outgoing Call","Not able to reach","Trying call many times","Yesterday at 11:24 PM","1");
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        LogAdapter adapter = new LogAdapter(getActivity() , beanArr);
        logRecycler.setAdapter(adapter);
    }
}
