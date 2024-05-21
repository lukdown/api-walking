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

	// 생성자
	public YysVo() {
		super();
	}

	public YysVo(int course_no, int users_no, int course_favorites_no, int course_like_no, String course_name,
			String course_difficulty, int course_length, String course_time, int course_hit, String course_region,
			String course_date, boolean course_open, String course_introduce, int review_no, String review_content,
			String review_date, String users_name, String users_id, String users_nickname, String users_hp,
			String users_residence) {
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
		this.review_no = review_no;
		this.review_content = review_content;
		this.review_date = review_date;
		this.users_name = users_name;
		this.users_id = users_id;
		this.users_nickname = users_nickname;
		this.users_hp = users_hp;
		this.users_residence = users_residence;
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
				+ ", review_no=" + review_no + ", review_content=" + review_content + ", review_date=" + review_date
				+ ", users_name=" + users_name + ", users_id=" + users_id + ", users_nickname=" + users_nickname
				+ ", users_hp=" + users_hp + ", users_residence=" + users_residence + "]";
	}

	

}
