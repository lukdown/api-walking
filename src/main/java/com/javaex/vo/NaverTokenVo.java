package com.javaex.vo;

public class NaverTokenVo {

	//필드
	private String access_token;
	private String refresh_token;
	private String token_type;
	private int expires_in;
	
	//생성자
	public NaverTokenVo() {
		super();
	}
	public NaverTokenVo(String access_token, String refresh_token, String token_type, int expires_in) {
		super();
		this.access_token = access_token;
		this.refresh_token = refresh_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
	}
	
	//메소드 - g/s
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
	//메소드 - 일반
	@Override
	public String toString() {
		return "NaverTokenVo [access_token=" + access_token + ", refresh_token=" + refresh_token + ", token_type="
				+ token_type + ", expires_in=" + expires_in + "]";
	}
	
}
