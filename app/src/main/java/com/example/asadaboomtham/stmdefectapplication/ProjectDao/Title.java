
package com.example.asadaboomtham.stmdefectapplication.ProjectDao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("title_low")
    @Expose
    private String titleLow;
    @SerializedName("title_mediem")
    @Expose
    private String titleMediem;
    @SerializedName("title_high")
    @Expose
    private String titleHigh;
    @SerializedName("title_critical")
    @Expose
    private String titleCritical;

    public String getTitleLow() {
        return titleLow;
    }

    public void setTitleLow(String titleLow) {
        this.titleLow = titleLow;
    }

    public String getTitleMediem() {
        return titleMediem;
    }

    public void setTitleMediem(String titleMediem) {
        this.titleMediem = titleMediem;
    }

    public String getTitleHigh() {
        return titleHigh;
    }

    public void setTitleHigh(String titleHigh) {
        this.titleHigh = titleHigh;
    }

    public String getTitleCritical() {
        return titleCritical;
    }

    public void setTitleCritical(String titleCritical) {
        this.titleCritical = titleCritical;
    }

}
