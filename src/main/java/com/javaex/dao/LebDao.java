package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.KsbVo;
import com.javaex.vo.LebVo;

@Repository
public class LebDao {

	@Autowired
	private SqlSession sqlSession;

	public int courseDraw(LebVo courseVo) {
		int count = sqlSession.insert("leb.courseDraw", courseVo);
		System.out.println(count);
		return count;
	}
	
	public int coursePointDraw(LebVo coursePointVo) {
		int count = sqlSession.insert("leb.coursePointDraw", coursePointVo);
		return count;
	}
	
	public int recordDraw(KsbVo courseVo) {
		System.out.println("LebDao.recordDraw()");
		int count = sqlSession.insert("leb.recordDraw", courseVo);
		System.out.println(count);
		return count;
	}
	
	public int recordPointDraw(KsbVo coursePointVo) {
		System.out.println("LebDao.recordPointDraw()");
		int count = sqlSession.insert("leb.recordPointDraw", coursePointVo);
		return count;
	}
}
