package com.javaex.dao;


import java.util.List;
import java.util.Map;

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

	// 파일 정보를 DB에 저장
	public void galleryInsert(YdsAttachVo galleryVo) {
		sqlSession.insert("yds.saveFileInfo", galleryVo);
	}

	// 로그인한 회원의 특정 코스 소개 등록(저장)
	public void insertCourseIntroduction(YdsVo ydsVo) {
		System.out.println("YdsDao.insertCourseIntroduction()");

		sqlSession.insert("yds.insertCourseIntroduction", ydsVo);
		System.out.println("코스소개글저장");

	}
	
	// 최신 포스팅의 gallery_no 가져오기
	public List<YdsAttachVo> selectLatestGalleryNo(int gallery_no) {
	    System.out.println("YdsDao.selectLatestGalleryNo()");
	    List<YdsAttachVo> gpList = sqlSession.selectList("yds.selectLatestGalleryNo", gallery_no);
	    //System.out.println(gpList);
	    
	    //return null;
	    return gpList;
	}
	
	// 저장된 이미지리스트 불러오기
	public List<YdsAttachVo> selectPicList(int galleryNo) {
	    System.out.println("YdsDao.selectPicList()");
	    return sqlSession.selectList("yds.selectPicListByGalleryNo", galleryNo);
	}



	// 선택한 코스의 상세 정보 조회
	public YdsVo selectCourseDetailsByName(String courseName) {
		System.out.println("YdsDao.selectCourseDetailsByName()");

		YdsVo courseInfo = sqlSession.selectOne("yds.selectCourseDetailsByName", courseName);
		return courseInfo;
	}

	// 다솜이꺼~
}
