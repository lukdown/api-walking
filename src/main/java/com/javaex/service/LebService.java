package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.LebDao;
import com.javaex.vo.LebVo;

@Service
public class LebService {

	@Autowired
	private LebDao lebDao;

	public int exeCourseDraw(LebVo courseVo) {
		System.out.println("lebService.exeCourseDraw()");
		int result = lebDao.courseDraw(courseVo);
		return result;
	}
	
	public int exeCoursePointDraw(List<LebVo> pointList) {
		System.out.println("lebService.exeCoursePointDraw()");
		for(int i=0; i<pointList.size(); i++) {
			lebDao.coursePointDraw(pointList.get(i));
		}
		return 0;
	}
	

}
