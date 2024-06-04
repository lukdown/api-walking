package com.javaex.vo;

public class PageVo {
	
	//필드
	private int crtPage;
	private String keyword;
	private String category;
	
	//생성자
	public PageVo() {
		super();
	}
	public PageVo(int crtPage, String keyword, String category) {
		super();
		this.crtPage = crtPage;
		this.keyword = keyword;
		this.category = category;
	}
	
	//메소드 G/S
	public int getCrtPage() {
		return crtPage;
	}
	public void setCrtPage(int crtPage) {
		this.crtPage = crtPage;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	//메소드 일반
	@Override
	public String toString() {
		return "PageVo [crtPage=" + crtPage + ", keyword=" + keyword + ", category=" + category + "]";
	}

	

}
