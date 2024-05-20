package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YysService;
import com.javaex.vo.YysVo;

@RestController
public class YysController {
	
	@Autowired
	private YysService yysService;
	
	@GetMapping(value = "/api/walking/coursebooklist/{users_no}")
	public List<YysVo> list(@PathVariable("users_no") String users_no) {
		System.out.println("YysController.list()");
		//System.out.println(users_no);
		
		List<YysVo> coursebookList = yysService.exeCourseList(users_no);

		//System.out.println(coursebookList);
		return coursebookList;
		//return null;
	}
	
	@GetMapping(value = "/api/walking/coursebookflist/{users_no}")
	public List<YysVo> favoritlist(@PathVariable("users_no") String users_no) {
		System.out.println("YysController.favoritlist()");
		//System.out.println(users_no);
		
		List<YysVo> coursebookfList = yysService.exeCoursefList(users_no);

		//System.out.println(coursebookList);
		return coursebookfList;
		//return null;
	}

}
