package com.javaex.vo;

public class YysVo {

	// 필드
	// 공통
	private int course_no;
	private int users_no;
	private int course_favorites_no;
	private int course_like_no;
	
	// 코스 리스트
	private String course_name;
	private String course_difficulty;
	private int course_length;
	private String course_time;
	private int course_hit;
	private String course_region;
	private String course_date;
	private boolean course_open;
	private String course_introduce;
	private int like_count;
	
	private int write_users_no;
	private int login_users_no;
	
	
	// 리뷰리스트
	private int review_no;
	private String review_content;
	private String review_date;
	
	// 유저 리스트
	private String users_name;
	private String users_id;
	private String users_nickname;
	private String users_hp;
	private String users_residence;
	private String users_saveName;
	
	// 코스 위도 경도
	private int course_point_no;
	private double course_latitude;
	private double course_longitude;
	private int course_order;
	private String course_division;
	
	private int group_num;
	
	private int facilities_no;
	private int convenient_facilities_type_no;
	private String facilities_name;
	private double facilities_latitude;
	private double facilities_longitude;
	private String facilities_memo;
	

	// 생성자
	public YysVo() {
		super();
	}

	public YysVo(int course_no, int users_no, int course_favorites_no, int course_like_no, String course_name,
			String course_difficulty, int course_length, String course_time, int course_hit, String course_region,
			String course_date, boolean course_open, String course_introduce, int like_count, int write_users_no,
			int login_users_no, int review_no, String review_content, String review_date, String users_name,
			String users_id, String users_nickname, String users_hp, String users_residence, String users_saveName,
			int course_point_no, double course_latitude, double course_longitude, int course_order,
			String course_division, int group_num, int facilities_no, int convenient_facilities_type_no,
			String facilities_name, double facilities_latitude, double facilities_longitude, String facilities_memo) {
		super();
		this.course_no = course_no;
		this.users_no = users_no;
		this.course_favorites_no = course_favorites_no;
		this.course_like_no = course_like_no;
		this.course_name = course_name;
		this.course_difficulty = course_difficulty;
		this.course_length = course_length;
		this.course_time = course_time;
		this.course_hit = course_hit;
		this.course_region = course_region;
		this.course_date = course_date;
		this.course_open = course_open;
		this.course_introduce = course_introduce;
		this.like_count = like_count;
		this.write_users_no = write_users_no;
		this.login_users_no = login_users_no;
		this.review_no = review_no;
		this.review_content = review_content;
		this.review_date = review_date;
		this.users_name = users_name;
		this.users_id = users_id;
		this.users_nickname = users_nickname;
		this.users_hp = users_hp;
		this.users_residence = users_residence;
		this.users_saveName = users_saveName;
		this.course_point_no = course_point_no;
		this.course_latitude = course_latitude;
		this.course_longitude = course_longitude;
		this.course_order = course_order;
		this.course_division = course_division;
		this.group_num = group_num;
		this.facilities_no = facilities_no;
		this.convenient_facilities_type_no = convenient_facilities_type_no;
		this.facilities_name = facilities_name;
		this.facilities_latitude = facilities_latitude;
		this.facilities_longitude = facilities_longitude;
		this.facilities_memo = facilities_memo;
	}





	public String getUsers_saveName() {
		return users_saveName;
	}

	public void setUsers_saveName(String users_saveName) {
		this.users_saveName = users_saveName;
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


	public int getGroup_num() {
		return group_num;
	}

	public void setGroup_num(int group_num) {
		this.group_num = group_num;
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



	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}

	public int getUsers_no() {
		return users_no;
	}

	public void setUsers_no(int users_no) {
		this.users_no = users_no;
	}

	public int getCourse_favorites_no() {
		return course_favorites_no;
	}

	public void setCourse_favorites_no(int course_favorites_no) {
		this.course_favorites_no = course_favorites_no;
	}

	public int getCourse_like_no() {
		return course_like_no;
	}

	public void setCourse_like_no(int course_like_no) {
		this.course_like_no = course_like_no;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_difficulty() {
		return course_difficulty;
	}

	public void setCourse_difficulty(String course_difficulty) {
		this.course_difficulty = course_difficulty;
	}

	public int getCourse_length() {
		return course_length;
	}

	public void setCourse_length(int course_length) {
		this.course_length = course_length;
	}

	public String getCourse_time() {
		return course_time;
	}

	public void setCourse_time(String course_time) {
		this.course_time = course_time;
	}

	public int getCourse_hit() {
		return course_hit;
	}

	public void setCourse_hit(int course_hit) {
		this.course_hit = course_hit;
	}

	public String getCourse_region() {
		return course_region;
	}

	public void setCourse_region(String course_region) {
		this.course_region = course_region;
	}

	public String getCourse_date() {
		return course_date;
	}

	public void setCourse_date(String course_date) {
		this.course_date = course_date;
	}

	public boolean isCourse_open() {
		return course_open;
	}

	public void setCourse_open(boolean course_open) {
		this.course_open = course_open;
	}

	public String getCourse_introduce() {
		return course_introduce;
	}

	public void setCourse_introduce(String course_introduce) {
		this.course_introduce = course_introduce;
	}

	public int getWrite_users_no() {
		return write_users_no;
	}

	public void setWrite_users_no(int write_users_no) {
		this.write_users_no = write_users_no;
	}

	public int getLogin_users_no() {
		return login_users_no;
	}

	public void setLogin_users_no(int login_users_no) {
		this.login_users_no = login_users_no;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	
	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_date() {
		return review_date;
	}

	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}

	public String getUsers_name() {
		return users_name;
	}

	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	public String getUsers_id() {
		return users_id;
	}

	public void setUsers_id(String users_id) {
		this.users_id = users_id;
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

	public String getUsers_residence() {
		return users_residence;
	}

	public void setUsers_residence(String users_residence) {
		this.users_residence = users_residence;
	}

	@Override
	public String toString() {
		return "YysVo [course_no=" + course_no + ", users_no=" + users_no + ", course_favorites_no="
				+ course_favorites_no + ", course_like_no=" + course_like_no + ", course_name=" + course_name
				+ ", course_difficulty=" + course_difficulty + ", course_length=" + course_length + ", course_time="
				+ course_time + ", course_hit=" + course_hit + ", course_region=" + course_region + ", course_date="
				+ course_date + ", course_open=" + course_open + ", course_introduce=" + course_introduce
				+ ", like_count=" + like_count + ", write_users_no=" + write_users_no + ", login_users_no="
				+ login_users_no + ", review_no=" + review_no + ", review_content=" + review_content + ", review_date="
				+ review_date + ", users_name=" + users_name + ", users_id=" + users_id + ", users_nickname="
				+ users_nickname + ", users_hp=" + users_hp + ", users_residence=" + users_residence
				+ ", users_saveName=" + users_saveName + ", course_point_no=" + course_point_no + ", course_latitude="
				+ course_latitude + ", course_longitude=" + course_longitude + ", course_order=" + course_order
				+ ", course_division=" + course_division + ", group_num=" + group_num + ", facilities_no="
				+ facilities_no + ", convenient_facilities_type_no=" + convenient_facilities_type_no
				+ ", facilities_name=" + facilities_name + ", facilities_latitude=" + facilities_latitude
				+ ", facilities_longitude=" + facilities_longitude + ", facilities_memo=" + facilities_memo + "]";
	}




}
