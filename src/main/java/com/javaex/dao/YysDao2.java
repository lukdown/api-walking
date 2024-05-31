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

	// 유저 정보
	public YysVo2 challenge_complete(int users_no) {
		System.out.println("YysDao2.challenge_complete()");

		// System.out.println(yysVo);
		YysVo2 yysVo = sqlSession.selectOne("yys2.challenge_complete", users_no);

		// System.out.println(challengeList);
		return yysVo;
	}

	// 도전과제 저장
	public int challengeinsert(YysVo2 yysVo) {
		System.out.println("YysDao2.challengeinsert()");

		int count = sqlSession.insert("yys2.challengeinsert", yysVo);

		return count;
	}

	// 유저 정보
	public YysVo2 users_Info(int users_no) {
		System.out.println("YysDao2.users_Info()");

		// System.out.println(yysVo);
		YysVo2 yysVo = sqlSession.selectOne("yys2.users_Info", users_no);

		// System.out.println(challengeList);
		return yysVo;
	}

	// 도전과제 가져오기
	public List<YysVo2> challengeList(int users_no) {
		System.out.println("YysDao2.challengeList()");

		// System.out.println(yysVo);
		List<YysVo2> challengeList = sqlSession.selectList("yys2.challengeList", users_no);

		// System.out.println(challengeList);
		return challengeList;
	}

}
