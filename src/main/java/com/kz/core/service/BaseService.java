package com.kz.core.service;

import java.io.Serializable;
import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kz.core.dao.BaseMapper;
import com.kz.core.po.BaseModel;
import com.kz.po.User;

public class BaseService<M, QM extends BaseModel> implements IBaseService<M,QM> {
	private BaseMapper mapper = null;
	public void setMapper(BaseMapper mapper){
		this.mapper = mapper;
	}
	public PageInfo<M> getByConditionPage(QM qm) {
		PageHelper.startPage(qm.getPageNum(),qm.getPageSize());
		List<M> list = mapper.getByConditionPage(qm);
		PageInfo<M> result = new PageInfo<M>(list);
		return result;
	}
	@Override
	public int deleteByPrimaryKey(Serializable uuid) {
		return mapper.deleteByPrimaryKey(uuid);
	}
	@Override
	public int insert(M m) {
		return mapper.insert(m);
	}
	@Override
	public int insertSelective(M m) {
		return mapper.insertSelective(m);
	}
	@Override
	public M selectByPrimaryKey(Serializable uuid) {
		return (M) mapper.selectByPrimaryKey(uuid);
	}
	@Override
	public int updateByPrimaryKeySelective(M m) {
		return mapper.updateByPrimaryKey(m);
	}
	@Override
	public int updateByPrimaryKey(M m) {
		return mapper.updateByPrimaryKey(m);
	}
}
