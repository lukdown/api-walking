package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PjhVo;

@Repository
public class PjhDao {

	@Autowired
	SqlSession sqlSession;

	// 회원가입
	public int join(PjhVo users_listVo) {
		System.out.println("PjhDao.join()");
		int count = sqlSession.insert("pjh.join", users_listVo);
		System.out.println(count);

		return count;
	}

	// 중복체크
	public int idCheck(String id) {
		System.out.println("PjhDao.idCheck()");
		int count = sqlSession.selectOne("pjh.idCheck", id);
		System.out.println(count);

		return count;
	}

	// 로그인
	public PjhVo userSelscetByIdPw(PjhVo users_listVo) {
		System.out.println("UserDao.userSelscetByIdPw()");

		System.out.println(users_listVo);
		PjhVo authUser = sqlSession.selectOne("pjh.selectByIdPw", users_listVo);
		System.out.println(authUser);

		return authUser;
	}
}
