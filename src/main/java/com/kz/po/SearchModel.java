package com.kz.po;

public class SearchModel {
	private Long id;
	private String name;
	private Integer info;//1是学校  2是专业
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getInfo() {
		return info;
	}
	public void setInfo(Integer info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "SearchModel [id=" + id + ", name=" + name + ", info=" + info + "]";
	}
	
	
}
