package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PjhVo;

@Repository
public class PjhDao {

	@Autowired
	private SqlSession sqlSession;

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
		System.out.println(id);
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

	// 회원정보 수정폼(1명 데이터 가져오기)
	public PjhVo userSelectOneByNo(int no) {
		System.out.println("UserDao.userSelectOneByNo()");

		PjhVo users_listVo = sqlSession.selectOne("pjh.selectOneByNo", no);
		return users_listVo;
	}

	// 회원정보수정
	public int userUpdate(PjhVo users_listVo) {
		System.out.println("UserDao.userUpdate()");

		int count = sqlSession.update("pjh.update", users_listVo);
		return count;
	}
}
