package com.example.asadaboomtham.stmdefectapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Defect_log_DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log__description);

        String df_description = getIntent().getStringExtra("df_description");

        TextView aa = (TextView) findViewById(R.id.df_description);
        aa.setText(df_description);

        Log.d("df_description", df_description);
    }
}
