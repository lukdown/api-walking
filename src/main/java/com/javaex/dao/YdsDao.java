package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.YdsAttachVo;
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
		
	// 파일 정보를 DB에 저장
		 public void saveFileInfo(YdsAttachVo attachVo) {
		        try {
		            sqlSession.insert("yds.saveFileInfo", attachVo);
		        } catch (Exception e) {
		            e.printStackTrace();
		            // 예외 처리 로직 추가
		        }
		    
	    }	


	// 다솜이꺼~
}
