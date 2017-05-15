
package com.example.asadaboomtham.stmdefectapplication.ProjectDao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("name_low")
    @Expose
    private String nameLow;
    @SerializedName("name_mediem")
    @Expose
    private String nameMediem;
    @SerializedName("name_high")
    @Expose
    private String nameHigh;
    @SerializedName("name_urgent")
    @Expose
    private String nameUrgent;

    public String getNameLow() {
        return nameLow;
    }

    public void setNameLow(String nameLow) {
        this.nameLow = nameLow;
    }

    public String getNameMediem() {
        return nameMediem;
    }

    public void setNameMediem(String nameMediem) {
        this.nameMediem = nameMediem;
    }

    public String getNameHigh() {
        return nameHigh;
    }

    public void setNameHigh(String nameHigh) {
        this.nameHigh = nameHigh;
    }

    public String getNameUrgent() {
        return nameUrgent;
    }

    public void setNameUrgent(String nameUrgent) {
        this.nameUrgent = nameUrgent;
    }

}
