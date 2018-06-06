package com.kz.po;

import com.kz.core.web.BaseQueryModel;

public class UniversityQuery extends BaseQueryModel  {
	
	 //默认是查询本科类学校
    private Long categoryId = 1L;
    
    private String name;
    
    
    private Integer publishStatus;
    //查询时的地址
    private String longitude;

    private String provice;

    private String city;

    private String county;

    private String addrdetail;

    private String latitude;
    
    //查看学校是否热门
    private Integer isHot;
    
    
    //专业类别
    private String majorCategoryName;
    
    //majorID
    private Long majorId;
    
    
    //univeraistyId;
    private Long universityId;
    
    //包装university
    private University university;
    //包装address
    private Address address;
    
    private String provid ;
    
    private String cityid ;
    
    private String areaid;
    
	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}

	


	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getProvice() {
		return provice;
	}

	public void setProvice(String provice) {
		this.provice = provice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddrdetail() {
		return addrdetail;
	}

	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getMajorCategoryName() {
		return majorCategoryName;
	}

	public void setMajorCategoryName(String majorCategoryName) {
		this.majorCategoryName = majorCategoryName;
	}

	public Long getMajorId() {
		return majorId;
	}

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getProvid() {
		return provid;
	}

	public void setProvid(String provid) {
		this.provid = provid;
	}

	@Override
	public String toString() {
		return "UniversityQuery [categoryId=" + categoryId + ", name=" + name + ", publishStatus=" + publishStatus
				+ ", longitude=" + longitude + ", provice=" + provice + ", city=" + city + ", county=" + county
				+ ", addrdetail=" + addrdetail + ", latitude=" + latitude + ", isHot=" + isHot + ", majorCategoryName="
				+ majorCategoryName + ", majorId=" + majorId + ", universityId=" + universityId + ", university="
				+ university + ", address=" + address + ", provid=" + provid + ", cityid=" + cityid + ", areaid="
				+ areaid + "]";
	}
	
	
}
