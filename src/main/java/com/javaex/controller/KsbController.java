package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.KsbService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.KsbVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class KsbController {

	//김수빈
	@Autowired
	private KsbService ksbService;
	
	//마이페이지
	@GetMapping("/api/walking/mypage")
	public JsonResult selectMember(HttpServletRequest request) {
		System.out.println("KsbController.selectMember()");
		
		int no = JwtUtil.getNoFromHeader(request);
		//System.out.println(no);
		if(no != -1) {
			KsbVo memberInfo = ksbService.exeSelectMember(no);
			//System.out.println(memberInfo);
			return JsonResult.success(memberInfo);
		}else {
			//토큰이 없거나 위조된 경우
			return JsonResult.fail("fail");
		}
	}
	
}
