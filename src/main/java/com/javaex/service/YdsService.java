package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.YdsDao;
import com.javaex.vo.YdsVo;

@Service
public class YdsService {

	@Autowired
	private YdsDao ydsDao;
	
	// 리스트
		public List<YdsVo> exeAllList() {
			System.out.println("YdsService.exeAllList()");

			List<YdsVo> gList = ydsDao.selectList();

			return gList;
		}
	
	

	// 다솜이꺼
}
