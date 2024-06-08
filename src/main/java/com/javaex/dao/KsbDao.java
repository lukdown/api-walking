package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.KsbVo;

@Repository
public class KsbDao {

	// 수빈이꺼
	@Autowired
	private SqlSession sqlSession;
	
	//프로필 사진 업데이트
	public int challengeUpdate(KsbVo ksbVo) {
		System.out.println("ksbDao.challengeUpdate()");
		
		return sqlSession.update("ksb.challengeUpdate", ksbVo);
	}

	//도전과제 리스트 가져오기
	public List<KsbVo> achievementList() {
		System.out.println("KsbDao.achievementList()");
		List<KsbVo> achievementList = sqlSession.selectList("ksb.achievementList");
		System.out.println(achievementList);
		
		return achievementList;
	}

	
	//즐겨찾기 갯수 구하기
	public int getFavCount(int no) {
		//System.out.println("ksbDao.totalWalk()");
		
		int FavCount = sqlSession.selectOne("ksb.FavCount", no);
		//System.out.println(FavCount);
		return FavCount;
	}

	//도전과제 번호로 도전과제 이름 가져오기
	public KsbVo getChallengeDaepyo(int no) {
		//System.out.println("ksbDao.getChallengeDaepyo()");
		
		KsbVo daepyoInfo = sqlSession.selectOne("ksb.getChallengeDaepyo", no);
		//System.out.println("대표 도전과제 이름: "+ daepyoInfo);
		
		return daepyoInfo;
	}
	
	//소모임 수정하기
	public int exeGatheringModify(KsbVo ksbVo) {
		System.out.println("KsbDao.addGathering()");
		
		int count = sqlSession.update("ksb.gatheringModify", ksbVo);
		
		return count;
	}
	
	//소모임 1개 불러오기
	public KsbVo selectGathering(int small_gathering_no) {
		System.out.println("KsbDao.selectGathering()");
		
		KsbVo GatheringInfo = sqlSession.selectOne("ksb.selectGathering", small_gathering_no);
		//System.out.println(RecordInfo+"__________________________________________________________________");
		return GatheringInfo;
		
	}
	
	//소모임 등록하기
	public int addGathering(int no, KsbVo ksbVo) {
		System.out.println("KsbDao.addGathering()");

		int count = sqlSession.insert("ksb.addGathering", ksbVo);

		return count;
	}
	
	//코스 리스트 가져오기
	public List<KsbVo> courseList() {
		//System.out.println("KsbDao.courseList()");
		List<KsbVo> courseList = sqlSession.selectList("ksb.courseList");
		//System.out.println(courseList);
		
		return courseList;
	}
	
	// 고객 상품 리스트(검색O,페이징 O)
		public List<KsbVo> gatheringList(Map<String, Object> limiMap) {
			System.out.println("KsbDao.productList");

			List<KsbVo> gatheringList = sqlSession.selectList("ksb.selectlist", limiMap);

			System.out.println(gatheringList);

			return gatheringList;
		}

		// 글 전체 갯수 //리스트(검색O,페이징O)
		public int selectTotalCnt(String keyword) {
			System.out.println("YysDao.selectTotalCnt()");

			int totalCount = sqlSession.selectOne("ksb.selectTotalCnt", keyword);

			return totalCount;
		}
	
	//총 걸음 구하기
		public double totalWalk(int no) {
			System.out.println("ksbDao.totalWalk()");
			
			double totalLength = sqlSession.selectOne("ksb.totalLength", no);
			System.out.println(totalLength);
			return totalLength;
		}
	
	//스티커 바꾸기
	public int ChallengeUpdate(KsbVo ksbVo) {
		System.out.println("ksbDao.ChallengeUpdate()");
		
		int count = sqlSession.update("ksb.SetChallengeDaepyoToOne", ksbVo);
		int count2 = sqlSession.update("ksb.ResetOtherChallengeDaepyo", ksbVo);
		System.out.println(ksbVo);
		System.out.println(count);
		System.out.println(count2);
		return count2;
	}
	
	//스티커 리스트 가져오기
	public List<KsbVo> StickerList(int no){
		//System.out.println("ksbDao.stickerList()");
		System.out.println(no);
		List<KsbVo> stickerList = sqlSession.selectList("ksb.stickerList", no);
		
		return stickerList;
	}
	
	//달력 리스트 가져오기
	public List<KsbVo> calendarList(int no){
		//System.out.println("ksbDao.calendarList()");
		//System.out.println(no);
		List<KsbVo> calendarList = sqlSession.selectList("ksb.calendarList", no);
		
		return calendarList;
	}
	
	//기록 리스트 가져오기
	
	public List<KsbVo> recordList(int no){
		//System.out.println("ksbDao.recordList");
		//System.out.println(no);
		List<KsbVo> recordList = sqlSession.selectList("ksb.recordList", no);
		//System.out.println(recordList);
		return recordList;
	}
	
	//코스 포인트 가져오기
	public List<KsbVo> coursepointList(KsbVo ksbVo){
		//System.out.println("ksbDao.coursepointList()");
		
		//System.out.println(ksbVo);
		List<KsbVo> coursepointList = sqlSession.selectList("ksb.coursepointList", ksbVo);
		
		//System.out.println(coursepointList);
		return coursepointList;
	}
	
	//기록 포인트 가져오기
	public List<KsbVo> recordpointList(KsbVo ksbVo){
		//System.out.println("ksbDao.recordpointList()");
		
		//System.out.println(ksbVo);
		List<KsbVo> recordpointList = sqlSession.selectList("ksb.recordpointList", ksbVo);
		
		//System.out.println(recordpointList);
		return recordpointList;
	}
	
	//기록 가져오기
	public KsbVo selectRecord(KsbVo ksbVo) {
		//System.out.println("KsbDao.selectRecord()");
		//System.out.println(ksbVo + "============================================================================================");
		KsbVo RecordInfo = sqlSession.selectOne("ksb.selectRecord", ksbVo);
		//System.out.println(RecordInfo+"__________________________________________________________________");
		return RecordInfo;
	}
	
	
	
	//마이페이지
	public KsbVo selectMember(int no) {
		//System.out.println("KsbDao.selectMember()");
		KsbVo memberinfo = sqlSession.selectOne("ksb.selectMemberInfo", no);
		return memberinfo;
	}
	
	//프로필 사진 업데이트
	public int exeProfileUpdate(KsbVo ksbVo) {
		//System.out.println("ksbDao.exeProfileUpdate()");
		
		return sqlSession.update("ksb.profileUpdate", ksbVo);
	}
	
	
}
