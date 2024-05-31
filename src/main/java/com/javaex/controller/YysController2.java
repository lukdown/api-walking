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
import com.javaex.util.JwtUtil;
import com.javaex.vo.YysVo2;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class YysController2 {

	@Autowired
	private YysService2 yysService2;

	// 과제 달성 정보
	@GetMapping(value = "/api/walking/mypage_challenge_complete")
	public JsonResult Challenge_Complete(HttpServletRequest request) {
		System.out.println("YysController2.Challenge_Complete()");
		// System.out.println(yysVo);
		int users_no = JwtUtil.getNoFromHeader(request);
		YysVo2 yysVo = yysService2.exeChallenge_Complete(users_no);

		// System.out.println(yysVo);
		return JsonResult.success(yysVo);
	}

	// 도전과제 등록
	@PostMapping(value = "/api/walking/challengeupdate")
	public int challengeupdate(@RequestBody YysVo2 yysVo) {
		System.out.println("YysController2.challengeupdate()");
		System.out.println(yysVo);

		int count = yysService2.exechallengeupdate(yysVo);

		// return count;
		return 0;
	}

	// 유저 정보
	@GetMapping(value = "/api/walking/mypage_users_info")
	public JsonResult users_Info(HttpServletRequest request) {
		System.out.println("YysController2.users_Info()");
		// System.out.println(yysVo);
		int users_no = JwtUtil.getNoFromHeader(request);
		YysVo2 yysVo = yysService2.exeUsers_Info(users_no);

		// System.out.println(yysVo);
		return JsonResult.success(yysVo);
	}

	// 도전과제 리스트
	@GetMapping(value = "/api/walking/mypage_challenge_list")
	public JsonResult challengeList(HttpServletRequest request) {
		System.out.println("YysController2.challengeList()");

		int users_no = JwtUtil.getNoFromHeader(request);
		// System.out.println(users_no);
		List<YysVo2> challengeList = yysService2.exeChallengeList(users_no);

		// System.out.println(challengeList);
		return JsonResult.success(challengeList);
	}

}
