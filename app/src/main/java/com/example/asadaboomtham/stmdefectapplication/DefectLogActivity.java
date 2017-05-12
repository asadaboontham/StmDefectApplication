package com.example.asadaboomtham.stmdefectapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.asadaboomtham.stmdefectapplication.ProjectDao.SelectDefect;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DefectLogActivity extends AppCompatActivity {
    private LinearLayout stm_line;

    private ProjectService service;

    private ListView jsonlistView;
    private ListView listview;
    private ListView listview1;
    private ArrayList<String> exData;
    private ArrayList<String> data1;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_log);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ProjectService.class);

        String pj_id = getIntent().getStringExtra("pj_id");

        service.select_defect(pj_id).enqueue(new Callback<SelectDefect>() {
            @Override
            public void onResponse(Call<SelectDefect> call, Response<SelectDefect> response) {
                listview = (ListView) findViewById(R.id.DefectListview);

                ArrayList<String> data = new ArrayList<>();
                ArrayList<String> data1 = new ArrayList<>();
                String dfs_id;

                for(int i=0; i<response.body().getSelectDefect().size(); i++){
                    data.add(response.body().getSelectDefect().get(i).getDfCode());

                    if (response.body().getSelectDefect().get(i).getDfDfsId().equals("1")) {
                        dfs_id = "สถานะ : พบข้อบกพร่อง";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("2")){
                        dfs_id = "สถานะ : แจ้งผู้พัฒนา";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("3")){
                        dfs_id = "สถานะ : กำลังดำเนินการ";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("4")){
                        dfs_id = "สถานะ : แจ้งซ้ำ";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("5")){
                        dfs_id = "สถานะ : ไม่ใช่ข้อบกพร่อง";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("6")){
                        dfs_id = "สถานะ : ยังไม่ต้องแก้ไข";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("7")){
                        dfs_id = "สถานะ : ไม่ส่งผลต่อระบบ";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("8")){
                        dfs_id = "สถานะ : แก้ไขแล้ว";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("9")){
                        dfs_id = "สถานะ : ต้องการทดสอบใหม่";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("10")){
                        dfs_id = "สถานะ : กำลังทดสอบใหม่";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("11")){
                        dfs_id = "สถานะ : แจ้งผู้พัฒนาอีกครั้ง";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("12")){
                        dfs_id = "สถานะ : ยืนยันแล้ว";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("13")){
                        dfs_id = "สถานะ : ปิดข้อบกพร่อง";
                    }
                    else{
                        dfs_id = "สถานะ : ยังไม่ดำเนินการ";
                    }

                    data1.add(dfs_id);
                }

                listview.setAdapter(new DefectListView(getApplicationContext(), data, data1));
            }

            @Override
            public void onFailure(Call<SelectDefect> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);

    }


}
