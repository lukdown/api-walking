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
	
	//달력 리스트 가져오기
	public List<KsbVo> calendarList(int no){
		System.out.println("ksbDao.calendarList()");
		//System.out.println(no);
		List<KsbVo> calendarList = sqlSession.selectList("ksb.calendarList", no);
		
		return calendarList;
	}
	
	//기록 리스트 가져오기
	
	public List<KsbVo> recordList(int no){
		System.out.println("ksbDao.recordList");
		System.out.println(no);
		List<KsbVo> recordList = sqlSession.selectList("ksb.recordList", no);
		//System.out.println(recordList);
		return recordList;
	}
	
	//코스 포인트 가져오기
	public List<KsbVo> coursepointList(KsbVo ksbVo){
		System.out.println("ksbDao.coursepointList()");
		
		//System.out.println(ksbVo);
		List<KsbVo> coursepointList = sqlSession.selectList("ksb.coursepointList", ksbVo);
		
		System.out.println(coursepointList);
		return coursepointList;
	}
	
	//기록 포인트 가져오기
	public List<KsbVo> recordpointList(KsbVo ksbVo){
		System.out.println("ksbDao.recordpointList()");
		
		System.out.println(ksbVo);
		List<KsbVo> recordpointList = sqlSession.selectList("ksb.recordpointList", ksbVo);
		
		System.out.println(recordpointList);
		return recordpointList;
	}
	
	
	//마이페이지
	public KsbVo selectMember(int no) {
		System.out.println("KsbDao.selectMember()");
		KsbVo memberinfo = sqlSession.selectOne("ksb.selectMemberInfo", no);
		return memberinfo;
	}
	
	//프로필 사진 업데이트
	public int exeProfileUpdate(KsbVo ksbVo) {
		System.out.println("ksbDao.exeProfileUpdate()");
		
		return sqlSession.update("ksb.profileUpdate", ksbVo);
	}
	
	
}
