package com.javaex.vo;

public class KsbVo {

	// 필드

	// 유저 정보
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

	// 산책기록
	private int record_no;
	private int course_no;
	private String record_date;
	private String record_time;
	private double record_length;
	private int record_kcal;
	private String record_vibe;
	private String record_memo;

	// 산책기록 좌표
	private int record_point_no;
	private double record_latitude;
	private double record_longitude;
	private String record_division;
	private String record_order;
	
	//코스포인트
	
	private int course_point_no;
	private double course_latitude;
	private double course_longitude;
	private int course_order;
	private String course_division;
	

	// 생성자
	public KsbVo() {
		super();
	}


	public KsbVo(int users_no, String users_id, String users_pw, String users_name, String users_nickname,
			String users_hp, String users_birth_date, String users_gender, String users_residence, String filePath,
			String orgName, String saveName, long fileSize, int record_no, int course_no, String record_date,
			String record_time, double record_length, int record_kcal, String record_vibe, String record_memo,
			int record_point_no, double record_latitude, double record_longitude, String record_division,
			String record_order, int course_point_no, double course_latitude, double course_longitude, int course_order,
			String course_division) {
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
		this.record_no = record_no;
		this.course_no = course_no;
		this.record_date = record_date;
		this.record_time = record_time;
		this.record_length = record_length;
		this.record_kcal = record_kcal;
		this.record_vibe = record_vibe;
		this.record_memo = record_memo;
		this.record_point_no = record_point_no;
		this.record_latitude = record_latitude;
		this.record_longitude = record_longitude;
		this.record_division = record_division;
		this.record_order = record_order;
		this.course_point_no = course_point_no;
		this.course_latitude = course_latitude;
		this.course_longitude = course_longitude;
		this.course_order = course_order;
		this.course_division = course_division;
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


	public int getRecord_point_no() {
		return record_point_no;
	}


	public void setRecord_point_no(int record_point_no) {
		this.record_point_no = record_point_no;
	}


	public double getRecord_latitude() {
		return record_latitude;
	}


	public void setRecord_latitude(double record_latitude) {
		this.record_latitude = record_latitude;
	}


	public double getRecord_longitude() {
		return record_longitude;
	}


	public void setRecord_longitude(double record_longitude) {
		this.record_longitude = record_longitude;
	}


	public String getRecord_division() {
		return record_division;
	}


	public void setRecord_division(String record_division) {
		this.record_division = record_division;
	}


	public String getRecord_order() {
		return record_order;
	}


	public void setRecord_order(String record_order) {
		this.record_order = record_order;
	}


	public int getCourse_point_no() {
		return course_point_no;
	}


	public void setCourse_point_no(int course_point_no) {
		this.course_point_no = course_point_no;
	}


	public double getCourse_latitude() {
		return course_latitude;
	}


	public void setCourse_latitude(double course_latitude) {
		this.course_latitude = course_latitude;
	}


	public double getCourse_longitude() {
		return course_longitude;
	}


	public void setCourse_longitude(double course_longitude) {
		this.course_longitude = course_longitude;
	}


	public int getCourse_order() {
		return course_order;
	}


	public void setCourse_order(int course_order) {
		this.course_order = course_order;
	}


	public String getCourse_division() {
		return course_division;
	}


	public void setCourse_division(String course_division) {
		this.course_division = course_division;
	}


	@Override
	public String toString() {
		return "KsbVo [users_no=" + users_no + ", users_id=" + users_id + ", users_pw=" + users_pw + ", users_name="
				+ users_name + ", users_nickname=" + users_nickname + ", users_hp=" + users_hp + ", users_birth_date="
				+ users_birth_date + ", users_gender=" + users_gender + ", users_residence=" + users_residence
				+ ", filePath=" + filePath + ", orgName=" + orgName + ", saveName=" + saveName + ", fileSize="
				+ fileSize + ", record_no=" + record_no + ", course_no=" + course_no + ", record_date=" + record_date
				+ ", record_time=" + record_time + ", record_length=" + record_length + ", record_kcal=" + record_kcal
				+ ", record_vibe=" + record_vibe + ", record_memo=" + record_memo + ", record_point_no="
				+ record_point_no + ", record_latitude=" + record_latitude + ", record_longitude=" + record_longitude
				+ ", record_division=" + record_division + ", record_order=" + record_order + ", course_point_no="
				+ course_point_no + ", course_latitude=" + course_latitude + ", course_longitude=" + course_longitude
				+ ", course_order=" + course_order + ", course_division=" + course_division + "]";
	}
	
	
	
	
	
}