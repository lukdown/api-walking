package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.KsbVo;

@Repository
public class KsbDao {

	// 수빈이꺼
	@Autowired
	private SqlSession sqlSession;
	
	//마이페이지
	public KsbVo selectMember(int no) {
		System.out.println("KsbDao.selectMember()");
		KsbVo memberinfo = sqlSession.selectOne("ksb.selectMemberInfo", no);
		System.out.println(memberinfo);
		return memberinfo;
	}

}
