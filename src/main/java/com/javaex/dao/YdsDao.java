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
	// 로그인한 회원의 코스 목록 조회
		public List<YdsVo> selectCoursesByUserNo(int userNo) {
			System.out.println("YdsDao.selectCoursesByUserNo()");
			
	        List<YdsVo> userCourses = sqlSession.selectList("yds.selectCoursesByUserNo", userNo);
	        return userCourses;
		}
	
	// 로그인한 회원의 특정 코스 소개 등록(저장)
		
	    public void insertCourseIntroduction(YdsVo ydsVo) {
	    	System.out.println("YdsDao.insertCourseIntroduction()");
	    	
	    	sqlSession.insert("yds.insertCourseIntroduction", ydsVo);
	    	System.out.println("코스소개글저장");
	    	
	        
	    }
	
		// 선택한 코스의 상세 정보 조회
	    public YdsVo selectCourseDetailsByName(String courseName) {
	        System.out.println("YdsDao.selectCourseDetailsByName()");
	        
	        YdsVo courseInfo = sqlSession.selectOne("yds.selectCourseDetailsByName", courseName);
	        return courseInfo;
	    }
		
		
	// 파일 정보를 DB에 저장
		/* public void galleryInsert(YdsAttachVo galleryVo) {
		        try {
		            sqlSession.insert("yds.saveFileInfo", galleryVo);
		        } catch (Exception e) {
		            e.printStackTrace();
		            // 예외 처리 로직 추가
		        }
		    
	    }	*/


	// 다솜이꺼~
}
