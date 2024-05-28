package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.YysVo;

@Repository
public class YysDao {

	@Autowired
	private SqlSession sqlSession;

	// 코스 포인트리스트 가져오기
	public List<YysVo> coursepointList(YysVo yysVo) {
		System.out.println("YysDao.coursepointList()");
		
		//System.out.println(yysVo);
		List<YysVo> coursepointList = sqlSession.selectList("yys.coursepointList", yysVo);

		System.out.println(coursepointList);
		return coursepointList;
	}

	// 리스트 가져오기
	public List<YysVo> coursebooktotalList() {
		System.out.println("YysDao.coursebooktotalList()");
		// System.out.println(yysVo);
		List<YysVo> coursebookList = sqlSession.selectList("yys.coursetotalList");

		// System.out.println(coursebookList);
		return coursebookList;
	}

	// 리스트 가져오기
	public List<YysVo> coursebookList(YysVo yysVo) {
		System.out.println("YysDao.coursebookList()");
		// System.out.println(yysVo);
		List<YysVo> coursebookList = sqlSession.selectList("yys.courseList", yysVo);

		// System.out.println(coursebookList);
		return coursebookList;
	}

	// 좋아요 코스별 카운트 가져오기
	public int like_count(int course_no) {
		// System.out.println("YysDao.like_count()");
		// System.out.println(course_no);
		int like_count = sqlSession.selectOne("yys.like_count", course_no);

		// System.out.println(like_count);
		return like_count;
	}

	// 즐겨찾기 리스트 가져오기
	public List<YysVo> coursebookfList(String users_no) {
		System.out.println("YysDao.coursebookfList()");
		// System.out.println(users_no);
		List<YysVo> coursebookfList = sqlSession.selectList("yys.coursefList", users_no);

		// System.out.println(coursebookfList);
		return coursebookfList;
	}

	// 좋아요 리스트
	public List<YysVo> selectLike(int users_no) {
		System.out.println("YysDao.selectLike()");

		List<YysVo> lList = sqlSession.selectList("yys.selectLikeList", users_no);
		return lList;
	}

	// 후기 리스트 가져오기
	public List<YysVo> coursereviewList(int course_no) {
		System.out.println("YysDao.coursereviewList()");
		// System.out.println(course_no);
		List<YysVo> coursereviewList = sqlSession.selectList("yys.coursereviewList", course_no);

		// System.out.println(coursereviewList);
		return coursereviewList;
	}

	// 코스 후기 저장
	public int reviewinsert(YysVo yysVo) {
		System.out.println("YysDao.reviewinsert()");

		int count = sqlSession.insert("yys.reviewinsert", yysVo);
		return count;
	}

	// 즐겨찾기 해당 정보 가져오기
	public YysVo favoritesOne(YysVo yVo) {
		System.out.println("YysDao.favoritesOne()");
		// System.out.println(course_no);
		YysVo yysVo = sqlSession.selectOne("yys.favoritesOne", yVo);

		// System.out.println(coursereviewList);
		return yysVo;
	}

	// 즐겨찾기 저장
	public int favoritesinsert(YysVo yysVo) {
		System.out.println("YysDao.favoritesinsert()");

		int count = sqlSession.insert("yys.favoritesinsert", yysVo);
		return count;
	}

	// 즐겨찾기 삭제
	public int favoritesdelete(YysVo yysVo) {
		System.out.println("YysDao.favoritesdelete()");

		int count = sqlSession.delete("yys.favoritesdelete", yysVo);
		return count;
	}

	// 좋아요 저장
	public int likeinsert(YysVo yysVo) {
		System.out.println("YysDao.likeinsert()");

		int count = sqlSession.insert("yys.likeinsert", yysVo);
		return count;
	}

	// 좋아요 삭제
	public int likedelete(YysVo yysVo) {
		System.out.println("YysDao.likedelete()");

		int count = sqlSession.delete("yys.likedelete", yysVo);
		return count;
	}

	// 리스트 조회수 수정
	public int viewmodify(YysVo yysVo) {
		System.out.println("YysDao.viewmodify()");

		int count = sqlSession.insert("yys.viewmodify", yysVo);
		return count;
	}

}
