package com.kz.po;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.kz.core.po.BaseModel;

public class UniversityDynamic extends BaseModel {
    private Long rsId;

    private String rsTitle;

    private Date rsDatetime;//做了get请求

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

    public String getRsDatetime() {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	String str_date = formatter.format(rsDatetime); // 将日期时间格式化
        return str_date;
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