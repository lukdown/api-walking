package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YysService;
import com.javaex.util.JsonResult;
import com.javaex.vo.YysVo;

@RestController
public class YysController {

	@Autowired
	private YysService yysService;

	// 전체 리스트
	@GetMapping(value = "/api/walking/coursebooklist/{users_no}")
	public List<YysVo> list(@PathVariable("users_no") String users_no) {
		System.out.println("YysController.list()");
		// System.out.println(users_no);

		List<YysVo> coursebookList = yysService.exeCourseList(users_no);

		// System.out.println(coursebookList);
		return coursebookList;
		// return null;
	}

	// 즐겨찾기 리스트
	@GetMapping(value = "/api/walking/coursebookflist/{users_no}")
	public List<YysVo> favoritlist(@PathVariable("users_no") String users_no) {
		System.out.println("YysController.favoritlist()");
		// System.out.println(users_no);

		List<YysVo> coursebookfList = yysService.exeCoursefList(users_no);

		// System.out.println(coursebookfList);
		return coursebookfList;
		// return null;
	}

	// 리뷰 리스트
	@GetMapping(value = "/api/walking/coursebookreviewlist/{course_no}")
	public List<YysVo> reviewlist(@PathVariable("course_no") int course_no) {
		System.out.println("YysController.reviewlist()");
		// System.out.println(course_no);

		List<YysVo> coursereviewList = yysService.exeCoursereviewList(course_no);

		// System.out.println(coursebookList);
		return coursereviewList;
		// return null;
	}

	// 리뷰 등록
	@PostMapping(value = "/api/walking/coursebookreviewupdate")
	public int reviewupdate(@RequestBody YysVo yysVo) {
		System.out.println("YysController.reviewupdate()");
		// System.out.println(yysVo);

		int count = yysService.exereviewupdate(yysVo);
		// System.out.println(guestVo);

		return count;
		// return 0;
	}

	// 즐겨찾기 상세정보
	@GetMapping(value = "/api/walking/onefavoritesinfo/{users_no}/{course_no}")
	public JsonResult onefavoritesinfo(@PathVariable("users_no") int users_no,
			@PathVariable("course_no") int course_no) {
		System.out.println("YysController.onefavoritesinfo()");

		YysVo yVo = new YysVo();
		yVo.setUsers_no(users_no);
		yVo.setCourse_no(course_no);
		System.out.println(yVo);

		YysVo yysVo = yysService.exeonefavoritesinfo(yVo);
		// System.out.println(franchiseeName);
		return JsonResult.success(yysVo);
		// return null;
	}

	// 즐겨찾기 등록
	@PostMapping(value = "/api/walking/favoritesupdatedelete")
	public int favoritesupdate(@RequestBody YysVo yysVo) {
		System.out.println("YysController.favoritesupdate()");
		// System.out.println(yysVo);

		int count = yysService.exefavoritesupdate(yysVo);
		// System.out.println(guestVo);

		return count;
		// return 0;
	}

	// 즐겨찾기 삭제
	@DeleteMapping(value = "/api/walking/favoritesupdatedelete")
	public int favoritesdelete(@RequestBody YysVo yysVo) {
		System.out.println("YysController.favoritesupdate()");
		// System.out.println(yysVo);

		int count = yysService.exefavoritesdelete(yysVo);
		// System.out.println(guestVo);

		return count;
		// return 0;
	}

	// 좋아요 등록
	@PostMapping(value = "/api/walking/likeupdatedelete")
	public int likeupdate(@RequestBody YysVo yysVo) {
		System.out.println("YysController.likeupdate()");
		// System.out.println(yysVo);

		int count = yysService.exelikeupdate(yysVo);
		// System.out.println(guestVo);

		return count;
		// return 0;
	}

	// 좋아요 삭제
	@DeleteMapping(value = "/api/walking/likeupdatedelete")
	public int likedelete(@RequestBody YysVo yysVo) {
		System.out.println("YysController.likedelete()");
		// System.out.println(yysVo);

		int count = yysService.exelikedelete(yysVo);
		// System.out.println(guestVo);

		return count;
		// return 0;
	}

}
