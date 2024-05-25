package com.javaex.vo;

import java.util.List;

public class YdsAttachListVo {
	
	//필드
	private List<YdsAttachVo> attachVoList;
	
	
	//생성자
	public YdsAttachListVo() {
		
	}

	public YdsAttachListVo(List<YdsAttachVo> attachVoList) {
		
		this.attachVoList = attachVoList;
	}

	// g/s
	public List<YdsAttachVo> getAttachVoList() {
		return attachVoList;
	}

	public void setAttachVoList(List<YdsAttachVo> attachVoList) {
		this.attachVoList = attachVoList;
	}

	//일반
	@Override
	public String toString() {
		return "YdsAttachListVo [attachVoList=" + attachVoList + "]";
	}

	
	

	
	
	
	

}
