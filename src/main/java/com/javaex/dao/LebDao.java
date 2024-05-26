package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.LebVo;

@Repository
public class LebDao {

	@Autowired
	private SqlSession sqlSession;

	public int courseDraw(LebVo courseVo) {
		System.out.println("LebDao.courseDraw()");
		int count = sqlSession.insert("leb.courseDraw", courseVo);
		return count;
	}
	
	public int coursePointDraw(LebVo coursePointVo) {
		System.out.println("LebDao.coursePointDraw()");
		int count = sqlSession.insert("leb.coursePointDraw", coursePointVo);
		return count;
	}
}
