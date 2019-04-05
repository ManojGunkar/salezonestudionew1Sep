package com.salesfunnel.CreatePack;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import com.salesfunnel.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by krishan on 24/06/2018 AD.
 */

public class AddDeal extends AppCompatActivity {

    private EditText ownEdit , relateEdit , dateEdit;
    private Calendar myCalendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddeal);
        init();
        initToolbar();
    }

    private void init(){
        myCalendar = Calendar.getInstance();
        ownEdit = (EditText) findViewById(R.id.ownEdit);
        relateEdit = (EditText) findViewById(R.id.relateEdit);
        dateEdit = (EditText) findViewById(R.id.dateEdit);
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Deal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormat = "yyyy-MM-dd"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            dateEdit.setText(sdf.format(myCalendar.getTime()));
        }
    };


    private void showOwnersList(String title){
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(AddDeal.this);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddDeal.this, android.R.layout.simple_list_item_1);
        arrayAdapter.add("Bharat");
        arrayAdapter.add("Paras");
        arrayAdapter.add("Lovish");

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                ownEdit.setText(strName);
            }
        });
        builderSingle.setTitle(title);
        builderSingle.show();
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

    @Override
    protected void onResume() {
        super.onResume();
        ownEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOwnersList("Owners List");
            }
        });
        relateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOwnersList("Related Contacts");
            }
        });
        dateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddDeal.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
}
