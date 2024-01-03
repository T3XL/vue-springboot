package com.example.entity;

public class Course {
    private String courseno;
    private String coursename;
    private Integer credit;
    private Integer credithour;
    private Integer coursetype;
    private Integer experimenttype;

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getCredithour() {
        return credithour;
    }

    public void setCredithour(Integer credithour) {
        this.credithour = credithour;
    }

    public Integer getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(Integer coursetype) {
        this.coursetype = coursetype;
    }

    public Integer getExperimenttype() {
        return experimenttype;
    }

    public void setExperimenttype(Integer experimenttype) {
        this.experimenttype = experimenttype;
    }
}
