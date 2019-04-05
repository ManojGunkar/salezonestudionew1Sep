package com.salesfunnel.app.module.detailstab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesfunnel.Beans.AppointBean;
import com.salesfunnel.CustomAdapter.AppointAdapter;
import com.salesfunnel.R;

import java.util.ArrayList;

import static com.salesfunnel.R.id.noteRecycler;


/**
 * Created by krishan on 23/06/2018 AD.
 */
public class AppointTabFragment extends Fragment {

    public AppointTabFragment(){}

    private RecyclerView taskRecycler;
    private ArrayList<AppointBean> beanArr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        beanArr = new ArrayList<AppointBean>();
        taskRecycler = (RecyclerView)view.findViewById(noteRecycler);
        populateData();
    }

    private void populateData(){
        LinearLayoutManager mngr = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL, false);
        taskRecycler.setLayoutManager(mngr);
        AppointBean bean = new AppointBean("Follow-up with Jane" ,"Bharat arora","Mon 18 Jun, 2018 10:00 AM - 12:00 PM","1");
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        AppointAdapter adapter = new AppointAdapter(getActivity() , beanArr);
        taskRecycler.setAdapter(adapter);
    }
}
