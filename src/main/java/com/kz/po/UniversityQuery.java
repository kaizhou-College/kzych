package com.kz.po;

import com.kz.core.web.BaseQueryModel;

public class UniversityQuery extends BaseQueryModel {
	 //默认是查询本科类学校
    private Long categoryid = 1L;
    
    private String name;

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
