package com.salesfunnel.app.module.detailstab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesfunnel.Beans.TasksBean;
import com.salesfunnel.CustomAdapter.TaskAdapter;
import com.salesfunnel.R;

import java.util.ArrayList;

import static com.salesfunnel.R.id.noteRecycler;

/**
 * Created by krishan on 23/06/2018 AD.
 */
public class TaskTabFragment extends Fragment {

    public TaskTabFragment(){}

    private RecyclerView taskRecycler;
    private ArrayList<TasksBean> beanArr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        beanArr = new ArrayList<TasksBean>();
        taskRecycler = (RecyclerView)view.findViewById(noteRecycler);
        populateData();
    }

    private void populateData(){
        LinearLayoutManager mngr = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL, false);
        taskRecycler.setLayoutManager(mngr);
        TasksBean bean = new TasksBean("Follow-up with Jane" ,"Bharat arora","Mon 18 Jun, 2018 10:00 AM","1");
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        beanArr.add(bean);beanArr.add(bean);beanArr.add(bean);
        TaskAdapter adapter = new TaskAdapter(getActivity() , beanArr);
        taskRecycler.setAdapter(adapter);
    }
}
