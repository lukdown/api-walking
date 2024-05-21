package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PjhService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.PjhVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PjhController {

	@Autowired
	PjhService pjhService;

	// 회원가입
	@PostMapping("/api/walking/joinpage")
	public JsonResult joinpage(@RequestBody PjhVo users_listVo) {
		System.out.println("PjhController.joinpage()");
		int count = pjhService.exejoinpage(users_listVo);
		System.out.println(count);

		return JsonResult.success("");
	}

	// id 중복체크
	@GetMapping("/api/walking/joinpageidcheck/{users_id}")
	public JsonResult joinpageidcheck(@PathVariable("users_id") String usersid) {
		System.out.println("PjhController.joinpageidcheck()");
		System.out.println(usersid);

		PjhVo userslistVo = new PjhVo();

		userslistVo.setUsers_id(usersid);

		int count = pjhService.exejoinpageidcheck(usersid);

		return JsonResult.success(count);
	}

	// 로그인
	@PostMapping("/api/walking/loginpage")
	public JsonResult login(@RequestBody PjhVo users_listVo, HttpServletResponse response) {
		System.out.println("UserController.login()");

		PjhVo authUser = pjhService.exeLogin(users_listVo);

		if (authUser != null) {
			// 토큰발급 해더에 실어 보낸다
			JwtUtil.createTokenAndSetHeader(response, "" + authUser.getUsers_no());
			return JsonResult.success(authUser);
		} else {

			return JsonResult.fail("로그인실패");
		}

	}

	// 회원정보 수정폼(1명 데이터 가져오기)
	@GetMapping("/api/walking/modify")
	public JsonResult modifyform(HttpServletRequest request) {
		System.out.println("UserController.modifyform()");

		int no = JwtUtil.getNoFromHeader(request);

		if (no != -1) {
			PjhVo users_listVo = pjhService.exeModifyForm(no);

			return JsonResult.success(users_listVo);
		} else {
			// 토큰이 없거나(로그인상태아님), 변조된 경우

			return JsonResult.fail("로그인상태아님");
		}

	}

	
}
