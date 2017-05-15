package com.example.asadaboomtham.stmdefectapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_defectlog:
                String pj_id = getIntent().getStringExtra("pj_id");
                //    Log.d("menu", "Complete");
                Intent intent = new Intent(this, DefectLogActivity.class);
                intent.putExtra("pj_id", pj_id);
                startActivity(intent);
                return true;
            case R.id.action_testreport:
                String pj_id1 = getIntent().getStringExtra("pj_id");
                Intent intent1 = new Intent(this, MainFragment.class);
                intent1.putExtra("pj_id", pj_id1);
                startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
