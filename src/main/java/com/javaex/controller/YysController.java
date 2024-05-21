package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YysService;
import com.javaex.vo.YysVo;

@RestController
public class YysController {
	
	@Autowired
	private YysService yysService;
	
	// 전체 리스트
	@GetMapping(value = "/api/walking/coursebooklist/{users_no}")
	public List<YysVo> list(@PathVariable("users_no") String users_no) {
		System.out.println("YysController.list()");
		//System.out.println(users_no);
		
		List<YysVo> coursebookList = yysService.exeCourseList(users_no);

		//System.out.println(coursebookList);
		return coursebookList;
		//return null;
	}
	
	// 즐겨찾기 리스트
	@GetMapping(value = "/api/walking/coursebookflist/{users_no}")
	public List<YysVo> favoritlist(@PathVariable("users_no") String users_no) {
		System.out.println("YysController.favoritlist()");
		//System.out.println(users_no);
		
		List<YysVo> coursebookfList = yysService.exeCoursefList(users_no);

		//System.out.println(coursebookList);
		return coursebookfList;
		//return null;
	}
	
	// 리뷰 리스트
	@GetMapping(value = "/api/walking/coursebookreviewlist/{course_no}")
	public List<YysVo> reviewlist(@PathVariable("course_no") int course_no) {
		System.out.println("YysController.reviewlist()");
		System.out.println(course_no);
		
		List<YysVo> coursereviewList = yysService.exeCoursereviewList(course_no);

		//System.out.println(coursebookList);
		return coursereviewList;
		//return null;
	}
	
	// 리뷰 등록
	@PostMapping(value = "/api/walking/coursebookreviewupdate")
	public int reviewupdate(@RequestBody YysVo yysVo) {
		System.out.println("YysController.reviewupdate()");
		System.out.println(yysVo);

		int count = yysService.exereviewupdate(yysVo);
		//System.out.println(guestVo);
		
		return count;
		//return 0;
	}
	
}
