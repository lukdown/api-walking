package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.YysVo2;

@Repository
public class YysDao2 {

	@Autowired
	private SqlSession sqlSession;

	// 편의시설(화장실)리스트 가져오기
	public List<YysVo2> challengeList() {
		System.out.println("YysDao2.challengeList()");

		// System.out.println(yysVo);
		List<YysVo2> challengeList = sqlSession.selectList("yys2.challengeList");

		//System.out.println(facilitiesList);
		return challengeList;
	}

}
