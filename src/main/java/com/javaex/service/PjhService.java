package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PjhDao;
import com.javaex.vo.PjhVo;

@Service
public class PjhService {

	@Autowired
	PjhDao pjhDao;

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
		
		
		
	}
}
