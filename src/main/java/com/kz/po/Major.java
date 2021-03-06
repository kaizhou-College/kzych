package com.kz.po;

import com.kz.core.po.BaseModel;

public class Major extends BaseModel{
    private Long id;

    private Long majorCategoryId;

    private String name;

    private String majorCode;

    private Integer ishot;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMajorCategoryId() {
        return majorCategoryId;
    }

    public void setMajorCategoryId(Long majorCategoryId) {
        this.majorCategoryId = majorCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode == null ? null : majorCode.trim();
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}