package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.KsbService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.KsbVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class KsbController {

	// 김수빈
	@Autowired
	private KsbService ksbService;
	
	//달력 리스트 불러오기
	@GetMapping("/api/walking/calendarList")
	public JsonResult calendarList(HttpServletRequest request) {
		System.out.println("KsbController.calendarList()");
		
		int no = JwtUtil.getNoFromHeader(request);
		List<KsbVo> calendarList = ksbService.exeCalendarList(no);
		//System.out.println(calendarList);
		
		return JsonResult.success(calendarList);
	}

	// 기록 리스트
	@PostMapping("/api/walking/recordlist")
	public JsonResult recordList(@RequestBody KsbVo ksbVo, HttpServletRequest request) {
		System.out.println("KsbController.recordList()");
		
		int no = JwtUtil.getNoFromHeader(request);
		
		List<KsbVo> recordList = ksbService.exeRecordList(no);
		//System.out.println(recordList);
		return JsonResult.success(recordList);
	}
	
	//코스 포인트 불러오기
	@PostMapping("/api/walking/mapCoursePoint")
	public JsonResult mapCoursePoint(@RequestBody KsbVo ksbVo) {
		System.out.println("KsbController.mapCoursePoint()");
		System.out.println(ksbVo);
		
		List<KsbVo> coursepointList = ksbService.exeCoursePointList(ksbVo);
		System.out.println(coursepointList);
		return JsonResult.success(coursepointList);
	}
	
	//기록 포인트 불러오기
	@PostMapping("/api/walking/mapRecordPoint")
	public JsonResult mapRecordPoint(@RequestBody KsbVo ksbVo) {
		System.out.println("KsbController.mapRecordPoint()");
		System.out.println(ksbVo);
		
		List<KsbVo> recordpointList = ksbService.exeRecordPointList(ksbVo);
		System.out.println(recordpointList);
		return JsonResult.success(recordpointList);
	}

	// 마이페이지
	@GetMapping("/api/walking/mypage")
	public JsonResult selectMember(HttpServletRequest request) {
		System.out.println("KsbController.selectMember()");

		int no = JwtUtil.getNoFromHeader(request);
		// System.out.println(no);
		if (no != -1) {
			KsbVo memberInfo = ksbService.exeSelectMember(no);
			// System.out.println(memberInfo);
			return JsonResult.success(memberInfo);
		} else {
			// 토큰이 없거나 위조된 경우
			return JsonResult.fail("fail");
		}
	}

	// 프로필 사진 업데이트
	@PutMapping("/api/walking/mypage")
	public JsonResult profileUpdate(@RequestParam int users_no, @RequestParam MultipartFile file) {
		System.out.println("KsbController.profileUpdate()");

		ksbService.exeProfileUpdate(users_no, file);

		return JsonResult.success("성공");
	}

}
