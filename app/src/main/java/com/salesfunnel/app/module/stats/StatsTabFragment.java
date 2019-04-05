package com.salesfunnel.app.module.stats;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.salesfunnel.R;

import java.util.ArrayList;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class StatsTabFragment extends Fragment {

    private PieChart pieChart ;
    private ArrayList<Entry> entries ;
    private ArrayList<String> PieEntryLabels ;
    private PieDataSet pieDataSet ;
    private PieData pieData ;

    public StatsTabFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        init(view);
        return view;
    }

    private void init(View view){
        pieChart = (PieChart) view.findViewById(R.id.chart1);
        entries = new ArrayList<>();
        PieEntryLabels = new ArrayList<String>();
        AddValuesToPIEENTRY();
        AddValuesToPieEntryLabels();
        pieDataSet = new PieDataSet(entries, "");
        pieData = new PieData(PieEntryLabels, pieDataSet);
        pieData.setValueTextSize(17);
        pieData.setValueTextColor(Color.WHITE);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setData(pieData);
        pieChart.animateY(2000);
    }

    public void AddValuesToPIEENTRY(){

        entries.add(new BarEntry(2f, 0));
        entries.add(new BarEntry(4f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(8f, 3));
    }

    public void AddValuesToPieEntryLabels(){

        PieEntryLabels.add("High");
        PieEntryLabels.add("Medium");
        PieEntryLabels.add("Low");
        PieEntryLabels.add("Not Relevant");

    }
}
