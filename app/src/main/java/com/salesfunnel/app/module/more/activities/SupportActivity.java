package com.salesfunnel.app.module.more.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.salesfunnel.R;


/**
 * Created by krishan on 18/06/2018 AD.
 */

public class SupportActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

    String[] typeArr = {"Select", "Issue" , "Feedback" , "Suggestions"};
    String[] amArr = {"Select", "An existing customer" , "Prospective customer" , "General visitor to this app"};
    private Spinner typeSpin , amSpin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        init();
        initToolbar();
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SupportActivity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void init(){
        typeSpin = (Spinner) findViewById(R.id.typeSpin);
        amSpin = (Spinner) findViewById(R.id.amSpin);

        typeSpin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,typeArr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpin.setAdapter(aa);

        ArrayAdapter am = new ArrayAdapter(this,android.R.layout.simple_spinner_item,amArr);
        am.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amSpin.setAdapter(am);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
       // Toast.makeText(getApplicationContext(),typeArr[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void onResume() {
        super.onResume();
        amSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
