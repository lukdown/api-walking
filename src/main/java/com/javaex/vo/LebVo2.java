package com.javaex.vo;

import java.util.List;

public class LebVo2 {

	//필드
	private KsbVo recordVo;
	private List<LebVo3> recordPointList;
	

	//생성자
	public LebVo2() {
		super();
	}

	public LebVo2(KsbVo recordVo, List<LebVo3> recordPointList) {
		super();
		this.recordVo = recordVo;
		this.recordPointList = recordPointList;
	}
	
	//메소드 - g/s
	public KsbVo getRecordVo() {
		return recordVo;
	}
	public void setRecordVo(KsbVo recordVo) {
		this.recordVo = recordVo;
	}
	public List<LebVo3> getRecordPointList() {
		return recordPointList;
	}
	public void setRecordPointList(List<LebVo3> recordPointList) {
		this.recordPointList = recordPointList;
	}
	
	
	//메소드 - 일반
	@Override
	public String toString() {
		return "LebVo2 [recordVo=" + recordVo + ", recordPointList=" + recordPointList + "]";
	}
}

