package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.KsbVo;
import com.javaex.vo.LebVo;
import com.javaex.vo.LebVo3;
import com.javaex.vo.PjhVo;
import com.javaex.vo.YysVo;

@Repository
public class LebDao {

	@Autowired
	private SqlSession sqlSession;
	
	//네이버 로그인
	public PjhVo userSelscetByNaverId(PjhVo users_listVo) {
		System.out.println("UserDao.userSelscetByNaverId()");

		System.out.println(users_listVo);
		PjhVo authUser = sqlSession.selectOne("pjh.selectBykakakoId", users_listVo);
		System.out.println("qwer"+authUser);

		return authUser;
	}

		
		
		
	/////////////////////////////////////////////////////////////////////////////////
	public int courseDraw(LebVo courseVo) {
		int count = sqlSession.insert("leb.courseDraw", courseVo);
		System.out.println(count);
		return count;
	}
	
	// 코스 포인트리스트 가져오기
		public List<YysVo> coursepointList(int course_no) {
			System.out.println("YysDao.coursepointList()");

			// System.out.println(yysVo);
			List<YysVo> coursepointList = sqlSession.selectList("leb.coursepointList", course_no);

			System.out.println(coursepointList);
			return coursepointList;
		}
	
	public int coursePointDraw(LebVo coursePointVo) {
		int count = sqlSession.insert("leb.coursePointDraw", coursePointVo);
		return count;
	}
	
	public int recordDraw(KsbVo courseVo) {
		System.out.println("LebDao.recordDraw()");
		int count = sqlSession.insert("leb.recordDraw", courseVo);
		System.out.println(count);
		return count;
	}
	
	public int recordPointDraw(LebVo3 coursePointVo) {
		System.out.println("LebDao.recordPointDraw()");
		int count = sqlSession.insert("leb.recordPointDraw", coursePointVo);
		return count;
	}
}
