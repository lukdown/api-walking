package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	// 수빈이꺼

	// 소모임 등록하기
	public int exeAddGathering(int no, int course_no, String small_gathering_name, String small_gathering_host_name, String small_gathering_hp, 
								int small_gathering_total_personnel, String small_gathering_date, String small_gathering_deadline, String small_gathering_region, 
								String small_gathering_gender_limit, String small_gathering_age_limit, MultipartFile file) {
		System.out.println("KsbService.exeAddGathering()");

		// 파일저장 폴더
		String saveDir = "C:\\javaStudy\\upload";

		// (0)파일관련 정보수집
		// 오리지날 파일명
		String small_gathering_orgName = file.getOriginalFilename();
		System.out.println("orgName:" + small_gathering_orgName);

		// 확장자
		String exName = small_gathering_orgName.substring(small_gathering_orgName.lastIndexOf("."));
		System.out.println("exName:" + exName);

		// 저장 파일명(겹치지 않아야 한다)
		String small_gathering_saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName:" + small_gathering_saveName);

		// 파일 사이즈
		long small_gathering_listcol = file.getSize();
		System.out.println("fileSize:" + small_gathering_listcol);

		// 파일 전체 경로(저장파일명 포함)
		String small_gathering_filePath = saveDir + "\\" + small_gathering_saveName;
		System.out.println("filePath:" + small_gathering_filePath);

		// (1)파일정보를 DB에 저장
		// *vo묶어주고

		KsbVo KsbVo = new KsbVo(no, course_no, small_gathering_name, small_gathering_host_name, small_gathering_hp, 
								small_gathering_total_personnel, small_gathering_date, small_gathering_deadline, small_gathering_region, 
								small_gathering_gender_limit, small_gathering_age_limit, small_gathering_filePath, small_gathering_orgName, 
								  small_gathering_saveName, small_gathering_listcol);
		System.out.println(KsbVo);
		// *db에 저장
		System.out.println(".......DB저장롼료");
		int count = ksbDao.addGathering(no, KsbVo);
		// (2)파일을 하드디스크에 저장

		// 파일 저장
		try {
			byte[] fileData = file.getBytes();

			OutputStream os = new FileOutputStream(small_gathering_filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		;

		return count;
	}

	// 코스 리스트 가져오기
	public List<KsbVo> exeCourseList() {
		// System.out.println("ksbService.exeCourseList()");

		List<KsbVo> courseList = ksbDao.courseList();

		return courseList;
	}

	// 소모임 리스트 구하기

	public Map<String, Object> exeGatheringList(int crtPage, String keyword) {
		System.out.println("YysService.exeList()");

		// 한페이지당 출력 글갯수
		int listCnt = 6;

		// crtPage
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);
		/*
		 * if(crtPage > 0) { crtPage = crtPage }else { crtPage = 1; }
		 */

		// starRowNo번호
		// 1->1 10, 2->11 20, 3->21,30
		// 1->0 10, 2->11 10, 3->20,10
		// (1-1)10->0
		// (2-1)10->10
		// (crtPage-1) * listCnt ->20

		int startRowNo = (crtPage - 1) * listCnt;

		// starRowNo, listCnt Map으로 묶는다
		Map<String, Object> limiMap = new HashMap<String, Object>();
		limiMap.put("startRowNo", startRowNo);
		limiMap.put("listCnt", listCnt);
		limiMap.put("keyword", keyword);

		// dao에 전달해서 현재페이지의 리스트 10개를 받는다
		List<KsbVo> gatheringList = ksbDao.gatheringList(limiMap);

		///////////////////////////////////////////////////////////
		// 페이징 계산
		///////////////////////////////////////////////////////////

		// 페이지당 버튼 갯수
		int pageBtncount = 5;

		// 전체 글갯수
		int totalCnt = ksbDao.selectTotalCnt(keyword);

		// 1~5 -> (1,5)
		// 6~10 -> (6,10)
		// 11~15 -> (11,15)

		// 1 5 => 올림(1/5)*5 --> 0.2(1)*5 => 5
		// 2 5 => 올림(2/5)*5 --> 0.4(1)*5 => 5
		// 3 5 => 올림(3/5)*5 --> 0.6(1)*5 => 5
		// 4 5 => 올림(4/5)*5 --> 0.8(1)*5 => 5
		// 5 5 => 올림(5/5)*5 --> 1.0(1)*5 => 5
		// 6 5 => 올림(6/5)*5 --> 1.2(2)*5 => 10
		// 7 5 => 올림(7/5)*5 --> 1.4(2)*5 => 10
		// 11 5 => 올림(11/5)*5 --> 2.2(3)*5 => 15
		// 마지막 버튼 번호
		int endPageBtnNo = (int) Math.ceil(crtPage / (double) pageBtncount) * pageBtncount;

		// 시작 버튼 번호
		int startPageBtnNo = (endPageBtnNo - pageBtncount) + 1;

		// 다음 화살표 유무
		boolean next = false;
		if (listCnt * endPageBtnNo < totalCnt) { // 한페이지당글갯수(10) * 마지막버튼번호(5) <전체글갯수 102개
			next = true;
		} else { // 다음화살표가 false일떄 마지막 버튼 번호 정확히 계산 187 --> 19
			endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);
		}

		// 이전 화살표 유무
		boolean prev = false;
		if (startPageBtnNo != 1) {
			prev = true;
		}

		// 5개 map으로 묶어서 controller한테 보낸다 리턴해준다
		Map<String, Object> gMap = new HashMap<String, Object>();
		gMap.put("gatheringList", gatheringList);
		gMap.put("startPageBtnNo", startPageBtnNo);
		gMap.put("endPageBtnNo", endPageBtnNo);
		gMap.put("prev", prev);
		gMap.put("next", next);

		return gMap;
	}

	// 총 걸음 구하기
	public double exeTotalWalk(int no) {
		System.out.println("ksbService.exeTotalWalk()");

		double totalLength = ksbDao.totalWalk(no);

		return totalLength;
	}

	// 스티커 바꾸기
	public int exeChallengeUpdate(int no, KsbVo ksbVo) {
		System.out.println("ksbDao.exeChallengeUpdate()");

		return ksbDao.ChallengeUpdate(no, ksbVo);
	}

	// 스티커 리스트 가져오기
	public List<KsbVo> exeStickerList(int no) {
		// System.out.println("KsbService.exeStickerList()");

		List<KsbVo> stickerList = ksbDao.StickerList(no);

		return stickerList;
	}

	// 달력 리스트 가져오기

	public List<KsbVo> exeCalendarList(int no) {
		// System.out.println("KsbService.exeCalendarList()");

		List<KsbVo> calendarList = ksbDao.calendarList(no);

		return calendarList;
	}

	// 기록 리스트 가져오기
	public List<KsbVo> exeRecordList(int no) {
		// System.out.println("ksbService.exeRecordList()");

		List<KsbVo> recordList = ksbDao.recordList(no);

		return recordList;
	}

	// 코스 포인트 가져오기
	public List<KsbVo> exeCoursePointList(KsbVo ksbVo) {
		// System.out.println("KsbService.exeCoursePointList()");

		List<KsbVo> coursepointList = ksbDao.coursepointList(ksbVo);
		// System.out.println(coursepointList);

		return coursepointList;

	}

	// 기록 포인트 가져오기
	public List<KsbVo> exeRecordPointList(KsbVo ksbVo) {
		// System.out.println("KsbService.exeRecordPointList()");

		List<KsbVo> recordpointList = ksbDao.recordpointList(ksbVo);
		// System.out.println(recordpointList);

		return recordpointList;
	}

	// 기록 1개만 가져오기
	public KsbVo exeGetSelectedRecord(KsbVo ksbVo) {
		// System.out.println("KsbService.exeGetSelectedRecord()");

		KsbVo RecordInfo = ksbDao.selectRecord(ksbVo);
		// System.out.println(RecordInfo);
		return RecordInfo;
	}

	// 마이페이지
	public KsbVo exeSelectMember(int no) {
		// System.out.println("KsbService.exeSelectMember()");
		KsbVo memberInfo = ksbDao.selectMember(no);
		return memberInfo;
	}

	// 프로필 사진 업데이트
	public void exeProfileUpdate(int users_no, MultipartFile file) {
		// System.out.println("ksbService.exeProfileUpdate");

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
