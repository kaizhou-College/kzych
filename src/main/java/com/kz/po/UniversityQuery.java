package com.kz.po;

import com.kz.core.web.BaseQueryModel;

public class UniversityQuery extends BaseQueryModel  {
	 //默认是查询本科类学校
    private Long categoryid = 1L;
    
    private String name;
    
    private Integer publishStatus;
    //查询时的地址
    //----下拉框选中的值
    private String provid;
    private String cityid;
    private String areaid;
    //----文本输入的值
    private String search_key;
    
    
    
	public Integer getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}

	public String getProvid() {
		return provid;
	}

	public void setProvid(String provid) {
		this.provid = provid;
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

	public String getSearch_key() {
		return search_key;
	}

	public void setSearch_key(String search_key) {
		if(search_key.equals("undefined")){
			this.search_key =null;
		}else{
			this.search_key = search_key;
		}
	}

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

	@Override
	public String toString() {
		return "UniversityQuery [categoryid=" + categoryid + ", name=" + name + ", provid=" + provid + ", cityid="
				+ cityid + ", areaid=" + areaid + ", search_key=" + search_key + "]";
	}
    
}
