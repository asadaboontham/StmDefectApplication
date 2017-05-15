
package com.example.asadaboomtham.stmdefectapplication.ProjectDao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefectPr {

    @SerializedName("Low")
    @Expose
    private String low;
    @SerializedName("Mediem")
    @Expose
    private String mediem;
    @SerializedName("High")
    @Expose
    private String high;
    @SerializedName("Urgent")
    @Expose
    private String urgent;

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getMediem() {
        return mediem;
    }

    public void setMediem(String mediem) {
        this.mediem = mediem;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }

}
