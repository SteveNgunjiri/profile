package com.example.schoolproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JobSeeker extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    TextView txt_pathShow;
    Button btn_filePicker;
    Intent myFileIntent;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (requestCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    txt_pathShow.setText(path);
                    break;
                }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jobseeker);
        getSupportActionBar().setTitle("jobSeeker");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner=findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.JobNeeded, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        btn_filePicker=(Button)findViewById(R.id.btn_filePicker);
        btn_filePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myFileIntent=new Intent(Intent.ACTION_GET_CONTENT);
               myFileIntent.setType("*/*");
               startActivityForResult(myFileIntent,10);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice=parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}