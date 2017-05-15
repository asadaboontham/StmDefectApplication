
package com.example.asadaboomtham.stmdefectapplication.ProjectDao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefectSv {

    @SerializedName("Low")
    @Expose
    private String low;
    @SerializedName("Mediem")
    @Expose
    private String mediem;
    @SerializedName("High")
    @Expose
    private String high;
    @SerializedName("Critical")
    @Expose
    private String critical;

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

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

}
