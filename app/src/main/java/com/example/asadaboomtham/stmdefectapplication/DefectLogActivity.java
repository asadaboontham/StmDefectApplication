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

                ArrayList<String> df_code = new ArrayList<>();
                ArrayList<String> dfs_id = new ArrayList<>();
                ArrayList<String> df_description = new ArrayList<>();
                ArrayList<String> df_dft_id = new ArrayList<>();
                ArrayList<String> df_sv_id = new ArrayList<>();
                ArrayList<String> df_pr_id = new ArrayList<>();
                ArrayList<String> df_fixed_person = new ArrayList<>();
                ArrayList<String> df_module = new ArrayList<>();
                ArrayList<String> df_step = new ArrayList<>();
                ArrayList<String> df_reference = new ArrayList<>();
                String data;

                for(int i=0; i<response.body().getSelectDefect().size(); i++){

                    if (response.body().getSelectDefect().get(i).getDfDfsId().equals("1")) {
                        data = "สถานะ : พบข้อบกพร่อง";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("2")){
                        data = "สถานะ : แจ้งผู้พัฒนา";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("3")){
                        data = "สถานะ : กำลังดำเนินการ";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("4")){
                        data = "สถานะ : แจ้งซ้ำ";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("5")){
                        data = "สถานะ : ไม่ใช่ข้อบกพร่อง";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("6")){
                        data = "สถานะ : ยังไม่ต้องแก้ไข";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("7")){
                        data = "สถานะ : ไม่ส่งผลต่อระบบ";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("8")){
                        data = "สถานะ : แก้ไขแล้ว";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("9")){
                        data = "สถานะ : ต้องการทดสอบใหม่";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("10")){
                        data = "สถานะ : กำลังทดสอบใหม่";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("11")){
                        data = "สถานะ : แจ้งผู้พัฒนาอีกครั้ง";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("12")){
                        data = "สถานะ : ยืนยันแล้ว";
                    }
                    else if(response.body().getSelectDefect().get(i).getDfDfsId().equals("13")){
                        data = "สถานะ : ปิดข้อบกพร่อง";
                    }
                    else{
                        data = "สถานะ : ยังไม่ดำเนินการ";
                    }

                    df_code.add(response.body().getSelectDefect().get(i).getDfCode());
                    dfs_id.add(data);
                    df_description.add(response.body().getSelectDefect().get(i).getDfDescription());
                    df_dft_id.add(response.body().getSelectDefect().get(i).getDfDftId());
                    df_sv_id.add(response.body().getSelectDefect().get(i).getDfSvId());
                    df_pr_id.add(response.body().getSelectDefect().get(i).getDfPrId());
                    df_fixed_person.add(response.body().getSelectDefect().get(i).getDfFixedPerson());
                    df_module.add(response.body().getSelectDefect().get(i).getDfModule());
                    df_step.add(response.body().getSelectDefect().get(i).getDfStep());
                    df_reference.add(response.body().getSelectDefect().get(i).getDfReference());
                }

                listview.setAdapter(new DefectListView(getApplicationContext(),
                        df_code,
                        dfs_id,
                        df_description,
                        df_dft_id,
                        df_sv_id,
                        df_pr_id,
                        df_fixed_person,
                        df_module,
                        df_step,
                        df_reference));
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
