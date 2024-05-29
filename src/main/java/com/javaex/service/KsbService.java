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

import com.javaex.dao.KsbDao;
import com.javaex.vo.KsbVo;

@Service
public class KsbService {
	@Autowired
	private KsbDao ksbDao;

	//수빈이꺼
	
	//달력 리스트 가져오기
	
	public List<KsbVo> exeCalendarList(int no){
		System.out.println("KsbService.exeCalendarList()");
		
		List<KsbVo> calendarList = ksbDao.calendarList(no);
		
		return calendarList;
	}
	
	
	//기록 리스트 가져오기
	public List<KsbVo> exeRecordList(int no){
		System.out.println("ksbService.exeRecordList()");
		
		List<KsbVo> recordList = ksbDao.recordList(no);
		
		return recordList;
	}
	
	//마이페이지
	public KsbVo exeSelectMember(int no) {
		System.out.println("KsbService.exeSelectMember()");
		KsbVo memberInfo = ksbDao.selectMember(no);
		return memberInfo;
	}
	
	//프로필 사진 업데이트
	public void exeProfileUpdate(int users_no, MultipartFile file) {
		System.out.println("ksbService.exeProfileUpdate");

		// 파일저장 폴더
		String saveDir = "C:\\javaStudy\\upload";

		// (0)파일관련 정보수집
		// 오리지날 파일명
		String orgName = file.getOriginalFilename();
		System.out.println("orgName:" + orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println("exName:" + exName);

		// 저장 파일명(겹치지 않아야 한다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName:" + saveName);

		// 파일 사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize:" + fileSize);

		// 파일 전체 경로(저장파일명 포함)
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath:" + filePath);

		// (1)파일정보를 DB에 저장
		// *vo묶어주고
		
		KsbVo ksbVo = new KsbVo(users_no, saveName, orgName, fileSize, filePath);
		System.out.println(ksbVo);
		
		// *db에 저장
		System.out.println("");
		ksbDao.exeProfileUpdate(ksbVo);
		
		// (2)파일을 하드디스크에 저장

		// 파일 저장
		try {
			byte[] fileData = file.getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		;

	}
	
	
}
