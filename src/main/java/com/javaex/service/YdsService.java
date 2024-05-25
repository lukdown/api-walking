package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.YdsDao;
import com.javaex.vo.YdsAttachListVo;
import com.javaex.vo.YdsAttachVo;
import com.javaex.vo.YdsVo;

@Service
public class YdsService {

	@Autowired
	private YdsDao ydsDao;

	// 리스트
	public List<YdsVo> exeAllList() {
		System.out.println("YdsService.exeAllList()");

		List<YdsVo> gList = ydsDao.selectList();

		return gList;
	}
	
	// 로그인한 회원의 코스 목록 조회
	public List<YdsVo> exefindCoursesByUserNo(int userNo){
		System.out.println("YdsService.exefindCoursesByUserNo()");
		
		List<YdsVo> userCourses = ydsDao.selectCoursesByUserNo(userNo);
        System.out.println(userCourses);
        return userCourses;
	}
	
	// 로그인한 회원의 특정 코스 소개 등록(저장)
    public void saveCourseIntroduction(MultipartFile galleryfile, YdsVo ydsVo, YdsAttachListVo attachListVo) {
        
    	//텍스트를 저장한다(사진을 제외한 나머지를 저장)///////////////////////
    	ydsDao.insertCourseIntroduction(ydsVo);
        System.out.println(ydsVo);
        
        //묶은이미지 저장
        List<YdsAttachVo> attachVoList = attachListVo.getAttachVoList();
        for (YdsAttachVo attachVo : attachVoList) {
        	// 갤러리 번호 추출
	        int galleryNo = ydsVo.getGallery_no(); // 삽입된 갤러리 번호 가져오기
	  
	        //파일테이타 db저장+서버에 복사(즉 2군데 저장)///////////////////////////////////
			
			// 파일저장디렉토리
			String saveDir = "C:\\JavaStudy\\upload";
	
			// (1)파일관련 정보 추출//////////////
			// 오리지널 파일명
			String orgName = galleryfile.getOriginalFilename();
			System.out.println(orgName);
	
			// 확장자
			String exName = orgName.substring(orgName.lastIndexOf("."));
			System.out.println(exName);
	
			// 저장파일명(겹치지 않아야 된다)
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
			System.out.println(saveName);
	
			// 파일사이즈
			long fileSize = galleryfile.getSize();
			System.out.println(fileSize);
	
			// 파일전체경로
			String filePath = saveDir + "\\" + orgName;
			System.out.println(filePath);
	
			// int uNo = gVo.getUser_no();
			// String content = gVo.getContent();
	
			// vo로묶기
			YdsAttachVo galleryVo = new YdsAttachVo(galleryNo, filePath, orgName, saveName, fileSize);
			galleryVo.setGallery_no(galleryNo); // 갤러리 번호 설정
			System.out.println(galleryVo);
	
			// Dao만들기 --> DB저장
			// (3)DB저장 /////////////////////////////////////////////////////
			System.out.println(galleryVo + "DB저장");
			ydsDao.galleryInsert(galleryVo);
	
			// (2)파일저장(서버쪽 하드디스크에 저장)///////////////////////////////////////////////////
			try {
				byte[] fileData;
				fileData = galleryfile.getBytes();
	
				OutputStream os = new FileOutputStream(filePath);
				BufferedOutputStream bos = new BufferedOutputStream(os);
	
				bos.write(fileData);
				bos.close();
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
			int count = 1;
			
        
    }
    
    
    
    
    
    
	
	// 선택한 코스의 상세 정보 조회
	public YdsVo exefindCourseInfo(String courseName) {
        System.out.println("YdsService.exefindCourseInfo()");
        
        YdsVo courseInfo = ydsDao.selectCourseDetailsByName(courseName);
        System.out.println("YdsService.exefindCourseInfo().courseINfo"+courseInfo);
        return courseInfo;
    }
	

	// 다솜이꺼
}
