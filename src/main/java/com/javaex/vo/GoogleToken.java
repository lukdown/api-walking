package com.javaex.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleToken {
	
	private String access_token;
	private String token_type;
	private Integer expires_in;
	private String refresh_token;
	private String scope;
	private String id_token;
	
	public GoogleToken() {
		super();
	}

	public GoogleToken(String access_token, String token_type, Integer expires_in, String refresh_token, String scope,
			String id_token) {
		super();
		this.access_token = access_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
		this.refresh_token = refresh_token;
		this.scope = scope;
		this.id_token = id_token;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getId_token() {
		return id_token;
	}

	public void setId_token(String id_token) {
		this.id_token = id_token;
	}

	@Override
	public String toString() {
		return "GoogleToken [access_token=" + access_token + ", token_type=" + token_type + ", expires_in=" + expires_in
				+ ", refresh_token=" + refresh_token + ", scope=" + scope + ", id_token=" + id_token + "]";
	}
	
}

