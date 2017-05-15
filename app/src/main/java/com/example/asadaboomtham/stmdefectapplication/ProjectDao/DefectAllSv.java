
package com.example.asadaboomtham.stmdefectapplication.ProjectDao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DefectAllSv {

    @SerializedName("defect_sv")
    @Expose
    private List<DefectSv> defectSv = null;
    @SerializedName("title")
    @Expose
    private Title title;

    public List<DefectSv> getDefectSv() {
        return defectSv;
    }

    public void setDefectSv(List<DefectSv> defectSv) {
        this.defectSv = defectSv;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

}
