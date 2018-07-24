package com.kz.po;

import com.kz.core.web.BaseQueryModel;

public class MajorQuery extends BaseQueryModel {
	private Long majorCategoryId;
	
	private String name;
	
	private Integer isHot=1;
	
	private String searchText;//模糊查询的字段
	
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

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	

}
