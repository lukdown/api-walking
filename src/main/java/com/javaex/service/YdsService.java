package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.YdsDao;
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

		for (int i = 0; i < gList.size(); i++) {
			List<YdsAttachVo> imageList = ydsDao.selectLatestGalleryNo(gList.get(i).getGallery_no());
			gList.get(i).settList(imageList);
			System.out.println(gList.get(i).gettList());

		}

		// System.out.println(gList);
		return gList;
	}

	// 코스별 리스트
	public List<YdsVo> getCourseList(int courseNo) {

		System.out.println("YdsService.getCourseList()");
		List<YdsVo> cList = ydsDao.selectCourseList(courseNo);

		// 반복문을 통해 각 갤러리 항목에 대한 이미지 목록을 설정
		for (int i = 0; i < cList.size(); i++) {
			List<YdsAttachVo> imageList = ydsDao.selectLatestGalleryNo(cList.get(i).getGallery_no());
			cList.get(i).settList(imageList);
			System.out.println(cList.get(i).gettList());
		}

		return cList;

	}

	// 나의 코스 갤러리 리스트
	public List<YdsVo> getMyCourseList(int userNo) {

		System.out.println("YdsService.getMyCourseList()");
		List<YdsVo> mList = ydsDao.selectMyCourseList(userNo);

		// 반복문을 통해 각 갤러리 항목에 대한 이미지 목록을 설정
		for (int i = 0; i < mList.size(); i++) {
			List<YdsAttachVo> imageList = ydsDao.selectLatestGalleryNo(mList.get(i).getGallery_no());
			mList.get(i).settList(imageList);
			System.out.println(mList.get(i).gettList());
		}

		return mList;

	}

	// 갤러리와 관련된 모든 데이터를 삭제하는 서비스 메서드
	public void deleteGallery(int galleryNo, int userNo) {
		System.out.println("YdsService.deleteGallery()");

		// 갤러리의 라이크 삭제
		ydsDao.deleteLike(galleryNo);

		// 갤러리의 포토 삭제
		ydsDao.deletePhoto(galleryNo);

		// 갤러리 삭제
		ydsDao.deleteGallery(galleryNo);

		System.out.println("삭제 완료");
	}

	// 로그인한 회원의 코스 목록 조회
	public List<YdsVo> exefindCoursesByUserNo(int userNo) {
		System.out.println("YdsService.exefindCoursesByUserNo()");

		List<YdsVo> userCourses = ydsDao.selectCoursesByUserNo(userNo);
		// System.out.println(userCourses);
		return userCourses;
	}

	// 특정리스트 좋아요 조회
	public int getGalleryLikes(int galleryNo) {
		System.out.println("YdsService.getGalleryLikes()");
		int count = ydsDao.selectGalleryLikes(galleryNo);

		return count;
	}

	// 좋아요 추가 및 삭제
	public int likeGallery(int userNo, int galleryNo) {
		int likeExists = ydsDao.checkLikeExists(userNo, galleryNo);
		if (likeExists > 0) {
			ydsDao.gdeleteLike(userNo, galleryNo);
		} else {
			ydsDao.ginsertLike(userNo, galleryNo);
		}
		return ydsDao.selectGalleryLikes(galleryNo);
	}

	// 로그인한 회원의 특정 코스 소개 등록(저장)	
	public void saveCourseIntroduction(MultipartFile[] galleryfile, YdsVo ydsVo) {
		// 운영 체제 이름 확인
		String osName = System.getProperty("os.name").toLowerCase();
		String saveDir;
		
		// 텍스트를 저장한다(사진을 제외한 나머지를 저장)///////////////////////
		ydsDao.insertCourseIntroduction(ydsVo);
		// System.out.println(ydsVo);

		// 묶은이미지 저장

		for (int i = 0; i < galleryfile.length; i++) {
			// 갤러리 번호 추출
			int galleryNo = ydsVo.getGallery_no(); // 삽입된 갤러리 번호 가져오기

			// 파일테이타 db저장+서버에 복사(즉 2군데 저장)///////////////////////////////////

			// 운영 체제에 따라 다른 경로 설정
			if (osName.contains("linux")) {
				System.out.println("리눅스");
				// 파일저장디렉토리
				saveDir = "/app/upload"; // Linux 경로. username을 실제 사용자 이름으로 변경하세요.
			} else {
				System.out.println("윈도우");
				// 파일저장디렉토리
				saveDir = "D:\\javaStudy\\upload";
			}

			// (1)파일관련 정보 추출//////////////
			// 오리지널 파일명
			String orgName = galleryfile[i].getOriginalFilename();
			System.out.println(orgName);

			// 확장자
			String exName = orgName.substring(orgName.lastIndexOf("."));
			System.out.println(exName);

			// 저장파일명(겹치지 않아야 된다)
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
			System.out.println(saveName);

			// 파일사이즈
			long fileSize = galleryfile[i].getSize();
			System.out.println(fileSize);

			// 파일전체경로
			String filePath = saveDir + File.separator + saveName;
			System.out.println(filePath);

			// int uNo = gVo.getUser_no();
			// String content = gVo.getContent();

			// vo로묶기
			YdsAttachVo galleryVo = new YdsAttachVo(galleryNo, filePath, orgName, saveName, fileSize);
			galleryVo.setGallery_no(galleryNo); // 갤러리 번호 설정
			// System.out.println(galleryVo);

			// Dao만들기 --> DB저장
			// (3)DB저장 /////////////////////////////////////////////////////
			System.out.println(galleryVo + "DB저장");
			ydsDao.galleryInsert(galleryVo);

			// (2)파일저장(서버쪽 하드디스크에 저장)///////////////////////////////////////////////////
			try {
				byte[] fileData;
				fileData = galleryfile[i].getBytes();

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
		

	}

	// 선택한 코스의 상세 정보 조회
	public YdsVo exefindCourseInfo(String courseName) {
		System.out.println("YdsService.exefindCourseInfo()");

		YdsVo courseInfo = ydsDao.selectCourseDetailsByName(courseName);
		System.out.println("YdsService.exefindCourseInfo().courseINfo" + courseInfo);
		return courseInfo;
	}

	// 다솜이꺼
}
