package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.LebService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.LebVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LebController {

	@Autowired
	private LebService lebService;

	//CourseDraw: 코스 데이터 넣기(좌표 제외)
	@PostMapping("/api/walking/coursedraw")
	public JsonResult courseDraw(@RequestBody LebVo courseVo, HttpServletRequest request) {
		System.out.println("LebController.courseDraw()");
		System.out.println(courseVo);
		int no = JwtUtil.getNoFromHeader(request);

		if (no != -1) {
			courseVo.setUsers_no(no);
			int courseNo = lebService.exeCourseDraw(courseVo);

			return JsonResult.success(courseNo);
		} else {
			// 토큰이 없거나(로그인상태아님), 변조된 경우

			return JsonResult.fail("로그인상태아님");
		}
	}
	
	//CoursePointDraw: 코스 좌표 넣기
	@PostMapping("/api/walking/coursepointdraw")
	public JsonResult coursePointDraw(@RequestBody List<LebVo> pointList, HttpServletRequest request) {
		System.out.println("LebController.coursePointDraw()");
		System.out.println(pointList);
		int no = JwtUtil.getNoFromHeader(request);

		if (no != -1) {
			int result = lebService.exeCoursePointDraw(pointList);

			return JsonResult.success(1);
		} else {
			// 토큰이 없거나(로그인상태아님), 변조된 경우

			return JsonResult.fail("로그인상태아님");
		}
	}
}
