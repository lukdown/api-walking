package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.YdsService;
import com.javaex.util.JsonResult;
import com.javaex.vo.YdsVo;

@RestController
@RequestMapping("/api")
public class YdsController {

	@Autowired
	private YdsService ydsService;

	// 전체 갤러리 리스트 조회
	@GetMapping("/gallery")
	public JsonResult list() {
		System.out.println("YdsController.list()");
		List<YdsVo> gList = ydsService.exeAllList();
		// System.out.println(gList);
		return JsonResult.success(gList);
	}
	
	 // 특정 코스별 갤러리 리스트 조회
    @GetMapping("/gallery/{courseNo}")
    public JsonResult getCourseList(@PathVariable int courseNo) {
        System.out.println("YdsController.getCourseList()");
        System.out.println(courseNo);
        List<YdsVo> cList = ydsService.getCourseList(courseNo);
        System.out.println(cList);
        return JsonResult.success(cList);
    }
    
     // 나의 코스 갤러리 리스트 조회
    @GetMapping("/mypage/gallery/{userNo}")
    public JsonResult getMyCourseList(@PathVariable int userNo) {
        System.out.println("YdsController.getMyCourseList()");
        System.out.println(userNo);
        List<YdsVo> mList = ydsService.getMyCourseList(userNo);
        System.out.println(mList);
        return JsonResult.success(mList);
    }
    
	/*
	 * // 포스팅 삭제
	 * 
	 * @DeleteMapping("/mypage/{galleryNo}") public JsonResult
	 * deleteGallery(@PathVariable int galleryNo, @RequestParam(value="userNo") int
	 * userNo) { System.out.println("YdsController.deleteGallery()");
	 * ydsService.deleteGallery(galleryNo); System.out.println("삭제되라고");
	 * System.out.println(userNo);
	 * 
	 * return JsonResult.success(galleryNo); }
	 */
    // 포스팅 삭제
    @DeleteMapping("/mypage/{galleryNo}")
    public JsonResult deleteGallery(@PathVariable int galleryNo, @RequestParam(value="userNo") int userNo) {
        System.out.println("YdsController.deleteGallery()");
        ydsService.deleteGallery(galleryNo, userNo);
        System.out.println("삭제되노");
        return JsonResult.success(galleryNo);
    }
    
    

	 // 로그인한 회원의 코스 목록 조회
	@GetMapping("/gallery/user/{userNo}/courses")
	public JsonResult listUserCourses(@PathVariable(value = "userNo") int userNo) {
		System.out.println("YdsController.listUserCourses()");
		List<YdsVo> userCourses = ydsService.exefindCoursesByUserNo(userNo);
		// System.out.println(userCourses);
		return JsonResult.success(userCourses);
	}

	// 로그인한 회원의 특정 코스 (소개 + 사진) 등록
	@PostMapping("/gallery/{userNo}/course/{courseNo}")
	public JsonResult introduceCourse(@RequestParam MultipartFile[] galleryfile, @ModelAttribute YdsVo ydsVo) {
		System.out.println("YdsController.introduceCourse()");
		// System.out.println(galleryfile.length);
		for (int i = 0; i < galleryfile.length; i++) {

			System.out.println(galleryfile[i].getOriginalFilename());

		}

		// System.out.println(ydsVo);
		ydsService.saveCourseIntroduction(galleryfile, ydsVo);// 저장 서비스
		// 호출

		return JsonResult.success("파일 업로드 성공");// return
	}

	// 선택한 코스의 상세 정보 조회
	@GetMapping("/gallery/course/{courseName}")
	public JsonResult getCourseDetails(@PathVariable(value = "courseName") String courseName) {
		System.out.println("YdsController.getCourseDetails()");
		YdsVo courseInfo = ydsService.exefindCourseInfo(courseName);
		System.out.println("courseInfo      " + courseInfo);
		return JsonResult.success(courseInfo);
	}

	// 특정 포스팅의 좋아요 수 조회
	@GetMapping("/gallery/{galleryNo}/likes")
	public JsonResult getGalleryLikes(@PathVariable int galleryNo) {
		int likeCount = ydsService.getGalleryLikes(galleryNo);
		return JsonResult.success(likeCount);
	}

	// 좋아요 추가 및 삭제
	@PostMapping("/gallery/{galleryNo}/like")
	public JsonResult likeGallery(@PathVariable int galleryNo,  @RequestBody Map<String, Integer> request) {
		 int userNo = request.get("userNo");
	     int updatedLikeCount = ydsService.likeGallery(userNo, galleryNo);
	     return JsonResult.success(updatedLikeCount);
	}
	
	

}
// 다솜이꺼
