package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.LebService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.KsbVo;
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
		System.out.println(courseVo.getCourse_region());
		System.out.println(courseVo);
		int no = JwtUtil.getNoFromHeader(request);

		if (no != -1) {
			courseVo.setUsers_no(no);
			lebService.exeCourseDraw(courseVo);
			System.out.println(courseVo.getCourse_no());
			return JsonResult.success(courseVo.getCourse_no());
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

			return JsonResult.success(result);
		} else {
			// 토큰이 없거나(로그인상태아님), 변조된 경우

			return JsonResult.fail("로그인상태아님");
		}
	}
	
	//RecordDraw: 코스 데이터 넣기(좌표 제외)
		@PostMapping("/api/walking/recorddraw")
		public JsonResult recordDraw(@RequestBody KsbVo recordVo, HttpServletRequest request) {
			System.out.println("LebController.recordDraw()");
			System.out.println(recordVo);
			int no = JwtUtil.getNoFromHeader(request);

			if (no != -1) {
				recordVo.setUsers_no(no);
				System.out.println(recordVo.getUsers_no());
				lebService.exeRecordeDraw(recordVo);
				
				return JsonResult.success(recordVo.getRecord_no());
			} else {
				// 토큰이 없거나(로그인상태아님), 변조된 경우

				return JsonResult.fail("로그인상태아님");
			}
		}
		
		//RecordPointDraw: 코스 좌표 넣기
		@PostMapping("/api/walking/recordpointdraw")
		public JsonResult recordPointDraw(@RequestBody List<KsbVo> pointList, HttpServletRequest request) {
			System.out.println("LebController.recordPointDraw()");
			
			int no = JwtUtil.getNoFromHeader(request);

			if (no != -1) {
				System.out.println(pointList);
				int result = lebService.exeRecordPointDraw(pointList);

				return JsonResult.success(result);
			} else {
				// 토큰이 없거나(로그인상태아님), 변조된 경우

				return JsonResult.fail("로그인상태아님");
			}
		}
}
