package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YdsService;
import com.javaex.util.JsonResult;
import com.javaex.vo.YdsVo;

@RestController
public class YdsController {

	@Autowired
	private YdsService ydsService;
	
		// 전체 갤러리 리스트 조회
	    @GetMapping("/api/gallery")
	    public JsonResult list() {
	        System.out.println("YdsController.list()");
	        List<YdsVo> gList = ydsService.exeAllList();
	        System.out.println(gList);
	        return JsonResult.success(gList);
	    }	


	// 다솜이꺼
}
