package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.YdsVo;

@Repository
public class YdsDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 전체 리스트
		public List<YdsVo> selectList() {
			System.out.println("YdsDao.selectList()");

			List<YdsVo> gList = sqlSession.selectList("yds.selectList");

			return gList;
		}


	// 다솜이꺼~
}
