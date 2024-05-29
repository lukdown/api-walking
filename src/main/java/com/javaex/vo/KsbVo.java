package com.javaex.vo;

public class KsbVo {

	//필드
	
	//유저 정보
	private int users_no;
	private String users_id;
	private String users_pw;
	private String users_name;
	private String users_nickname;
	private String users_hp;
	private String users_birth_date;
	private String users_gender;
	private String users_residence;
	private String filePath;
	private String orgName;
	private String saveName;
	private long fileSize;
	
	//산책기록
	private int record_no;
	private int course_no;
	private String record_date;
	private String record_time;
	private double record_length;
	private int record_kcal;
	private String record_vibe;
	private String record_memo;
	
	//생성자
	public KsbVo(){
		super();
	}

	public KsbVo(int users_no, String users_id, String users_pw, String users_name, String users_nickname,
			String users_hp, String users_birth_date, String users_gender, String users_residence, String filePath,
			String orgName, String saveName, long fileSize) {
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
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
	}
	
	public KsbVo(int users_no, String saveName, String orgName, long fileSize, String filePath) {
		super();
		this.users_no = users_no;
		this.saveName = saveName;
		this.orgName = orgName;
		this.fileSize = fileSize;
		this.filePath = filePath;
	}
	
	public KsbVo(int users_no, int record_no, int course_no, String record_date, String record_time,
			double record_length, int record_kcal, String record_vibe, String record_memo) {
		super();
		this.users_no = users_no;
		this.record_no = record_no;
		this.course_no = course_no;
		this.record_date = record_date;
		this.record_time = record_time;
		this.record_length = record_length;
		this.record_kcal = record_kcal;
		this.record_vibe = record_vibe;
		this.record_memo = record_memo;
	}

	//메소드  - g/s
	
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public int getRecord_no() {
		return record_no;
	}

	public void setRecord_no(int record_no) {
		this.record_no = record_no;
	}

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}

	public String getRecord_date() {
		return record_date;
	}

	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}

	public String getRecord_time() {
		return record_time;
	}

	public void setRecord_time(String record_time) {
		this.record_time = record_time;
	}

	public double getRecord_length() {
		return record_length;
	}

	public void setRecord_length(double record_length) {
		this.record_length = record_length;
	}

	public int getRecord_kcal() {
		return record_kcal;
	}

	public void setRecord_kcal(int record_kcal) {
		this.record_kcal = record_kcal;
	}

	public String getRecord_vibe() {
		return record_vibe;
	}

	public void setRecord_vibe(String record_vibe) {
		this.record_vibe = record_vibe;
	}

	public String getRecord_memo() {
		return record_memo;
	}

	public void setRecord_memo(String record_memo) {
		this.record_memo = record_memo;
	}

	
	//메소드 - 일반
	@Override
	public String toString() {
		return "KsbVo [users_no=" + users_no + ", users_id=" + users_id + ", users_pw=" + users_pw + ", users_name="
				+ users_name + ", users_nickname=" + users_nickname + ", users_hp=" + users_hp + ", users_birth_date="
				+ users_birth_date + ", users_gender=" + users_gender + ", users_residence=" + users_residence
				+ ", filePath=" + filePath + ", orgName=" + orgName + ", saveName=" + saveName + ", fileSize="
				+ fileSize + ", record_no=" + record_no + ", course_no=" + course_no + ", record_date=" + record_date
				+ ", record_time=" + record_time + ", record_length=" + record_length + ", record_kcal=" + record_kcal
				+ ", record_vibe=" + record_vibe + ", record_memo=" + record_memo + "]";
	}

	
	
	
	
	
	
}
