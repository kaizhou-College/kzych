package com.kz.po;

import java.util.Date;

import com.kz.core.po.BaseModel;

public class RecruitStudents extends BaseModel {
    private Long rsId;

    private String rsTitle;

    private Date rsDatetime;

    private String rsContent;

    private Long universityId;

    public Long getRsId() {
        return rsId;
    }

    public void setRsId(Long rsId) {
        this.rsId = rsId;
    }

    public String getRsTitle() {
        return rsTitle;
    }

    public void setRsTitle(String rsTitle) {
        this.rsTitle = rsTitle == null ? null : rsTitle.trim();
    }

    public Date getRsDatetime() {
        return rsDatetime;
    }

    public void setRsDatetime(Date rsDatetime) {
        this.rsDatetime = rsDatetime;
    }

    public String getRsContent() {
        return rsContent;
    }

    public void setRsContent(String rsContent) {
        this.rsContent = rsContent == null ? null : rsContent.trim();
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }
}