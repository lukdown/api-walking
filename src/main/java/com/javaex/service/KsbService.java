package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.KsbDao;
import com.javaex.vo.KsbVo;

@Service
public class KsbService {
	@Autowired
	private KsbDao ksbDao;

	//수빈이꺼
	
	//마이페이지
	public KsbVo exeSelectMember(int no) {
		System.out.println("KsbService.exeSelectMember()");
		KsbVo memberInfo = ksbDao.selectMember(no);
		return memberInfo;
	}
	
	
}
