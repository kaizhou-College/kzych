package com.kz.service;

import org.springframework.web.multipart.MultipartFile;
/**
 * @Title: IFileService.java 
 * @Package com.kz.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 凯舟.陈超  
 * @date 2018年2月8日 上午11:46:09 
 * @version V1.0
 */
public interface IFileService {
	  String upload(MultipartFile file, String path);
}
