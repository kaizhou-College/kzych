package com.kz.core.dao;

import java.io.Serializable;
import java.util.List;

import com.kz.po.User;

	
public interface BaseMapper<M, QM> {
	public Long deleteByPrimaryKey(Serializable uuid);

	public Long insert(M m);

	public Long insertSelective(M m);

	public M selectByPrimaryKey(Serializable uuid);

	public Long updateByPrimaryKeySelective(M m);

	public Long updateByPrimaryKey(M m);

	public  List<M> getByConditionPage(QM qm);
}
