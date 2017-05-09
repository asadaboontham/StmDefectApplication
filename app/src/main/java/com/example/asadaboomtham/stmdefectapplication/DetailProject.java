package com.example.asadaboomtham.stmdefectapplication;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Nutty on 10/5/2560.
 */

public class DetailProject {

    @SerializedName("pj_id")
    public int pj_id;
    @SerializedName("pj_code")
    public String pj_code;
    @SerializedName("pj_name")
    public String pj_name;
    @SerializedName("pj_detail")
    public String pj_detail;
    @SerializedName("pj_start_date")
    public Date pj_start_date;
    @SerializedName("pj_end_date")
    public Date pj_end_date;
    @SerializedName("pj_st_id")
    public int pj_st_id;
    @SerializedName("pj_sys_id")
    public int pj_sys_id;
    @SerializedName("pj_pst_id")
    public int pj_pst_id;
    @SerializedName("pj_create_date")
    public Timestamp pj_create_date;
    @SerializedName("pj_create_person")
    public int pj_create_person;
}
