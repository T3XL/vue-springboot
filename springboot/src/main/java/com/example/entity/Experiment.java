package com.example.entity;

public class Experiment {
    private String itemno;
    private String itemname;
    private String courseno;
    private Integer itemhour;
    private Integer itemtype;
    private Integer iscompulsory;

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public Integer getItemhour() {
        return itemhour;
    }

    public void setItemhour(Integer itemhour) {
        this.itemhour = itemhour;
    }

    public Integer getItemtype() {
        return itemtype;
    }

    public void setItemtype(Integer itemtype) {
        this.itemtype = itemtype;
    }

    public Integer getIscompulsory() {
        return iscompulsory;
    }

    public void setIscompulsory(Integer iscompulsory) {
        this.iscompulsory = iscompulsory;
    }
}
