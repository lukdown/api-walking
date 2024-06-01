package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.LebService;
import com.javaex.service.PjhService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.KsbVo;
import com.javaex.vo.LebVo;
import com.javaex.vo.PjhVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class LebController {

	@Autowired
	private LebService lebService;
	@Autowired
	private PjhService pjhService;
	
	//네이버 로그인
	 @GetMapping("/api/walking/naverlogin")
	    public String getNaverLoginUrl() {
	        String clientId = "jYthT0GCru4tGxzofFp0"; // 네이버 개발자센터에서 발급받은 JavaScript Key
	        String redirectUri = "http://localhost:8080/walking/naverjoinpage"; // 네이버 개발자센터에서 설정한 Callback URI
	        String state = UUID.randomUUID().toString(); // 랜덤하게 생성된 state 값

	        String url = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
	                + "&client_id=" + clientId
	                + "&state=" + state
	                + "&redirect_uri=" + redirectUri;
	        
	        System.out.println("login 컨트롤러 접근");
	        System.out.println("생성된 state 값: " + state);

	        return url;
	    }
	
	// (인증코드)
	 @PostMapping("/api/walking/naverjoinpage/{code}/{state}")
	 public HashMap<String, String> naverLogin(@PathVariable("code") String code, @PathVariable("state") String state) {

			System.out.println("code: "+code);
			System.out.println("state: "+state);
			
			// 토큰을 요청하여 얻음
			String naverToken = lebService.requestToken(code, state);
			System.out.println("네이버토큰" + naverToken);

			// 사용자 정보를 요청하여 얻음
			HashMap<String, String> map = lebService.requestUser(naverToken, state);

			System.out.println("map : " + map);


			return map;

		}
	// 네이버 회원가입(가입유저,비가입유저구별)
		@GetMapping("/api/walking/naverBysubscription/{id}")
		public JsonResult naverBysubscription(@PathVariable("id") String id) {

			String NaverId = "Naver_" + id;

			int count = pjhService.exejoinpageidcheck(NaverId);

			boolean exejoinidcheck;

			if (count == 0) {
				exejoinidcheck = false;
			} else {
				exejoinidcheck = true;
			}
			System.out.println(exejoinidcheck);
			return JsonResult.success(exejoinidcheck);
		}

		// 네이버로 회원가입하기
		@PostMapping("/api/walking/naverjoinpage")
		public JsonResult Naverjoinpage(@RequestBody PjhVo users_listVo) {
			System.out.println("LebController.Naverjoinpage()");

			String id = users_listVo.getUsers_id();
			System.out.println(id);

			users_listVo.setUsers_id("Naver_" + id);
			users_listVo.setUsers_login_type(2);

			int count = pjhService.exejoinpage(users_listVo);
			System.out.println(count);

			return JsonResult.success("");
		}
		
		// 네이버 자동 로그인
		@PostMapping("/api/walking/naverloginpage")
		public JsonResult NaverAutoLogin(@RequestBody PjhVo users_listVo, HttpServletResponse response) {

			System.out.println("sssss" + users_listVo);

			String id = users_listVo.getUsers_id();
			System.out.println(id);

			users_listVo.setUsers_id("Naver_" + id);

			PjhVo authUser = pjhService.exeApiLogin(users_listVo);

			if (authUser != null) {
				// 토큰발급 해더에 실어 보낸다
				JwtUtil.createTokenAndSetHeader(response, "" + authUser.getUsers_no());
				return JsonResult.success(authUser);
			} else {

				return JsonResult.fail("로그인실패");
			}

		}
		

	
	
	
	////////////////////////////////////////////////////////////////////////////////////////

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
