package com.kz.po;

import java.math.BigDecimal;
import java.util.List;

import com.kz.core.po.BaseModel;

public class University extends BaseModel{
    private Long id;

    private Long code;

    private String profile;

    private String agreements;

    private String telephone;

    private BigDecimal grants;

    private BigDecimal coupon;
    //默认是查询本科类学校
    private Long categoryid = 1L;

    private Integer publishStatus;
    
    private String name;

    private String address;

    private String employmentInfo;

    private String brochure;

    private String introduction;
    
    private List<Major> majors;

    
    
    public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmploymentInfo() {
        return employmentInfo;
    }

    public void setEmploymentInfo(String employmentInfo) {
        this.employmentInfo = employmentInfo == null ? null : employmentInfo.trim();
    }

    public String getBrochure() {
        return brochure;
    }

    public void setBrochure(String brochure) {
        this.brochure = brochure == null ? null : brochure.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

    public String getAgreements() {
        return agreements;
    }

    public void setAgreements(String agreements) {
        this.agreements = agreements == null ? null : agreements.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public BigDecimal getGrants() {
        return grants;
    }

    public void setGrants(BigDecimal grants) {
        this.grants = grants;
    }

    public BigDecimal getCoupon() {
		return coupon;
	}

	public void setCoupon(BigDecimal coupon) {
		this.coupon = coupon;
	}

	public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }
}