package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PjhVo;
import com.javaex.vo.YysVo;

@Repository
public class PjhDao {

	@Autowired
	private SqlSession sqlSession;

	// 회원가입
	public int join(PjhVo users_listVo) {
		System.out.println("PjhDao.join()");
		int count = sqlSession.insert("pjh.join", users_listVo);
		System.out.println(count);

		return count;
	}

	// 중복체크
	public int idCheck(String id) {
		System.out.println("PjhDao.idCheck()");
		System.out.println(id);
		int count = sqlSession.selectOne("pjh.idCheck", id);
		System.out.println(count);

		return count;
	}

	// 로그인
	public PjhVo userSelscetByIdPw(PjhVo users_listVo) {
		System.out.println("PjhDao.userSelscetByIdPw()");

		System.out.println(users_listVo);
		PjhVo authUser = sqlSession.selectOne("pjh.selectByIdPw", users_listVo);
		System.out.println(authUser);

		return authUser;
	}

	// 회원정보 수정폼(1명 데이터 가져오기)
	public PjhVo userSelectOneByNo(int no) {
		System.out.println("UserDao.userSelectOneByNo()");

		PjhVo users_listVo = sqlSession.selectOne("pjh.selectOneByNo", no);
		return users_listVo;
	}

	// 회원정보수정
	public int userUpdate(PjhVo users_listVo) {
		System.out.println("UserDao.userUpdate()");

		int count = sqlSession.update("pjh.update", users_listVo);
		return count;
	}

	// 카카오 로그인
	public PjhVo userSelscetByKakaoId(PjhVo users_listVo) {
		System.out.println("UserDao.userSelscetByKakaoId()");

		System.out.println(users_listVo);
		PjhVo authUser = sqlSession.selectOne("pjh.selectBykakakoId", users_listVo);
		System.out.println("qwer" + authUser);

		return authUser;
	}

	// 편의시설 리스트불러오기
	public List<PjhVo> ConvenientFacilitieslist() {
		System.out.println("PjhDao.ConvenientFacilitieslist()");

		List<PjhVo> convenient_facilities_list = sqlSession.selectList("pjh.ConvenientFacilitieslist");

		return convenient_facilities_list;
	}

	// 편의시설 api 데이터 있나 비교
	public int facilitieslistdatacomparison(String facilities_name) {
		System.out.println("PjhDao.facilitieslist()");
		// ystem.out.println(facilities_name);
		int count = sqlSession.selectOne("pjh.facilitieslistcomparison", facilities_name);
		// System.out.println(count);

		return count;
	}

	// 편의시설 api/유저입력 데이터 저장
	public int facilitieslistinsert(PjhVo convenient_facilities_list) {
		System.out.println("PjhDao.facilitieslistinsert()");
		int count = sqlSession.insert("pjh.facilitieslistinsert", convenient_facilities_list);
		// System.out.println(count);

		return count;
	}

	// 소모임 읽기페이지
	public PjhVo getSmallGatheringDetail(int smallgatheringno, int login_users_no) {
		System.out.println("PjhDao.getSmallGatheringDetail()");

		PjhVo pVo = new PjhVo();
		pVo.setSmall_gathering_no(smallgatheringno);
		pVo.setLogin_users_no(login_users_no);

		System.out.println(pVo);

		PjhVo smallgatheringVo = sqlSession.selectOne("pjh.SmallGatheringDetail", pVo);
		// System.out.println(smallgatheringVo);

		return smallgatheringVo;
	}

	// 소모임 카운트
	public int getSmallGatheringCount(int smallgatheringno) {
		System.out.println("PjhDao.getSmallGatheringCount()");

		int count = sqlSession.selectOne("pjh.SmallGatheringCount", smallgatheringno);
		// System.out.println(count);
		// System.out.println(smallgatheringVo);

		return count;
	}

	// 소모임 신청 삭제
	public int smalldapplicationdelete(PjhVo pjhVo) {
		System.out.println("PjhDao.smalldapplicationdelete()");
		// System.out.println(pjhVo.get);

		int count = sqlSession.delete("pjh.smalldapplicationdelete", pjhVo);

		return count;
	}

	// 소모임 삭제
	public int smalldgatheringdelete(PjhVo pjhVo) {
		System.out.println("PjhDao.smalldgatheringdelete()");
		// System.out.println(pjhVo.get);

		int count = sqlSession.delete("pjh.smalldgatheringdelete", pjhVo);

		return count;
	}

	// 소모임 신청
	public int applicationinsert(PjhVo pjhVo) {
		System.out.println("PjhDao.applicationinsert()");

		int count = sqlSession.insert("pjh.applicationinsert", pjhVo);
		return count;
		// return count;
	}

	// 소모임 신청 취소
	public int applicationdelete(PjhVo pjhVo) {
		System.out.println("PjhDao.applicationdelete()");

		int count = sqlSession.delete("pjh.applicationdelete", pjhVo);

		return count;
		// return count;
	}

	// 소모임 신청 리스트
	public List<PjhVo> small_app_List(int small_gathering_no) {
		System.out.println("PjhDao.small_app_List()");

		List<PjhVo> lList = sqlSession.selectList("pjh.small_app_List", small_gathering_no);

		// System.out.println(lList);

		return lList;

	}

	// 소모임 신청 수락
	public int small_app_modify(PjhVo pjhVo) {
		System.out.println("PjhDao.small_app_modify()");
		System.out.println("===============++++");
		System.out.println(pjhVo);
		System.out.println("===============++++");
		int count = sqlSession.update("pjh.small_app_modify", pjhVo);
		return count;
	}

	// 소모임 신청 확인
	public PjhVo small_app_Check(PjhVo pjhVo) {
		System.out.println("PjhDao.small_app_Check()");

		PjhVo pVo = sqlSession.selectOne("pjh.small_app_Check", pjhVo);

		// System.out.println(lList);

		return pVo;

	}

}
