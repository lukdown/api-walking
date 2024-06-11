package com.javaex.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PjhService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.PjhVo;
import com.javaex.vo.YysVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@RestController
public class PjhController {

	@Autowired
	private PjhService pjhService;

	// 회원가입
	@PostMapping("/api/walking/joinpage")
	public JsonResult joinpage(@RequestBody PjhVo users_listVo) {
		System.out.println("PjhController.joinpage()");

		users_listVo.setUsers_login_type(0);

		int count = pjhService.exejoinpage(users_listVo);
		// System.out.println(count);

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
		System.out.println("PjhController.login()");

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
		System.out.println("PjhController.modifyform()");

		int no = JwtUtil.getNoFromHeader(request);

		if (no != -1) {
			PjhVo users_listVo = pjhService.exeModifyForm(no);

			return JsonResult.success(users_listVo);
		} else {
			// 토큰이 없거나(로그인상태아님), 변조된 경우

			return JsonResult.fail("로그인상태아님");
		}

	}

	// 회원정보수정
	@PutMapping("/api/walking/modify")
	public JsonResult modify(@RequestBody PjhVo users_listVo, HttpServletRequest request) {
		System.out.println("PjhController.modify()");

		System.out.println(users_listVo);

		int no = JwtUtil.getNoFromHeader(request);

		users_listVo.setUsers_no(no);

		if (no != -1) {
			// db에 수정시킨다
			pjhService.exeModify(users_listVo);

			return JsonResult.success(users_listVo.getUsers_nickname());
		} else {

			return JsonResult.fail("로그인하지않음");
		}
	}

	// 카카오로그인 시작
	@GetMapping("/api/walking/kakaologin")
	public String Kakaomain() {
		String url = "https://kauth.kakao.com/oauth/authorize?client_id=10058c98eea1a5e753d74e9e41744dbd&redirect_uri=https://www.walkingstep.site/walking/kakaojoinpage&response_type=code";
		System.out.println("login 컨트롤러 접근");
		return url;
	}

	// (인증코드)
	@GetMapping("/api/walking/kakaojoinpage/{code}")
	public HashMap<String, String> kakaoLogin(@PathVariable("code") String code) {

		System.out.println(code);

		// 토큰을 요청하여 얻음
		String kakaoToken = pjhService.requestToken(code);
		System.out.println("카카오토큰" + kakaoToken);

		// 사용자 정보를 요청하여 얻음
		HashMap<String, String> userInfo = pjhService.requestUser(kakaoToken);
		System.out.println("userIfo : " + userInfo);

		return userInfo;

	}

	// 카카오 회원가입(가입유저,비가입유저구별)
	@GetMapping("/api/walking/kakaoBysubscription/{id}")
	public JsonResult kakaoBysubscription(@PathVariable("id") String id) {

		String KakaoId = "Kakao_" + id;

		int count = pjhService.exejoinpageidcheck(KakaoId);

		boolean exejoinidcheck;

		if (count == 0) {
			exejoinidcheck = false;
		} else {
			exejoinidcheck = true;
		}
		System.out.println(exejoinidcheck);
		return JsonResult.success(exejoinidcheck);
	}

	// 카카오로 회원가입하기
	@PostMapping("/api/walking/Kakaojoinpage")
	public JsonResult Kakaojoinpage(@RequestBody PjhVo users_listVo) {
		System.out.println("PjhController.Kakaojoinpage()");

		String id = users_listVo.getUsers_id();
		System.out.println(id);

		users_listVo.setUsers_id("Kakao_" + id);
		users_listVo.setUsers_login_type(1);

		int count = pjhService.exejoinpage(users_listVo);
		System.out.println(count);

		return JsonResult.success("");
	}

	// 카카오 자동 로그인
	@PostMapping("/api/walking/Kakaologinpage")
	public JsonResult kakaoAutoLogin(@RequestBody PjhVo users_listVo, HttpServletResponse response) {

		System.out.println("sssss" + users_listVo);

		String id = users_listVo.getUsers_id();
		System.out.println(id);

		users_listVo.setUsers_id("Kakao_" + id);

		PjhVo authUser = pjhService.exeApiLogin(users_listVo);

		if (authUser != null) {
			// 토큰발급 해더에 실어 보낸다
			JwtUtil.createTokenAndSetHeader(response, "" + authUser.getUsers_no());
			return JsonResult.success(authUser);
		} else {

			return JsonResult.fail("로그인실패");
		}

	}

	// 카카오로그아웃
	@GetMapping("/api/walking/kakaologout")
	public String Kakaologout() {
		String url = "https://kauth.kakao.com/oauth/logout?client_id=10058c98eea1a5e753d74e9e41744dbd&logout_redirect_uri=https://www.walkingstep.site/";
		System.out.println("logout 컨트롤러 접근");
		return url;
	}

	// 편의시설 리스트불러오기
	@GetMapping("/api/walking/convenientlist")
	public JsonResult convenientlist(HttpServletRequest request) {
		System.out.println("PjhController.convenientlist()");

		List<PjhVo> convenient_facilities_list = pjhService.exeConvenientlist();

		// System.out.println(convenient_facilities_list);

		return JsonResult.success(convenient_facilities_list);
	}

	// 편의시설 장애시설 api 데이터 있나 비교
	@GetMapping("/api/walking/facilitieslistcomparison/{facilities_name}")
	public JsonResult facilitieslistcomparison(@PathVariable("facilities_name") String facilities_name) {
		System.out.println("PjhController.facilitieslistcomparison()");
		// System.out.println(facilities_name);

		int count = pjhService.exefacilitieslistcomparison(facilities_name);

		boolean exejoinidcheck;

		if (count == 0) {
			exejoinidcheck = false;
		} else {
			exejoinidcheck = true;
		}

		return JsonResult.success(exejoinidcheck);
	}

	// 편의시설 장애시설 api 데이터 저장
	@PostMapping("/api/walking/facilitieslistcomparisoninsert/{facilities_name}/{facilities_latitude}/{facilities_longitude}/{facilities_memo}")
	public JsonResult facilitieslistcomparisoninsert(@PathVariable("facilities_name") String facilities_name,
			@PathVariable("facilities_latitude") double facilities_latitude,
			@PathVariable("facilities_longitude") double facilities_longitude,
			@PathVariable("facilities_memo") String facilities_memo) {
		System.out.println("PjhController.facilitieslistcomparisoninsert()");

		PjhVo convenient_facilities_list = new PjhVo();

		convenient_facilities_list.setFacilities_name(facilities_name);
		convenient_facilities_list.setFacilities_latitude(facilities_latitude);
		convenient_facilities_list.setFacilities_longitude(facilities_longitude);
		convenient_facilities_list.setFacilities_memo(facilities_memo);
		convenient_facilities_list.setUsers_no(1);
		convenient_facilities_list.setConvenient_facilities_type_no(2);
		// System.out.println(convenient_facilities_list);

		int count = pjhService.exefacilitieslistcomparisoninsert(convenient_facilities_list);
		// System.out.println(count);

		return JsonResult.success("");
	}

	// 편의시설 야외운동시설 api 데이터 있나 비교
	@GetMapping("/api/walking/facilitieslistoutdoorexercise/{facilities_name}")
	public JsonResult facilitieslistoutdoorexercise(@PathVariable("facilities_name") String facilities_name) {
		System.out.println("PjhController.facilitieslistoutdoorexercise()");
		// System.out.println(facilities_name);

		int count = pjhService.exefacilitieslistcomparison(facilities_name);

		boolean exejoinidcheck;

		if (count == 0) {
			exejoinidcheck = false;
		} else {
			exejoinidcheck = true;
		}

		return JsonResult.success(exejoinidcheck);
	}

	// 편의시설 야외운동시설 api 데이터 저장
	@PostMapping("/api/walking/facilitieslistoutdoorexerciseinsert/{facilities_name}/{facilities_latitude}/{facilities_longitude}/{facilities_memo}")
	public JsonResult facilitieslistoutdoorexerciseinsert(@PathVariable("facilities_name") String facilities_name,
			@PathVariable("facilities_latitude") double facilities_latitude,
			@PathVariable("facilities_longitude") double facilities_longitude,
			@PathVariable("facilities_memo") String facilities_memo) {
		System.out.println("PjhController.joinpage()");

		PjhVo convenient_facilities_list = new PjhVo();

		convenient_facilities_list.setFacilities_name(facilities_name);
		convenient_facilities_list.setFacilities_latitude(facilities_latitude);
		convenient_facilities_list.setFacilities_longitude(facilities_longitude);
		convenient_facilities_list.setFacilities_memo(facilities_memo);
		convenient_facilities_list.setUsers_no(1);
		convenient_facilities_list.setConvenient_facilities_type_no(3);
		// System.out.println(convenient_facilities_list);

		int count = pjhService.exefacilitieslistcomparisoninsert(convenient_facilities_list);
		// System.out.println(count);

		return JsonResult.success("");
	}

	// 편의시설 유저가 화장실 등록
	@PostMapping("/api/walking/toiletinsert")
	public JsonResult toiletinsert(@RequestBody PjhVo convenient_facilities_list) {
		System.out.println("PjhController.toiletinsert()");

		convenient_facilities_list.setUsers_no(1);
		convenient_facilities_list.setConvenient_facilities_type_no(1);
		// System.out.println(convenient_facilities_list);

		int count = pjhService.exefacilitieslistcomparisoninsert(convenient_facilities_list);
		// System.out.println(count);

		return JsonResult.success("화장실 등록완료");
	}

	// 편의시설 유저가 장애복지관 등록
	@PostMapping("/api/walking/DisabledWelfareCenterinsert")
	public JsonResult DisabledWelfareCenterinsert(@RequestBody PjhVo convenient_facilities_list) {
		System.out.println("PjhController.DisabledWelfareCenterinsert()");

		convenient_facilities_list.setUsers_no(1);
		convenient_facilities_list.setConvenient_facilities_type_no(2);
		// System.out.println(convenient_facilities_list);

		int count = pjhService.exefacilitieslistcomparisoninsert(convenient_facilities_list);
		// System.out.println(count);

		return JsonResult.success("장애복지관 등록완료");
	}

	// 편의시설 유저가 야외운동시설 등록
	@PostMapping("/api/walking/OutdoorExerciseFacilitiesinsert")
	public JsonResult OutdoorExerciseFacilitiesinsert(@RequestBody PjhVo convenient_facilities_list) {
		System.out.println("PjhController.OutdoorExerciseFacilitiesinsert()");

		convenient_facilities_list.setUsers_no(1);
		convenient_facilities_list.setConvenient_facilities_type_no(3);
		// System.out.println(convenient_facilities_list);

		int count = pjhService.exefacilitieslistcomparisoninsert(convenient_facilities_list);
		// System.out.println(count);

		return JsonResult.success(" 등록완료");
	}

	// 구글 로그인 시작

	@GetMapping("/api/walking/googlelogin")
	public String Googlemain() {
		String url = "https://accounts.google.com/o/oauth2/v2/auth?client_id=17637626061-ss04i67obe0couopq08tu72i1efjil82.apps.googleusercontent.com&redirect_uri=https://www.walkingstep.site/walking/googlejoinpage&response_type=code&scope=email profile https://www.googleapis.com/auth/user.gender.read https://www.googleapis.com/auth/user.birthday.read https://www.googleapis.com/auth/userinfo.profile";
		System.out.println("googlelogin 컨트롤러 접근");
		return url;
	}

	// (인증코드)
	@PostMapping("/api/walking/googlejoinpage")
	public HashMap<String, String> googleLogin(@RequestBody String code) {

		System.out.println(code);

		// 토큰을 요청하여 얻음
		String googleToken = pjhService.googleRequestToken(code);
		System.out.println("구글토큰: " + googleToken);

		// 사용자 정보를 요청하여 얻음
		HashMap<String, String> userInfo = pjhService.googleRequestUser(googleToken);
		System.out.println("userInfo: " + userInfo);

		return userInfo;

	}

	// 구글 회원비회원 구별
	@GetMapping("/api/walking/googleBysubscription/{id}")
	public JsonResult googleBysubscription(@PathVariable("id") String id) {
		System.out.println("PjhController.googleBysubscription()");

		String Google = "Google_" + id;

		int count = pjhService.exejoinpageidcheck(Google);

		boolean exejoinidcheck;

		if (count == 0) {
			exejoinidcheck = false;
		} else {
			exejoinidcheck = true;
		}
		System.out.println(exejoinidcheck);
		return JsonResult.success(exejoinidcheck);
	}

	// 구글로 회원가입하기
	@PostMapping("/api/walking/Googlejoinpage")
	public JsonResult Googlejoinpage(@RequestBody PjhVo users_listVo) {
		System.out.println("PjhController.Googlejoinpage()");

		String id = users_listVo.getUsers_id();
		System.out.println(id);

		users_listVo.setUsers_id("Google_" + id);
		users_listVo.setUsers_login_type(3);

		int count = pjhService.exejoinpage(users_listVo);
		System.out.println(count);

		return JsonResult.success("");
	}

	@PostMapping("/api/walking/Googleloginpage")
	public JsonResult googleAutoLogin(@RequestBody PjhVo users_listVo, HttpServletResponse response) {

		System.out.println("sssss" + users_listVo);

		String id = users_listVo.getUsers_id();
		System.out.println(id);

		users_listVo.setUsers_id("Google_" + id);

		PjhVo authUser = pjhService.exeApiLogin(users_listVo);

		if (authUser != null) {
			// 토큰발급 해더에 실어 보낸다
			JwtUtil.createTokenAndSetHeader(response, "" + authUser.getUsers_no());
			return JsonResult.success(authUser);
		} else {

			return JsonResult.fail("로그인실패");
		}

	}

	// 소모임 읽기페이지
	@GetMapping("/api/walking/getSmallGatheringDetailData/{small_gathering_no}")
	public JsonResult getSmallGatheringDetailData(@PathVariable("small_gathering_no") int smallgatheringno,
			HttpServletRequest request) {
		System.out.println("PjhController.getSmallGatheringDetailData()");
		int login_users_no = JwtUtil.getNoFromHeader(request);
		// System.out.println(login_users_no);

		PjhVo smallgatheringVo = pjhService.exegetSmallGatheringDetailData(smallgatheringno, login_users_no);
		System.out.println(smallgatheringVo);

		return JsonResult.success(smallgatheringVo);
	}

	// 소모임 삭제
	@DeleteMapping(value = "/api/walking/smallgatheringupdatedelete")
	public int smallgatherdelete(@RequestBody PjhVo pjhVo) {
		System.out.println("PjhController.smallgatherdelete()");
		// System.out.println(yysVo);

		int count = pjhService.exesmallgatherdelete(pjhVo);
		// System.out.println(guestVo);

		// return count;
		return count;
	}

	// 소모임 신청
	@PostMapping(value = "/api/walking/applicationupdatedelete")
	public int applicationupdate(@RequestBody PjhVo pjhVo) {
		System.out.println("PjhController.applicationupdate()");
		System.out.println(pjhVo);

		int count = pjhService.exeapplicationupdate(pjhVo);
		// System.out.println(guestVo);

		return count;
		// return 0;
	}

	// 소모임 신청 취소
	@DeleteMapping(value = "/api/walking/applicationupdatedelete")
	public int applicationdelete(@RequestBody PjhVo pjhVo) {
		System.out.println("PjhController.applicationdelete()");
		System.out.println(pjhVo);

		int count = pjhService.exeapplicationdelete(pjhVo);
		// System.out.println(guestVo);

		return count;
		// return 0;
	}

	// 소모임 신청 리스트
	@PostMapping("/api/walking/small_app_list")
	public JsonResult small_app_List(@RequestBody PjhVo pjhVo) {
		System.out.println("PjhController.small_app_List()");

		// System.out.println(pjhVo);
		List<PjhVo> s_l_List = pjhService.exeSmall_app_List(pjhVo.getSmall_gathering_no());

		return JsonResult.success(s_l_List);
		// return JsonResult.success(null);
	}

	// 소모임 신청 수락
	@PutMapping(value = "/api/walking/small_app_modify")
	public int small_app_modify(@RequestBody PjhVo pjhVo) {
		System.out.println("PjhController.small_app_modify()");
		// System.out.println(yysVo);

		int count = pjhService.exeSmall_app_modify(pjhVo);
		// System.out.println(guestVo);

		return count;
		// return 0;
	}

	// 소모임 신청 확인
	@PostMapping("/api/walking/small_app_check")
	public JsonResult small_app_check(@RequestBody PjhVo pjhVo) {
		System.out.println("PjhController.small_app_check()");

		PjhVo pVo = pjhService.exeSmall_app_Check(pjhVo);
		System.out.println("//////////////////////");
		System.out.println(pVo);
		System.out.println("//////////////////////");

		return JsonResult.success(pVo);
		//return JsonResult.success(null);
	}

}
