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
    
    private String introduction;

    private String employmentInfo;

    private String brochure;

    private String schoolLicense;

    private String legalPersonName;

    private String legalPersonCard;

    private String legalPersonPhone;

    private String administratorAccount;

    private String administratorName;

    private String administratorPhone;

    private Integer userId;

    private Integer universityType;

    private Integer universityNature;
    
    private String checkedInfo;
    
    private Integer ishot;
    
    private Long introduceId;
    
    private List<Major> majors;
    
    private UniversityCategory universityCategory;
    
    private Address address;
    
    private Introduce introduce;
    
    private List<UniversityDynamic> universityDynamic;
    
    
	public String getCheckedInfo() {
		return checkedInfo;
	}

	public void setCheckedInfo(String checkedInfo) {
		this.checkedInfo = checkedInfo;
	}

	public String getSchoolLicense() {
		return schoolLicense;
	}

	public void setSchoolLicense(String schoolLicense) {
		this.schoolLicense = schoolLicense;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}

	public String getLegalPersonCard() {
		return legalPersonCard;
	}

	public void setLegalPersonCard(String legalPersonCard) {
		this.legalPersonCard = legalPersonCard;
	}

	public String getLegalPersonPhone() {
		return legalPersonPhone;
	}

	public void setLegalPersonPhone(String legalPersonPhone) {
		this.legalPersonPhone = legalPersonPhone;
	}

	public String getAdministratorAccount() {
		return administratorAccount;
	}

	public void setAdministratorAccount(String administratorAccount) {
		this.administratorAccount = administratorAccount;
	}

	public String getAdministratorName() {
		return administratorName;
	}

	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}

	public String getAdministratorPhone() {
		return administratorPhone;
	}

	public void setAdministratorPhone(String administratorPhone) {
		this.administratorPhone = administratorPhone;
	}

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUniversityType() {
		return universityType;
	}

	public void setUniversityType(Integer universityType) {
		this.universityType = universityType;
	}

	public Integer getUniversityNature() {
		return universityNature;
	}

	public void setUniversityNature(Integer universityNature) {
		this.universityNature = universityNature;
	}
	
	public Long getIntroduceId() {
		return introduceId;
	}

	public void setIntroduceId(Long introduceId) {
		this.introduceId = introduceId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Introduce getIntroduce() {
		return introduce;
	}

	public void setIntroduce(Introduce introduce) {
		this.introduce = introduce;
	}

	public UniversityCategory getUniversityCategory() {
		return universityCategory;
	}

	public void setUniversityCategory(UniversityCategory universityCategory) {
		this.universityCategory = universityCategory;
	}

	public List<UniversityDynamic> getUniversityDynamic() {
		return universityDynamic;
	}

	public void setUniversityDynamic(List<UniversityDynamic> universityDynamic) {
		this.universityDynamic = universityDynamic;
	}

	public Integer getIshot() {
		return ishot;
	}

	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}


	
	
}