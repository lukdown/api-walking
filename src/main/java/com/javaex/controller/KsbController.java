package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.KsbService;
import com.javaex.vo.KsbVo;
import com.javaex.util.JsonResult;

@RestController
public class KsbController {

	//김수빈
	@Autowired
	private KsbService ksbService;
	
}
