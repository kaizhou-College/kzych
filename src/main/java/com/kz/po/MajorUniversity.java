package com.kz.po;

import java.math.BigDecimal;

public class MajorUniversity extends Major{
	/*学校编号*/
	private Long universityId;
	/*该学校对应的专业描述*/
	private String majorMessage;
	/*第3方表学校专业的编号*/
	private Long umid;
	/*学费*/
	private int cost;
	/*助学金*/
	private BigDecimal grant;
	/*学费构成*/
	private String costConstitution;
	/*就业情况*/
	private String jobInfo;
	/*学校简图*/
	private String profile;
	/*学校名称*/
	private String universityName;
	
	
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}


	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getCostConstitution() {
		return costConstitution;
	}

	public void setCostConstitution(String costConstitution) {
		this.costConstitution = costConstitution;
	}

	public String getJobInfo() {
		return jobInfo;
	}

	public void setJobInfo(String jobInfo) {
		this.jobInfo = jobInfo;
	}

	public String getMajorMessage() {
		return majorMessage;
	}

	public void setMajorMessage(String majorMessage) {
		this.majorMessage = majorMessage;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

	public Long getUmid() {
		return umid;
	}

	public void setUmid(Long umid) {
		this.umid = umid;
	}

	
	
}
