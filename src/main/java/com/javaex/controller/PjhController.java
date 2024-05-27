package com.javaex.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	private PjhService pjhService;

	// 회원가입
	@PostMapping("/api/walking/joinpage")
	public JsonResult joinpage(@RequestBody PjhVo users_listVo) {
		System.out.println("PjhController.joinpage()");

		users_listVo.setUsers_login_type(0);

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

	// 회원정보수정
	@PutMapping("/api/walking/modify")
	public JsonResult modify(@RequestBody PjhVo users_listVo, HttpServletRequest request) {
		System.out.println("UserController.modify()");

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

	// 카카오로그인
	@GetMapping("/api/walking/kakaologin")
	public String Kakaomain() {
		String url = "https://kauth.kakao.com/oauth/authorize?client_id=10058c98eea1a5e753d74e9e41744dbd&redirect_uri=http://localhost:8080/walking/kakaojoinpage&response_type=code";
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
		System.out.println("PjhController.joinpage()");

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

		PjhVo authUser = pjhService.exeKakaoLogin(users_listVo);

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
		String url = "https://kauth.kakao.com/oauth/logout?client_id=10058c98eea1a5e753d74e9e41744dbd&logout_redirect_uri=http://localhost:8080/";
		System.out.println("logout 컨트롤러 접근");
		return url;
	}
	
	//편의시설 리스트불러오기
	@GetMapping("/api/walking/convenientlist")
	public JsonResult convenientlist(HttpServletRequest request) {
		System.out.println("PjhController.convenientlist()");

		List<PjhVo> convenient_facilities_list = pjhService.exeConvenientlist();

		System.out.println(convenient_facilities_list);

		return JsonResult.success(convenient_facilities_list);
	}
	
	//편의시설 장애시설 api 데이터 있나 비교
	@GetMapping("/api/walking/facilitieslistcomparison/{facilities_name}")
	public JsonResult facilitieslistcomparison(@PathVariable("facilities_name") String facilities_name) {
		System.out.println("PjhController.joinpageidcheck()");
		System.out.println(facilities_name);

		int count = pjhService.exefacilitieslistcomparison(facilities_name);
		
		boolean exejoinidcheck;

		if (count == 0) {
			exejoinidcheck = false;
		} else {
			exejoinidcheck = true;
		}
		
		
		return JsonResult.success(exejoinidcheck);
	}
	
	//편의시설 장애시설 api 데이터 저장
	@PostMapping("/api/walking/facilitieslistcomparisoninsert/{facilities_name}/{facilities_latitude}/{facilities_longitude}/{facilities_memo}")
	public JsonResult facilitieslistcomparisoninsert(@PathVariable("facilities_name") String facilities_name,
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
		convenient_facilities_list.setConvenient_facilities_type_no(2);
		System.out.println(convenient_facilities_list);

		int count = pjhService.exefacilitieslistcomparisoninsert(convenient_facilities_list);
		System.out.println(count);

		return JsonResult.success("");
	}
	
	//편의시설 야외운동시설 api 데이터 있나 비교
	@GetMapping("/api/walking/facilitieslistoutdoorexercise/{facilities_name}")
	public JsonResult facilitieslistoutdoorexercise(@PathVariable("facilities_name") String facilities_name) {
		System.out.println("PjhController.joinpageidcheck()");
		System.out.println(facilities_name);

		int count = pjhService.exefacilitieslistcomparison(facilities_name);
		
		boolean exejoinidcheck;

		if (count == 0) {
			exejoinidcheck = false;
		} else {
			exejoinidcheck = true;
		}
		
		
		return JsonResult.success(exejoinidcheck);
	}
	
	
	//편의시설 야외운동시설 api 데이터 저장
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
		System.out.println(convenient_facilities_list);

		int count = pjhService.exefacilitieslistcomparisoninsert(convenient_facilities_list);
		System.out.println(count);

		return JsonResult.success("");
	}
}
