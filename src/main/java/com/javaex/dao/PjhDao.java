package com.javaex.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PjhVo;

@Repository
public class PjhDao {

	//재현이꺼~
	@Autowired SqlSession sqlSession;
	
	
}
