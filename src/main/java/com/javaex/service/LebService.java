package com.javaex.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaex.dao.LebDao;
import com.javaex.vo.KakaoToken;
import com.javaex.vo.KsbVo;
import com.javaex.vo.LebVo;
import com.javaex.vo.NaverTokenVo;
import com.javaex.vo.PjhVo;

@Service
public class LebService {

	@Autowired
	private LebDao lebDao;
	
	// (인증코드)
		public String requestToken(String code, String state) {
			String access_Token = "";
			String refresh_Token = "";

			String strUrl = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";// 토큰 요청 보낼 주소
			NaverTokenVo naverToken = new NaverTokenVo(); // 요청 받을 객체

			try {
				URL url = new URL(strUrl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();// url Http 연결 생성

				// post 요청
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);// outputStreamm으로 post 데이터를 넘김

				// 파라미터 세팅
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

				StringBuilder sb = new StringBuilder();

				// 1번 파라미터 client_id
				sb.append("&client_id=jYthT0GCru4tGxzofFp0");
				
				// 2번 파라미터 client_secret
				sb.append("&client_secret=Em4NnXdU56");

				// 3번 파라미터 redirect_uri
				sb.append("&redirect_uri=http://localhost:8080/walking/naverjoinpage");
				
				// 4번 파라미터 code
				sb.append("&code=" + code);

				// 5번 파라미터 state
				sb.append("&state=" + state);

				bw.write(sb.toString());
				bw.flush();// 실제 요청을 보내는 부분

				// 실제 요청을 보내는 부분, 결과 코드가 200이라면 성공

				int responseCode = conn.getResponseCode();
				System.out.println("responsecode(200): {}" + responseCode);

				// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = "";
				String result = "";

				while ((line = br.readLine()) != null) {
					result += line;
				}

				System.out.println("response body: {}" + result);

				ObjectMapper mapper = new ObjectMapper();

				// kakao Token에 result를 KakaoToken.class 형식으로 변환하여 저장
				naverToken = mapper.readValue(result, NaverTokenVo.class);

				System.out.println(naverToken);

				// api호출용 access token
				access_Token = naverToken.getAccess_token();

				// access 토큰 만료되면 refresh token사용(유효시간 더 김)
				refresh_Token = naverToken.getRefresh_token();

				System.out.println(access_Token);
				System.out.println(refresh_Token);

				br.close();
				bw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("네이버토큰생성완료");

			return access_Token;

		}

		public HashMap<String, String> requestUser(String accessToken, String state) {

			System.out.println("유저정보 요청 시작");

			// request를 보낼 주소
			String strUrl = "https://openapi.naver.com/v1/nid/me";

			HashMap<String, String> userInfo = new HashMap<>();

			userInfo.put("accessToken", accessToken);
			userInfo.put("state", state);

			try {

				URL url = new URL(strUrl);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // url Http 연결 생성

				// POST 요청
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);// outputStreamm으로 post 데이터를 넘

				// 전송할 header 작성, 인자로 받은 access_token전송
				conn.setRequestProperty("Authorization", "Bearer " + accessToken);

				// 실제 요청을 보내는 부분, 결과 코드가 200이라면 성공
				int responseCode = conn.getResponseCode();

				System.out.println("requestUser의 responsecode(200이면성공):{}"+ responseCode);
				
				// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
				BufferedReader br = new BufferedReader(
						new InputStreamReader(responseCode == 200 ? conn.getInputStream() : conn.getErrorStream()));

				String line = "";

				String result = "";

				while ((line = br.readLine()) != null) {
					result += line;
				}
				br.close();


				System.out.println("response body: {}"+ result);

				if (responseCode == 200) {
					// Jackson으로 json 파싱

					ObjectMapper mapper = new ObjectMapper();

					HashMap<String, Object> resultMap = mapper.readValue(result, HashMap.class);

				  HashMap<String, Object> response = (HashMap<String, Object>) resultMap.get("response");
		            String id = (String) response.get("id");
		            String nickname = (String) response.get("nickname");
		            String profile_image = (String) response.get("profile_image");
		            String email = (String) response.get("email");
					String birthyear = (String) response.get("birthyear");
		            String birthday = (String) response.get("birthday");
		            String gender = (String) response.get("gender");
		            String name = (String) response.get("name");
		            String phone_number = (String) response.get("mobile");


					userInfo.put("email", email);
					userInfo.put("id", id);
					userInfo.put("nickname", nickname);
					userInfo.put("profile_image", profile_image);
					userInfo.put("birthyear", birthyear);
					userInfo.put("birthday", birthday);
					userInfo.put("gender", gender);
					userInfo.put("name", name);
					userInfo.put("phone_number", phone_number);
				} else {
					System.out.println("Failed to get user info: {}" + result);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return userInfo;
		}
		// 네이버 자동 로그인
		public PjhVo exeNaverLogin(PjhVo users_listVo) {
			System.out.println("UserService.exeNaverLogin()");

			PjhVo authUser = lebDao.userSelscetByNaverId(users_listVo);

			return authUser;
		}
		
		
			

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int exeCourseDraw(LebVo courseVo) {
		System.out.println("lebService.exeCourseDraw()");
		int result = lebDao.courseDraw(courseVo);
		System.out.println(result);
		return result;
	}
	
	public int exeCoursePointDraw(List<LebVo> pointList) {
		System.out.println("lebService.exeCoursePointDraw()");
		for(int i=0; i<pointList.size(); i++) {
			lebDao.coursePointDraw(pointList.get(i));
		}
		return 0;
	}
	
	public int exeRecordeDraw(KsbVo courseVo) {
		System.out.println("lebService.exeCourseDraw()");
		int result = lebDao.recordDraw(courseVo);
		System.out.println(result);
		return result;
	}
	
	public int exeRecordPointDraw(List<KsbVo> pointList) {
		System.out.println("lebService.exeCoursePointDraw()");
		for(int i=0; i<pointList.size(); i++) {
			lebDao.recordPointDraw(pointList.get(i));
		}
		return 0;
	}
	

}
