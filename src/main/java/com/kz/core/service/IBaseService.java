package com.kz.core.service;

import java.io.Serializable;

import com.github.pagehelper.PageInfo;
import com.kz.core.po.BaseModel;
import com.kz.po.User;

public interface IBaseService<M,QM extends BaseModel> {
	
	public int deleteByPrimaryKey(Serializable uuid);

	public int insert(M m);

	public int insertSelective(M m);

	public M selectByPrimaryKey(Serializable uuid);

	public int updateByPrimaryKeySelective(M m);

	public int updateByPrimaryKey(M m);

	public PageInfo<M> getByConditionPage(QM qm);
	
}
