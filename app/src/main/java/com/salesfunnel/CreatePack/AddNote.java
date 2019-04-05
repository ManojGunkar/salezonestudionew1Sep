package com.salesfunnel.CreatePack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.salesfunnel.R;


/**
 * Created by krishan on 24/06/2018 AD.
 */

public class AddNote extends AppCompatActivity {

    private EditText noteText;
    private String notes = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        initToolbar();
        init();
    }

    private void init(){
        notes = getIntent().getStringExtra("NOTES");
        noteText = (EditText) findViewById(R.id.noteText);
        noteText.setText(notes);
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;

            case R.id.action_save:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
