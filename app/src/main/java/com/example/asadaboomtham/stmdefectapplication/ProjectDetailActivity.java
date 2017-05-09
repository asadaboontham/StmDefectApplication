package com.example.asadaboomtham.stmdefectapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ProjectDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        String project = getIntent().getStringExtra("project");
        String name = getIntent().getStringExtra("name");
        String pst = getIntent().getStringExtra("pst");

        TextView pp = (TextView) findViewById(R.id.ProjectIDDetail);
        pp.setText(project);

        TextView aa = (TextView) findViewById(R.id.ProjectNameDetail);
        aa.setText(name);

        TextView bb = (TextView) findViewById(R.id.ProjectStatusDetail);
        if (pst.equals("1")) {
            pst = "กำลังดำเนินการ";
        }
        else if(pst.equals("2")){
            pst = "สิ้นสุดโครงการ";
        }
        else if(pst.equals("3")){
            pst = "ยกเลิกโครงการ";
        }
        else{
            pst = "ยังไม่ดำเนินการ";
        }
        bb.setText(pst);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
