package com.kz.dao;

import org.springframework.stereotype.Repository;

import com.kz.core.dao.BaseMapper;
import com.kz.po.Address;
import com.kz.po.AddressQuery;

@Repository
public interface AddressMapper extends BaseMapper<Address,AddressQuery>{
    Long updateByUniversityKeySelective(Address a);
	
}