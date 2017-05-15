package com.example.asadaboomtham.stmdefectapplication;

import com.example.asadaboomtham.stmdefectapplication.ProjectDao.DefectAllPr;
import com.example.asadaboomtham.stmdefectapplication.ProjectDao.DefectAllSv;
import com.example.asadaboomtham.stmdefectapplication.ProjectDao.SelectDefect;
import com.example.asadaboomtham.stmdefectapplication.ProjectDao.SelectProject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Nutty on 9/5/2560.
 */

public interface ProjectService {
    @POST("/TSP57/ISERL/application/views/stm/defect_log/android/service_project.php") //ใส่พาธข้อมูลservice
    Call<SelectProject> select_project();

    @FormUrlEncoded
    @POST("/TSP57/ISERL/application/views/stm/defect_log/android/select_defect.php")
    Call<SelectDefect> select_defect(@Field("pj_id") String pj_id);

    @FormUrlEncoded
    @POST("/TSP57/ISERL/application/views/stm/defect_log/android/graph_PieChart.php")
    Call<DefectAllSv> defect_all_sv(@Field("df_pj_id") String df_pj_id);

    @FormUrlEncoded
    @POST("/TSP57/ISERL/application/views/stm/defect_log/android/graph_BarChart.php")
    Call<DefectAllPr> defect_all_pr(@Field("df_pj_id") String df_pj_id);
}
