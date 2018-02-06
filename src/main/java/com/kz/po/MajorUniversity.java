package com.kz.po;

public class MajorUniversity extends Major{
	private int universityId;
	private String majorMessage;

	public String getMajorMessage() {
		return majorMessage;
	}

	public void setMajorMessage(String majorMessage) {
		this.majorMessage = majorMessage;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	
}
