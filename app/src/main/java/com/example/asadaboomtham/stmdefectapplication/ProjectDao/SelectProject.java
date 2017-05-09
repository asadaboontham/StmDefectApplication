
package com.example.asadaboomtham.stmdefectapplication.ProjectDao;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SelectProject {

    @SerializedName("defect")
    @Expose
    private List<Defect> defect = null;

    public List<Defect> getDefect() {
        return defect;
    }

    public void setDefect(List<Defect> defect) {
        this.defect = defect;
    }

}
