package com.kz.core.dao;

import java.io.Serializable;
import java.util.List;

import com.kz.po.User;

public interface BaseMapper<M, QM> {
	
	public int deleteByPrimaryKey(Serializable uuid);

	public int insert(M m);

	public int insertSelective(M m);

	public M selectByPrimaryKey(Serializable uuid);

	public int updateByPrimaryKeySelective(M m);

	public int updateByPrimaryKey(M m);

	public  List<M> getByConditionPage(QM qm);
}
