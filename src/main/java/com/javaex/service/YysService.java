package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.YysDao;
import com.javaex.vo.YysVo;

@Service
public class YysService {

	@Autowired
	private YysDao yysDao;

	// 리스트 가져오기
	public List<YysVo> exeCourseList(String category) {
		System.out.println("YysService.exeCourseList()");

		List<YysVo> coursebookList = yysDao.coursebookList(category);

		return coursebookList;
	}

}
