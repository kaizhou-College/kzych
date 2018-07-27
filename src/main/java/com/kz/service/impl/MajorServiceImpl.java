package com.kz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kz.core.service.BaseService;
import com.kz.dao.MajorCategoryMapper;
import com.kz.dao.MajorMapper;
import com.kz.dao.UniversityMapper;
import com.kz.po.Major;
import com.kz.po.MajorCategory;
import com.kz.po.MajorCategoryQuery;
import com.kz.po.MajorQuery;
import com.kz.po.MajorUniversity;
import com.kz.po.SearchModel;
import com.kz.po.University;
import com.kz.service.IMajorService;

@Service
@Transactional
public class MajorServiceImpl extends BaseService<Major, MajorQuery> implements IMajorService {
	
	private MajorMapper mapper;
	
	@Autowired
	public void setMapper(MajorMapper mapper) {
		this.mapper =mapper;
		super.setMapper(mapper);
	}
	
	@Autowired
	private UniversityMapper universityMap;
	
	@Override
	public MajorUniversity findByUniversityId(int universityId, int majorId) {
		return mapper.findByUniversityId(universityId,majorId);
	}
	@Autowired
	private MajorCategoryMapper mapperMC;
	
	@Override
	public PageInfo<MajorCategory> majorCategorylist(MajorCategoryQuery qm) {
		PageHelper.startPage(qm.getPageNum(),qm.getPageSize());
		List<MajorCategory> list=mapperMC.getByConditionPage(qm);
		PageInfo<MajorCategory> result = new PageInfo<MajorCategory>(list);
		return result;
	}
	@Override
	public PageInfo myMajorHot(MajorQuery qm) {
		PageHelper.startPage(qm.getPageNum(),qm.getPageSize());
		List<Major> majorList= mapper.myMajorHot(qm.getIsHot());
		PageInfo<Major> result=new PageInfo<Major>(majorList);
		return result;
	}
	
	@Override
	public PageInfo majorAndUniversityDim(MajorQuery qm) {
		List<SearchModel> majorList= mapper.majorByNameDim(qm);
		List<SearchModel> universityList= universityMap.universityByNameDim(qm);
		//用来接收学校和专业的总数据
		List<SearchModel> result=new ArrayList<>(0);
		for (int i = 0; i < majorList.size(); i++) {
			SearchModel sm=new SearchModel();
			sm.setId(majorList.get(i).getId());
			sm.setName(majorList.get(i).getName());
			sm.setInfo(2);
			result.add(sm);
		}
		int universityNum=0;
		for(int i=majorList.size();i<majorList.size()+universityList.size();i++){
			SearchModel sm=new SearchModel();
			sm.setId(universityList.get(universityNum).getId());
			sm.setName(universityList.get(universityNum).getName());
			sm.setInfo(1);
			result.add(sm);
			universityNum++;
		}
		//再定义一个ArrayList来接收分页后的数据
		List<SearchModel> pageSearch=new ArrayList<>(0);
		if(result.size()>((qm.getPageNum()-1)*qm.getPageSize())){
			for(int i=((qm.getPageNum()-1)*qm.getPageSize());
					i<qm.getPageNum()*qm.getPageSize();i++){
				if(result.size()<=i){
					break;
				}
				pageSearch.add(result.get(i));
			}
		}
		PageInfo<SearchModel> pageInfo=new PageInfo<SearchModel>(pageSearch);
		return pageInfo;
	}
	@Override
	public PageInfo majorTyleIdSearch(MajorQuery qm) {
		List<Major> majorTypeList=mapper.majorTyleIdSearch(qm);
		PageInfo<Major> pageInfo=new PageInfo<Major>(majorTypeList);
		return pageInfo;
	}

}
