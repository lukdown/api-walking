package com.javaex.service;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaex.dao.PjhDao;
import com.javaex.vo.KakaoToken;
import com.javaex.vo.PjhVo;

@Service
public class PjhService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Autowired
	private PjhDao pjhDao;

	// 회원가입
	public int exejoinpage(PjhVo users_listVo) {
		System.out.println("PjhService.exejoinpage()");
		int count = pjhDao.join(users_listVo);
		System.out.println(count);

		return count;
	}

	// 중복체크
	public int exejoinpageidcheck(String id) {
		System.out.println("PjhService.exejoinpageidcheck");

		int count = pjhDao.idCheck(id);

		return count;
	}

	// 로그인
	public PjhVo exeLogin(PjhVo users_listVo) {
		System.out.println("UserService.exeLogin()");

		PjhVo authUser = pjhDao.userSelscetByIdPw(users_listVo);

		return authUser;
	}

	// 회원정보 수정폼(1명 데이터 가져오기)
	public PjhVo exeModifyForm(int no) {
		System.out.println("UserService.exeModifyForm()");

		PjhVo users_listVo = pjhDao.userSelectOneByNo(no);
		return users_listVo;
	}

	// 회원정보수정
	public int exeModify(PjhVo users_listVo) {
		System.out.println("UserService.exeModify()");

		int count = pjhDao.userUpdate(users_listVo);
		return count;
	}
	
	//카카오로그인
	//(인증코드)
	public String requestToken(String code) {
		String access_Token = "";
		String refresh_Token = "";
		
		String strUrl = "https://kauth.kakao.com/oauth/token";//토큰 요청 보낼 주소
		KakaoToken kakaoToken = new KakaoToken(); //요청 받을 객체
		
		try { 
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();// url Http 연결 생성
			
			//post 요청
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);// outputStreamm으로 post 데이터를 넘김
			
			//파라미터 세팅
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			
			StringBuilder sb = new StringBuilder();
			
			//0번 파라미터 grant_type. -> authorization_code로 고정
			sb.append("grant_type=authorization_code");
			
			//1번 파라미터 client_id
			sb.append("&client_id=10058c98eea1a5e753d74e9e41744dbd");
			
			//2번 파라미터 redirect_uri
			sb.append("&redirect_uri=http://localhost:8080/walking/kakaojoinpage");
			
			//3번 파라미터 code
			sb.append("&code="+ code);
			
			sb.append("&client_secret=x8XTAirpR8WMB60dgmWz8bqUi6PbOEu9");
			
			bw.write(sb.toString());
			bw.flush();//실제 요청을 보내는 부분
			
			//실제 요청을 보내는 부분, 결과 코드가 200이라면 성공
			
			int responseCode =conn.getResponseCode();
			log.info("responsecode(200): {}", responseCode);
			
			//요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
			
			while ((line = br.readLine()) != null) {
				result += line;
			}
			
			log.info("response body: {}", result);
			
			ObjectMapper mapper = new ObjectMapper();
			
			
			//kakao Token에 result를 KakaoToken.class 형식으로 변환하여 저장
			kakaoToken = mapper.readValue(result, KakaoToken.class);
			
			System.out.println(kakaoToken);
			
			
			//api호출용 access token
			access_Token = kakaoToken.getAccess_token();
			
			
			//access 토큰 만료되면 refresh token사용(유효시간 더 김)
			refresh_Token = kakaoToken.getRefresh_token();
			
			
			log.info(access_Token);
			log.info(refresh_Token);
			
			
			br.close();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log.info("카카오토큰생성완료");
		
		
		return access_Token;
		
	}
}
