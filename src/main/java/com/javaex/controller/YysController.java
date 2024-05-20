package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YysService;
import com.javaex.vo.YysVo;

@RestController
public class YysController {
	
	@Autowired
	private YysService yysService;
	
	@GetMapping(value = "/api/walking/coursebooklist")
	public List<YysVo> list() {
		System.out.println("YysController.list()");

		List<YysVo> coursebookList = yysService.exeCourseList();

		System.out.println(coursebookList);
		return coursebookList;
		//return null;
	}

}
