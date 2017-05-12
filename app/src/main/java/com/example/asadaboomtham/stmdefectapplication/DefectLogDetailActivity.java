package com.example.asadaboomtham.stmdefectapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class DefectLogDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log_detail);

        String df_code = getIntent().getStringExtra("df_code");
        String dfs_id = getIntent().getStringExtra("dfs_id");
        String df_description = getIntent().getStringExtra("df_description");
        String df_dft_id = getIntent().getStringExtra("df_dft_id");
        String df_sv_id = getIntent().getStringExtra("df_sv_id");
        String df_pr_id = getIntent().getStringExtra("df_pr_id");
        String df_fixed_person = getIntent().getStringExtra("df_fixed_person");
        String df_module = getIntent().getStringExtra("df_module");
        String df_step = getIntent().getStringExtra("df_step");
        String df_reference = getIntent().getStringExtra("df_reference");

        TextView aa = (TextView) findViewById(R.id.df_code);
        aa.setText(df_code);

        TextView bb = (TextView) findViewById(R.id.df_dft_id);
        if (df_dft_id.equals("61")) {
            bb.setText("10-Documentation");
        }
        else if(df_dft_id.equals("62")){
            bb.setText("20-Syntax");
        }
        else if(df_dft_id.equals("63")){
            bb.setText("30-Build, Package");
        }
        else if(df_dft_id.equals("64")){
            bb.setText("40-Assignment");
        }
        else if(df_dft_id.equals("65")){
            bb.setText("50-Interface");
        }
        else if(df_dft_id.equals("66")){
            bb.setText("60-Checking");
        }
        else if(df_dft_id.equals("67")){
            bb.setText("70-Data");
        }
        else if(df_dft_id.equals("68")){
            bb.setText("80-Function");
        }
        else if(df_dft_id.equals("69")){
            bb.setText("90-System");
        }
        else if(df_dft_id.equals("70")){
            bb.setText("100-Environment");
        }
        else{
            bb.setText("ยังไม่กำหนด");
        }

        TextView dd = (TextView) findViewById(R.id.df_sv_id);
        if (df_sv_id.equals("1")) {
            dd.setText("ต่ำ");
        }
        else if(df_sv_id.equals("2")){
            dd.setText("กลาง");
        }
        else if(df_sv_id.equals("3")){
            dd.setText("สูง");
        }
        else if(df_sv_id.equals("4")){
            dd.setText("วิกฤติ");
        }
        else{
            dd.setText("ยังไม่กำหนด");
        }

        TextView ee = (TextView) findViewById(R.id.df_pr_id);
        if (df_pr_id.equals("123646")) {
            ee.setText("ต่ำ");
        }
        else if(df_pr_id.equals("123647")){
            ee.setText("กลาง");
        }
        else if(df_pr_id.equals("123648")){
            ee.setText("สูง");
        }
        else if(df_pr_id.equals("123649")){
            ee.setText("ด่วน");
        }
        else{
            ee.setText("ยังไม่กำหนด");
        }
        Log.d("df_pr_id", df_pr_id);

        TextView ff = (TextView) findViewById(R.id.df_fixed_person);
        if (df_fixed_person.equals("1")) {
            ff.setText("Mr.Admin");
        }
        else if(df_fixed_person.equals("2")){
            ff.setText("stmuser");
        }
        else if(df_fixed_person.equals("3")){
            ff.setText("HAS_Project");
        }
        else if(df_fixed_person.equals("4")){
            ff.setText("นฤชา มุสิทธิ์มณี");
        }
        else if(df_fixed_person.equals("5")){
            ff.setText("ภานุพันธ์ สานนท์");
        }
        else{
            ff.setText("-");
        }

        TextView gg = (TextView) findViewById(R.id.df_module);
        gg.setText(df_module);

        TextView hh = (TextView) findViewById(R.id.df_step);
        hh.setText(df_step);

        TextView ii = (TextView) findViewById(R.id.df_reference);
        ii.setText(df_reference);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);

    }
}
