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
	public List<YysVo> exeCourseList(String users_no) {
		System.out.println("YysService.exeCourseList()");

		List<YysVo> coursebookList = yysDao.coursebookList(users_no);

		return coursebookList;
	}

	// 리스트 가져오기
	public List<YysVo> exeCoursefList(String users_no) {
		System.out.println("YysService.exeCoursefList()");

		List<YysVo> coursebookfList = yysDao.coursebookfList(users_no);

		return coursebookfList;
	}

	// 리스트 가져오기
	public List<YysVo> exeCoursereviewList(int course_no) {
		System.out.println("YysService.exeCoursereviewList()");

		List<YysVo> coursereviewList = yysDao.coursereviewList(course_no);

		return coursereviewList;
	}

	// 저장
	public int exereviewupdate(YysVo yysVo) {
		System.out.println("YysService.exereviewupdate()");

		// 등록
		int count = yysDao.reviewinsert(yysVo);

		return count;
	}
}
