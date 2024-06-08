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
	private int users_login_type;
	private int facilities_no;
	private int convenient_facilities_type_no;
	private String facilities_name;
	private double facilities_latitude;
	private double facilities_longitude;
	private String facilities_memo;
	private int small_gathering_no;
	private int course_no;
	private String small_gathering_name;
	private String small_gathering_host_name;
	private String small_gathering_hp;
	private int small_gathering_total_personnel;
	private String small_gathering_date;
	private String small_gathering_deadline;
	private String small_gathering_information;
	private String small_gathering_region;
	private String small_gathering_gender_limit;
	private String small_gathering_age_limit;
	private String small_gathering_saveName;
	private String course_name;
	
	private int application_no_count;
	private int login_users_no;
	private int is_application;
	
	private int application_division;
	private String application_date;
	private int category;
	private int application_no;
	
	
	// 생성자
	public PjhVo() {
		super();
	}

	public PjhVo(int users_no, String users_id, String users_pw, String users_name, String users_nickname,
			String users_hp, String users_birth_date, String users_gender, String users_residence,
			String users_filePath, String users_orgName, String users_saveName, String users_fileSize,
			int users_login_type, int facilities_no, int convenient_facilities_type_no, String facilities_name,
			double facilities_latitude, double facilities_longitude, String facilities_memo, int small_gathering_no,
			int course_no, String small_gathering_name, String small_gathering_host_name, String small_gathering_hp,
			int small_gathering_total_personnel, String small_gathering_date, String small_gathering_deadline,
			String small_gathering_information, String small_gathering_region, String small_gathering_gender_limit,
			String small_gathering_age_limit, String small_gathering_saveName, String course_name,
			int application_no_count, int login_users_no, int is_application, int application_division,
			String application_date, int category, int application_no) {
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
		this.users_login_type = users_login_type;
		this.facilities_no = facilities_no;
		this.convenient_facilities_type_no = convenient_facilities_type_no;
		this.facilities_name = facilities_name;
		this.facilities_latitude = facilities_latitude;
		this.facilities_longitude = facilities_longitude;
		this.facilities_memo = facilities_memo;
		this.small_gathering_no = small_gathering_no;
		this.course_no = course_no;
		this.small_gathering_name = small_gathering_name;
		this.small_gathering_host_name = small_gathering_host_name;
		this.small_gathering_hp = small_gathering_hp;
		this.small_gathering_total_personnel = small_gathering_total_personnel;
		this.small_gathering_date = small_gathering_date;
		this.small_gathering_deadline = small_gathering_deadline;
		this.small_gathering_information = small_gathering_information;
		this.small_gathering_region = small_gathering_region;
		this.small_gathering_gender_limit = small_gathering_gender_limit;
		this.small_gathering_age_limit = small_gathering_age_limit;
		this.small_gathering_saveName = small_gathering_saveName;
		this.course_name = course_name;
		this.application_no_count = application_no_count;
		this.login_users_no = login_users_no;
		this.is_application = is_application;
		this.application_division = application_division;
		this.application_date = application_date;
		this.category = category;
		this.application_no = application_no;
	}



	// 메소드 - g/s
	
	public int getApplication_no() {
		return application_no;
	}

	public void setApplication_no(int application_no) {
		this.application_no = application_no;
	}

	public int getIs_application() {
		return is_application;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getApplication_division() {
		return application_division;
	}

	public void setApplication_division(int application_division) {
		this.application_division = application_division;
	}

	public String getApplication_date() {
		return application_date;
	}

	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}

	public void setIs_application(int is_application) {
		this.is_application = is_application;
	}
	
	public int getLogin_users_no() {
		return login_users_no;
	}

	public void setLogin_users_no(int login_users_no) {
		this.login_users_no = login_users_no;
	}

	public int getApplication_no_count() {
		return application_no_count;
	}

	public void setApplication_no_count(int application_no_count) {
		this.application_no_count = application_no_count;
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

	public int getUsers_login_type() {
		return users_login_type;
	}

	public void setUsers_login_type(int users_login_type) {
		this.users_login_type = users_login_type;
	}

	public int getFacilities_no() {
		return facilities_no;
	}

	public void setFacilities_no(int facilities_no) {
		this.facilities_no = facilities_no;
	}

	public int getConvenient_facilities_type_no() {
		return convenient_facilities_type_no;
	}

	public void setConvenient_facilities_type_no(int convenient_facilities_type_no) {
		this.convenient_facilities_type_no = convenient_facilities_type_no;
	}

	public String getFacilities_name() {
		return facilities_name;
	}

	public void setFacilities_name(String facilities_name) {
		this.facilities_name = facilities_name;
	}

	public double getFacilities_latitude() {
		return facilities_latitude;
	}

	public void setFacilities_latitude(double facilities_latitude) {
		this.facilities_latitude = facilities_latitude;
	}

	public double getFacilities_longitude() {
		return facilities_longitude;
	}

	public void setFacilities_longitude(double facilities_longitude) {
		this.facilities_longitude = facilities_longitude;
	}

	public String getFacilities_memo() {
		return facilities_memo;
	}

	public void setFacilities_memo(String facilities_memo) {
		this.facilities_memo = facilities_memo;
	}

	public int getSmall_gathering_no() {
		return small_gathering_no;
	}

	public void setSmall_gathering_no(int small_gathering_no) {
		this.small_gathering_no = small_gathering_no;
	}

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}

	public String getSmall_gathering_name() {
		return small_gathering_name;
	}

	public void setSmall_gathering_name(String small_gathering_name) {
		this.small_gathering_name = small_gathering_name;
	}

	public String getSmall_gathering_host_name() {
		return small_gathering_host_name;
	}

	public void setSmall_gathering_host_name(String small_gathering_host_name) {
		this.small_gathering_host_name = small_gathering_host_name;
	}

	public String getSmall_gathering_hp() {
		return small_gathering_hp;
	}

	public void setSmall_gathering_hp(String small_gathering_hp) {
		this.small_gathering_hp = small_gathering_hp;
	}

	public int getSmall_gathering_total_personnel() {
		return small_gathering_total_personnel;
	}

	public void setSmall_gathering_total_personnel(int small_gathering_total_personnel) {
		this.small_gathering_total_personnel = small_gathering_total_personnel;
	}

	public String getSmall_gathering_date() {
		return small_gathering_date;
	}

	public void setSmall_gathering_date(String small_gathering_date) {
		this.small_gathering_date = small_gathering_date;
	}

	public String getSmall_gathering_deadline() {
		return small_gathering_deadline;
	}

	public void setSmall_gathering_deadline(String small_gathering_deadline) {
		this.small_gathering_deadline = small_gathering_deadline;
	}

	public String getSmall_gathering_information() {
		return small_gathering_information;
	}

	public void setSmall_gathering_information(String small_gathering_information) {
		this.small_gathering_information = small_gathering_information;
	}

	public String getSmall_gathering_region() {
		return small_gathering_region;
	}

	public void setSmall_gathering_region(String small_gathering_region) {
		this.small_gathering_region = small_gathering_region;
	}

	public String getSmall_gathering_gender_limit() {
		return small_gathering_gender_limit;
	}

	public void setSmall_gathering_gender_limit(String small_gathering_gender_limit) {
		this.small_gathering_gender_limit = small_gathering_gender_limit;
	}

	public String getSmall_gathering_age_limit() {
		return small_gathering_age_limit;
	}

	public void setSmall_gathering_age_limit(String small_gathering_age_limit) {
		this.small_gathering_age_limit = small_gathering_age_limit;
	}

	public String getSmall_gathering_saveName() {
		return small_gathering_saveName;
	}

	public void setSmall_gathering_saveName(String small_gathering_saveName) {
		this.small_gathering_saveName = small_gathering_saveName;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@Override
	public String toString() {
		return "PjhVo [users_no=" + users_no + ", users_id=" + users_id + ", users_pw=" + users_pw + ", users_name="
				+ users_name + ", users_nickname=" + users_nickname + ", users_hp=" + users_hp + ", users_birth_date="
				+ users_birth_date + ", users_gender=" + users_gender + ", users_residence=" + users_residence
				+ ", users_filePath=" + users_filePath + ", users_orgName=" + users_orgName + ", users_saveName="
				+ users_saveName + ", users_fileSize=" + users_fileSize + ", users_login_type=" + users_login_type
				+ ", facilities_no=" + facilities_no + ", convenient_facilities_type_no="
				+ convenient_facilities_type_no + ", facilities_name=" + facilities_name + ", facilities_latitude="
				+ facilities_latitude + ", facilities_longitude=" + facilities_longitude + ", facilities_memo="
				+ facilities_memo + ", small_gathering_no=" + small_gathering_no + ", course_no=" + course_no
				+ ", small_gathering_name=" + small_gathering_name + ", small_gathering_host_name="
				+ small_gathering_host_name + ", small_gathering_hp=" + small_gathering_hp
				+ ", small_gathering_total_personnel=" + small_gathering_total_personnel + ", small_gathering_date="
				+ small_gathering_date + ", small_gathering_deadline=" + small_gathering_deadline
				+ ", small_gathering_information=" + small_gathering_information + ", small_gathering_region="
				+ small_gathering_region + ", small_gathering_gender_limit=" + small_gathering_gender_limit
				+ ", small_gathering_age_limit=" + small_gathering_age_limit + ", small_gathering_saveName="
				+ small_gathering_saveName + ", course_name=" + course_name + ", application_no_count="
				+ application_no_count + ", login_users_no=" + login_users_no + ", is_application=" + is_application
				+ ", application_division=" + application_division + ", application_date=" + application_date
				+ ", category=" + category + ", application_no=" + application_no + "]";
	}

	
}
