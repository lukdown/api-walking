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

	// 편의시설(화장실) 리스트 가져오기
	public List<YysVo2> exeChallengeList() {
		System.out.println("YysService2.exeChallengeList()");

		List<YysVo2> challengeList = yysDao2.challengeList();

		// System.out.println(coursebookList);

		return challengeList;
	}


}
