
package com.example.asadaboomtham.stmdefectapplication.ProjectDao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Defect {

    @SerializedName("pj_id")
    @Expose
    private String pjId;
    @SerializedName("pj_code")
    @Expose
    private String pjCode;
    @SerializedName("pj_name")
    @Expose
    private String pjName;
    @SerializedName("pj_detail")
    @Expose
    private String pjDetail;
    @SerializedName("pj_start_date")
    @Expose
    private String pjStartDate;
    @SerializedName("pj_end_date")
    @Expose
    private String pjEndDate;
    @SerializedName("pj_st_id")
    @Expose
    private String pjStId;
    @SerializedName("pj_sys_id")
    @Expose
    private String pjSysId;
    @SerializedName("pj_pst_id")
    @Expose
    private String pjPstId;
    @SerializedName("pj_create_date")
    @Expose
    private String pjCreateDate;
    @SerializedName("pj_create_person")
    @Expose
    private String pjCreatePerson;

    public String getPjId() {
        return pjId;
    }

    public void setPjId(String pjId) {
        this.pjId = pjId;
    }

    public String getPjCode() {
        return pjCode;
    }

    public void setPjCode(String pjCode) {
        this.pjCode = pjCode;
    }

    public String getPjName() {
        return pjName;
    }

    public void setPjName(String pjName) {
        this.pjName = pjName;
    }

    public String getPjDetail() {
        return pjDetail;
    }

    public void setPjDetail(String pjDetail) {
        this.pjDetail = pjDetail;
    }

    public String getPjStartDate() {
        return pjStartDate;
    }

    public void setPjStartDate(String pjStartDate) {
        this.pjStartDate = pjStartDate;
    }

    public String getPjEndDate() {
        return pjEndDate;
    }

    public void setPjEndDate(String pjEndDate) {
        this.pjEndDate = pjEndDate;
    }

    public String getPjStId() {
        return pjStId;
    }

    public void setPjStId(String pjStId) {
        this.pjStId = pjStId;
    }

    public String getPjSysId() {
        return pjSysId;
    }

    public void setPjSysId(String pjSysId) {
        this.pjSysId = pjSysId;
    }

    public String getPjPstId() {
        return pjPstId;
    }

    public void setPjPstId(String pjPstId) {
        this.pjPstId = pjPstId;
    }

    public String getPjCreateDate() {
        return pjCreateDate;
    }

    public void setPjCreateDate(String pjCreateDate) {
        this.pjCreateDate = pjCreateDate;
    }

    public String getPjCreatePerson() {
        return pjCreatePerson;
    }

    public void setPjCreatePerson(String pjCreatePerson) {
        this.pjCreatePerson = pjCreatePerson;
    }

}
