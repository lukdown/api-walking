package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.YysDao;
import com.javaex.vo.YysVo;

@Service
public class YysService {

	@Autowired
	private YysDao yysDao;

	// 리스트 가져오기
	public List<YysVo> exeCoursetotalList() {
		System.out.println("YysService.exeCoursetotalList()");

		List<YysVo> coursebookList = yysDao.coursebooktotalList();

		// System.out.println(coursebookList);

		for (int i = 0; i < coursebookList.size(); i++) {
			// System.out.println(coursebookList.get(i).getCourse_no());
			int like_count = yysDao.like_count(coursebookList.get(i).getCourse_no());

			YysVo yVo = coursebookList.get(i);
			yVo.setLike_count(like_count);

		}
		// System.out.println(coursebookList);

		return coursebookList;
	}

	// 리스트 가져오기
	public List<YysVo> exeCourseList(YysVo yysVo) {
		System.out.println("YysService.exeCourseList()");

		List<YysVo> coursebookList = yysDao.coursebookList(yysVo);

		// System.out.println(coursebookList);

		for (int i = 0; i < coursebookList.size(); i++) {
			// System.out.println(coursebookList.get(i).getCourse_no());
			int like_count = yysDao.like_count(coursebookList.get(i).getCourse_no());

			YysVo yVo = coursebookList.get(i);
			yVo.setLike_count(like_count);

		}
		// System.out.println(coursebookList);

		return coursebookList;
	}

	// 즐겨찾기 리스트 가져오기
	public List<YysVo> exeCoursefList(String users_no) {
		System.out.println("YysService.exeCoursefList()");

		List<YysVo> coursebookfList = yysDao.coursebookfList(users_no);

		return coursebookfList;
	}

	// 좋아요 리스트
	public List<YysVo> exelikeList(int users_no) {
		System.out.println("YysService.exelikeList()");

		List<YysVo> lList = yysDao.selectLike(users_no);

		System.out.println("======================================");
		// System.out.println(lList);

		/*
		 * for (int i = 0; i < lList.size(); i++) {
		 * //System.out.println(lList.get(i).getCourse_like_no());
		 * if(lList.get(i).getCourse_like_no() == 0) { System.out.println(lList.get(i));
		 * 
		 * 
		 * 
		 * }else if(lList.get(i).getCourse_like_no() != 0) {
		 * 
		 * } }
		 */

		System.out.println("======================================");

		return lList;
	}

	// 후기리스트 가져오기
	public List<YysVo> exeCoursereviewList(int course_no) {
		System.out.println("YysService.exeCoursereviewList()");

		List<YysVo> coursereviewList = yysDao.coursereviewList(course_no);

		return coursereviewList;
	}

	// 후기 저장
	public int exereviewupdate(YysVo yysVo) {
		System.out.println("YysService.exereviewupdate()");

		// 등록
		int count = yysDao.reviewinsert(yysVo);

		return count;
	}

	// 즐겨찾기 해당 정보 가져오기
	public YysVo exeonefavoritesinfo(YysVo yVo) {
		System.out.println("YysService.exeonefavoritesinfo()");

		YysVo yysVo = yysDao.favoritesOne(yVo);

		return yysVo;
	}

	// 즐겨찾기 저장
	public int exefavoritesupdate(YysVo yysVo) {
		System.out.println("YysService.exefavoritesupdate()");

		int count = yysDao.favoritesinsert(yysVo);

		return count;
	}

	// 즐겨찾기 삭제
	public int exefavoritesdelete(YysVo yysVo) {
		System.out.println("YysService.exefavoritesdelete()");

		// 등록
		int count = yysDao.favoritesdelete(yysVo);

		return count;
	}

	// 좋아요 저장
	public int exelikeupdate(YysVo yysVo) {
		System.out.println("YysService.exelikeupdate()");

		int count = yysDao.likeinsert(yysVo);

		return count;
	}

	// 좋아요 삭제
	public int exelikedelete(YysVo yysVo) {
		System.out.println("YysService.exelikedelete()");

		// 등록
		int count = yysDao.likedelete(yysVo);

		return count;
	}

	// 리스트 조회수 수정
	public int exeViewmodify(YysVo yysVo) {
		System.out.println("YysService.exeViewmodify()");

		int count = yysDao.viewmodify(yysVo);

		return count;
	}

}
