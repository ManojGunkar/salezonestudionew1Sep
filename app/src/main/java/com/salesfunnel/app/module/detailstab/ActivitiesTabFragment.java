package com.salesfunnel.app.module.detailstab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesfunnel.R;


/**
 * Created by krishan on 24/06/2018 AD.
 */

public class ActivitiesTabFragment extends Fragment {

    public ActivitiesTabFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activitiestab, container, false);
        return view;
    }

}