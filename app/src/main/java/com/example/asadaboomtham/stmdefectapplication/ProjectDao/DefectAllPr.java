
package com.example.asadaboomtham.stmdefectapplication.ProjectDao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DefectAllPr {

    @SerializedName("defect_pr")
    @Expose
    private List<DefectPr> defectPr = null;
    @SerializedName("name")
    @Expose
    private Name name;

    public List<DefectPr> getDefectPr() {
        return defectPr;
    }

    public void setDefectPr(List<DefectPr> defectPr) {
        this.defectPr = defectPr;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

}
