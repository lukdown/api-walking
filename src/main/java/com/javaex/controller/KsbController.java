package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.javaex.vo.PageVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class KsbController {

	// 김수빈
	@Autowired
	private KsbService ksbService;
	
	// 프로필 사진 업데이트
	@PutMapping("/api/walking/addchallenge")
	public JsonResult challengeUpdate(@RequestParam int challenge_no, @RequestParam MultipartFile file) {
		System.out.println("KsbController.challengeUpdate()");
		System.out.println(challenge_no);
		ksbService.exeChallengeUpdate(challenge_no, file);

		return JsonResult.success("성공");
	}
	
	//도전과제 리스트 가져오기
	@PostMapping("/api/gathering/getAchievementList")
	public JsonResult achievementList(HttpServletRequest request) {
		System.out.println("KsbController.achievementList()");
		
		List<KsbVo> achievementList = ksbService.exeAchievementList();
		
		return JsonResult.success(achievementList);
	}
	
	//즐겨찾기 개수 구하기
	@GetMapping("/api/walking/getfavcount")
	public JsonResult getFavCount(HttpServletRequest request) {
		
		//System.out.println("ksbController.totalWalk()");
		
		int no = JwtUtil.getNoFromHeader(request);
		
		int favCount = ksbService.exegetFavCount(no);
		
		return JsonResult.success(favCount);
	}
	
	//대표 도전과제 가져오기
	@GetMapping("/api/walking/getchallengedaepyo")
	public JsonResult getChallengeDaepyo(HttpServletRequest request) {
		//System.out.println("ksbController.getChallengeDaepyo()");
		
		int no = JwtUtil.getNoFromHeader(request);
		KsbVo daepyoInfo = ksbService.exeGetChallengeDaepyo(no);
		
		
		System.out.println("-----------");
		System.out.println(daepyoInfo);
		return JsonResult.success(daepyoInfo);
	}
	
	//소모임 수정하기
	@PutMapping("/api/gathering/modify/{small_gathering_no}")
	public JsonResult gatheringModify(HttpServletRequest request,	@RequestParam int small_gathering_no,
																	@RequestParam String small_gathering_name,
																	@RequestParam String small_gathering_host_name,
																	@RequestParam String small_gathering_hp,
																	@RequestParam int small_gathering_total_personnel,
																	@RequestParam int course_no,
																	@RequestParam String small_gathering_date,
																	@RequestParam String small_gathering_deadline,
																	@RequestParam String small_gathering_region,
																	@RequestParam String small_gathering_gender_limit,
																	@RequestParam String small_gathering_age_limit,
																	@RequestParam String small_gathering_information,
																	@RequestParam MultipartFile file) {
		System.out.println("KsbController.gatheringModify()");
		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(no);
		int count=ksbService.exeGatheringModify(
				small_gathering_no, no, course_no, small_gathering_name, small_gathering_host_name, small_gathering_hp, 
				small_gathering_total_personnel, small_gathering_date, small_gathering_deadline, small_gathering_region, 
				small_gathering_gender_limit, small_gathering_age_limit, small_gathering_information, file);
		
		return JsonResult.success(count);
		
	}
	
	//소모임 1개 불러오기
	@GetMapping("/api/gathering/modify/{small_gathering_no}")
	public JsonResult getGathering(@PathVariable int small_gathering_no) {
		System.out.println("ksbController.getGathering()");
		System.out.println(small_gathering_no);
		
		KsbVo gatheringInfo = ksbService.exeGetGathering(small_gathering_no);
		
		return JsonResult.success(gatheringInfo);
	}
	
	//소모임 등록
	@PostMapping("/api/walking/addgathering")
	public JsonResult AddGathering( HttpServletRequest request, @RequestParam String small_gathering_name,
																@RequestParam String small_gathering_host_name,
																@RequestParam String small_gathering_hp,
																@RequestParam int small_gathering_total_personnel,
																@RequestParam int course_no,
																@RequestParam String small_gathering_date,
																@RequestParam String small_gathering_deadline,
																@RequestParam String small_gathering_region,
																@RequestParam String small_gathering_gender_limit,
																@RequestParam String small_gathering_age_limit,
																@RequestParam String small_gathering_information,
																@RequestParam MultipartFile file
								   ) {
		System.out.println("KsbController.AddGathering()");
		
		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(no);
		int count=ksbService.exeAddGathering(no, course_no, small_gathering_name, small_gathering_host_name, small_gathering_hp, 
				  							small_gathering_total_personnel, small_gathering_date, small_gathering_deadline, small_gathering_region, 
				  							small_gathering_gender_limit, small_gathering_age_limit, small_gathering_information, file);
		
		
		return JsonResult.success(count);
	}
	
	//코스 리스트 가져오기
	@PostMapping("/api/gathering/courseList")
	public JsonResult courseList(HttpServletRequest request) {
		//System.out.println("KsbController.courseList()");
		
		List<KsbVo> courseList = ksbService.exeCourseList();
		
		return JsonResult.success(courseList);
	}
	
	// 리스트 가져오기
		@PostMapping(value = "/api/gathering/list")
		public JsonResult productlist(HttpServletRequest request, @RequestBody PageVo pageVo) {
			System.out.println("KsbController.gatheringList()");

			System.out.println(pageVo);
 
			// int trainer_no = JwtUtil.getNoFromHeader(request);

			Map<String, Object> gMap = ksbService.exeGatheringList(pageVo.getCrtPage(), pageVo.getKeyword());

			// return null;
			return JsonResult.success(gMap);
		}
	
	//총 걸음 수 구하기
		@GetMapping("/api/walking/totalWalk")
		public JsonResult totalWalk(HttpServletRequest request) {
			
			System.out.println("ksbController.totalWalk()");
			
			int no = JwtUtil.getNoFromHeader(request);
			
			double totalLength = ksbService.exeTotalWalk(no);
			
			return JsonResult.success(totalLength);
		}
	
	//스티커 교환하기
	@PostMapping("/api/walking/saveChallengeNo")
	public JsonResult saveChallengeNo(HttpServletRequest request, @RequestBody KsbVo ksbVo) {
	    System.out.println("ksbController.saveChallengeNo()");
	    
	    int no = JwtUtil.getNoFromHeader(request);
	    System.out.println(no);
	    System.out.println(ksbVo);
	    ksbVo.setUsers_no(no);
	    ksbService.exeChallengeUpdate(ksbVo);
	    
	    return JsonResult.success("성공");
	}

	
	//스티커 리스트 불러오기
	@GetMapping("/api/walking/mypageStickerList")
	public JsonResult StickerList(HttpServletRequest request) {
		//System.out.println("KsbController.StickerList()");
		
		int no = JwtUtil.getNoFromHeader(request);
		System.out.println(no);
		List<KsbVo> stickerList = ksbService.exeStickerList(no);
		System.out.println(stickerList);
		
		return JsonResult.success(stickerList);
	}
	
	//달력 리스트 불러오기
	@GetMapping("/api/walking/calendarList")
	public JsonResult calendarList(HttpServletRequest request) {
		//System.out.println("KsbController.calendarList()");
		
		int no = JwtUtil.getNoFromHeader(request);
		List<KsbVo> calendarList = ksbService.exeCalendarList(no);
		//System.out.println(calendarList);
		
		return JsonResult.success(calendarList);
	}

	// 기록 리스트
	@GetMapping("/api/walking/recordlist")
	public JsonResult recordList(HttpServletRequest request) {
		//System.out.println("KsbController.recordList()");
		
		int no = JwtUtil.getNoFromHeader(request);
		
		List<KsbVo> recordList = ksbService.exeRecordList(no);
		//System.out.println(recordList);
		return JsonResult.success(recordList);
	}
	
	//코스 포인트 불러오기
	@PostMapping("/api/walking/mapCoursePoint")
	public JsonResult mapCoursePoint(@RequestBody KsbVo ksbVo) {
		//System.out.println("KsbController.mapCoursePoint()");
		//System.out.println(ksbVo);
		
		List<KsbVo> coursepointList = ksbService.exeCoursePointList(ksbVo);
		//System.out.println(coursepointList);
		return JsonResult.success(coursepointList);
	}
	
	//기록 포인트 불러오기
	@PostMapping("/api/walking/mapRecordPoint")
	public JsonResult mapRecordPoint(@RequestBody KsbVo ksbVo) {
		//System.out.println("KsbController.mapRecordPoint()");
		//System.out.println(ksbVo);
		
		List<KsbVo> recordpointList = ksbService.exeRecordPointList(ksbVo);
		//System.out.println(recordpointList);
		return JsonResult.success(recordpointList);
	}
	
	//기록 리스트 1개만 불러오기
	@PostMapping("/api/walking/getSelectedRecord")
	public JsonResult getSelectedRecord(@RequestBody KsbVo ksbVo) {
		//System.out.println("KsbController.getSelectedRecord()");
		//System.out.println(ksbVo + "======================================================================");
		
		KsbVo RecordInfo = ksbService.exeGetSelectedRecord(ksbVo);
		//System.out.println(RecordInfo + "======================================================================");
		
		return JsonResult.success(RecordInfo);
	}

	// 마이페이지
	@GetMapping("/api/walking/mypage")
	public JsonResult selectMember(HttpServletRequest request) {
		//System.out.println("KsbController.selectMember()");

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
		//System.out.println("KsbController.profileUpdate()");

		ksbService.exeProfileUpdate(users_no, file);

		return JsonResult.success("성공");
	}

}
