package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.KsbVo;

@Repository
public class KsbDao {

	// 수빈이꺼
	@Autowired
	private SqlSession sqlSession;

}
