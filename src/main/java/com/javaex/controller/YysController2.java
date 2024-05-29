package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YysService2;
import com.javaex.util.JsonResult;
import com.javaex.vo.YysVo2;

@RestController
public class YysController2 {

	@Autowired
	private YysService2 yysService2;

	// 도전과제 리스트
	@GetMapping(value = "/api/walking/mypage_challenge_list")
	public JsonResult challengeList() {
		System.out.println("YysController2.challengeList()");
		// System.out.println(yysVo);

		List<YysVo2> challengeList = yysService2.exeChallengeList();

		// System.out.println(coursebookList);
		return JsonResult.success(challengeList);
	}


}
