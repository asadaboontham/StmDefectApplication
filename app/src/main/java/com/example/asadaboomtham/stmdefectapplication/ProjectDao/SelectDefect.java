
package com.example.asadaboomtham.stmdefectapplication.ProjectDao;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SelectDefect {

    @SerializedName("select_defect")
    @Expose
    private List<SelectDefect_> selectDefect = null;

    public List<SelectDefect_> getSelectDefect() {
        return selectDefect;
    }

    public void setSelectDefect(List<SelectDefect_> selectDefect) {
        this.selectDefect = selectDefect;
    }

}
