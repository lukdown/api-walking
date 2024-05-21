package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.YysVo;

@Repository
public class YysDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스트 가져오기
	public List<YysVo> coursebookList(String users_no) {
		System.out.println("YysDao.coursebookList()");
		// System.out.println(users_no);
		List<YysVo> coursebookList = sqlSession.selectList("yys.courseList", users_no);

		// System.out.println(coursebookList);
		return coursebookList;
	}

	// 리스트 가져오기
	public List<YysVo> coursebookfList(String users_no) {
		System.out.println("YysDao.coursebookfList()");
		// System.out.println(users_no);
		List<YysVo> coursebookfList = sqlSession.selectList("yys.coursefList", users_no);

		// System.out.println(coursebookfList);
		return coursebookfList;
	}

	// 리스트 가져오기
	public List<YysVo> coursereviewList(int course_no) {
		System.out.println("YysDao.coursereviewList()");
		System.out.println(course_no);
		List<YysVo> coursereviewList = sqlSession.selectList("yys.coursereviewList", course_no);

		System.out.println(coursereviewList);
		return coursereviewList;
	}

	// 코스 후기 저장
	public int reviewinsert(YysVo yysVo) {
		System.out.println("YysDao.reviewinsert()");

		int count = sqlSession.insert("yys.reviewinsert", yysVo);
		return count;
	}

}
