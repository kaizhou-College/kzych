package com.kz.dao;

import com.kz.core.dao.BaseMapper;
import com.kz.po.WxBindInfo;
import com.kz.po.WxBindInfoQuery;

public interface WxBindInfoMapper extends BaseMapper<WxBindInfo,WxBindInfoQuery> {
    WxBindInfo selectLogin(WxBindInfoQuery wx);
}