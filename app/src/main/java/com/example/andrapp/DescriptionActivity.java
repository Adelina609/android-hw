package com.example.andrapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    public final String NAME_TEXT = "text";
    public final String NAME_VALUE = "value";
    TextView tv_name;
    TextView tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        tv_name = findViewById(R.id.tv_name_desc);
        tv_desc = findViewById(R.id.tv_desc_description);
        Intent intent = getIntent();
        String name = intent.getStringExtra(NAME_TEXT);
        String desc = intent.getStringExtra(NAME_VALUE);
        tv_name.setText(name);
        tv_desc.setText(desc);
    }
}