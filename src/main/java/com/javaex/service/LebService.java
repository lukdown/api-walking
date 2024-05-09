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

	

}
