package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.YysDao2;
import com.javaex.vo.YysVo2;

@Service
public class YysService2 {

	@Autowired
	private YysDao2 yysDao2;

	// 유저 정보
	public YysVo2 exeChallenge_Complete(int users_no) {
		System.out.println("YysService2.exeChallenge_Complete()");

		YysVo2 yysVo = yysDao2.challenge_complete(users_no);

		// System.out.println(coursebookList);

		return yysVo;
	}

	// 도전과제 저장
	public int exechallengeupdate(YysVo2 yysVo) {
		System.out.println("YysService2.exechallengeupdate()");

		int count = yysDao2.challengeinsert(yysVo);

		return count;
	}

	// 유저 정보
	public YysVo2 exeUsers_Info(int users_no) {
		System.out.println("YysService2.exeUsers_Info()");

		YysVo2 yysVo = yysDao2.users_Info(users_no);

		// System.out.println(coursebookList);

		return yysVo;
	}

	// 도전과제 리스트 가져오기
	public List<YysVo2> exeChallengeList(int users_no) {
		System.out.println("YysService2.exeChallengeList()");

		List<YysVo2> challengeList = yysDao2.challengeList(users_no);

		// System.out.println(coursebookList);

		return challengeList;
	}

}
