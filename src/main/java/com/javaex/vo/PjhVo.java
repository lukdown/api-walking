package com.javaex.vo;

public class PjhVo {

	// 필드
	private int users_no;
	private String users_id;
	private String users_pw;
	private String users_name;
	private String users_nickname;
	private String users_hp;
	private String users_birth_date;
	private String users_gender;
	private String users_residence;
	private String users_filePath;
	private String users_orgName;
	private String users_saveName;
	private String users_fileSize;

	// 생성자
	public PjhVo() {
		super();
	}

	public PjhVo(int users_no, String users_id, String users_pw, String users_name, String users_nickname,
			String users_hp, String users_birth_date, String users_gender, String users_residence,
			String users_filePath, String users_orgName, String users_saveName, String users_fileSize) {
		super();
		this.users_no = users_no;
		this.users_id = users_id;
		this.users_pw = users_pw;
		this.users_name = users_name;
		this.users_nickname = users_nickname;
		this.users_hp = users_hp;
		this.users_birth_date = users_birth_date;
		this.users_gender = users_gender;
		this.users_residence = users_residence;
		this.users_filePath = users_filePath;
		this.users_orgName = users_orgName;
		this.users_saveName = users_saveName;
		this.users_fileSize = users_fileSize;
	}

	// 메소드 - g/s
	public int getUsers_no() {
		return users_no;
	}

	public void setUsers_no(int users_no) {
		this.users_no = users_no;
	}

	public String getUsers_id() {
		return users_id;
	}

	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}

	public String getUsers_pw() {
		return users_pw;
	}

	public void setUsers_pw(String users_pw) {
		this.users_pw = users_pw;
	}

	public String getUsers_name() {
		return users_name;
	}

	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	public String getUsers_nickname() {
		return users_nickname;
	}

	public void setUsers_nickname(String users_nickname) {
		this.users_nickname = users_nickname;
	}

	public String getUsers_hp() {
		return users_hp;
	}

	public void setUsers_hp(String users_hp) {
		this.users_hp = users_hp;
	}

	public String getUsers_birth_date() {
		return users_birth_date;
	}

	public void setUsers_birth_date(String users_birth_date) {
		this.users_birth_date = users_birth_date;
	}

	public String getUsers_gender() {
		return users_gender;
	}

	public void setUsers_gender(String users_gender) {
		this.users_gender = users_gender;
	}

	public String getUsers_residence() {
		return users_residence;
	}

	public void setUsers_residence(String users_residence) {
		this.users_residence = users_residence;
	}

	public String getUsers_filePath() {
		return users_filePath;
	}

	public void setUsers_filePath(String users_filePath) {
		this.users_filePath = users_filePath;
	}

	public String getUsers_orgName() {
		return users_orgName;
	}

	public void setUsers_orgName(String users_orgName) {
		this.users_orgName = users_orgName;
	}

	public String getUsers_saveName() {
		return users_saveName;
	}

	public void setUsers_saveName(String users_saveName) {
		this.users_saveName = users_saveName;
	}

	public String getUsers_fileSize() {
		return users_fileSize;
	}

	public void setUsers_fileSize(String users_fileSize) {
		this.users_fileSize = users_fileSize;
	}

	@Override
	public String toString() {
		return "PjhVo [users_no=" + users_no + ", users_id=" + users_id + ", users_pw=" + users_pw + ", users_name="
				+ users_name + ", users_nickname=" + users_nickname + ", users_hp=" + users_hp + ", users_birth_date="
				+ users_birth_date + ", users_gender=" + users_gender + ", users_residence=" + users_residence
				+ ", users_filePath=" + users_filePath + ", users_orgName=" + users_orgName + ", users_saveName="
				+ users_saveName + ", users_fileSize=" + users_fileSize + "]";
	}

	// 메소드 - 일반

}
