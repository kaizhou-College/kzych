package com.kz.service;

import com.kz.po.Major;
import com.kz.po.MajorUniversity;

public interface IMajorService {

	MajorUniversity findByUniversityId(int universityId, int majorId);

}
