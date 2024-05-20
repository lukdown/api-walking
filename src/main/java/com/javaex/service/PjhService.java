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

}
