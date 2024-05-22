package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.YdsService;
import com.javaex.util.JsonResult;
import com.javaex.vo.YdsVo;

@RestController
public class YdsController {

	@Autowired
	private YdsService ydsService;

	// 전체 갤러리 리스트 조회
	@GetMapping("/api/gallery")
	public JsonResult list() {
		System.out.println("YdsController.list()");
		List<YdsVo> gList = ydsService.exeAllList();
		System.out.println(gList);
		return JsonResult.success(gList);
	}

	// 이미지 첨부

	@PostMapping("/api/galleryupload")
	public JsonResult galleryUpload(@RequestParam MultipartFile file) {
		System.out.println("YdsController.galleryUpload()");

		System.out.println(file.getOriginalFilename());
		//String gallerySaveName = ydsService.exeUpload(file);

//		return JsonResult.success(gallerySaveName);
		return JsonResult.success(null);
	}



}
// 다솜이꺼
