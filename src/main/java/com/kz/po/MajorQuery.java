package com.kz.po;

import com.kz.core.web.BaseQueryModel;

public class MajorQuery extends BaseQueryModel {
	private Long majorCategoryId;
	
	private String name;

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
		this.name = name;
	}
	
	

}
