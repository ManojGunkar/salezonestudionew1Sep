package com.salesfunnel.CreatePack;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.salesfunnel.R;


/**
 * Created by krishan on 18/06/2018 AD.
 */

public class CreateAccount extends AppCompatActivity {

    private EditText ownEdit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        initToolbar();
        init();
    }

    private void init(){
        ownEdit = (EditText) findViewById(R.id.ownEdit);
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void showOwnersList(){
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(CreateAccount.this);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(CreateAccount.this, android.R.layout.simple_list_item_1);
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
        builderSingle.setTitle("Owners List");
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
                showOwnersList();
            }
        });
    }
}
