package com.javaex.vo;

public class YysVo {

	//필드
	private int course_no;
	private int users_no;
	private String course_name;
	private String course_difficulty;
	private int course_length;
	private String course_time;
	private int course_hit;
	private String course_region;
	private String course_date;
	private boolean course_open;
	private String course_introduce;
	
	//생성자
	public YysVo() {
		super();
	}

	public YysVo(int course_no, int users_no, String course_name, String course_difficulty, int course_length,
			String course_time, int course_hit, String course_region, String course_date, boolean course_open,
			String course_introduce) {
		super();
		this.course_no = course_no;
		this.users_no = users_no;
		this.course_name = course_name;
		this.course_difficulty = course_difficulty;
		this.course_length = course_length;
		this.course_time = course_time;
		this.course_hit = course_hit;
		this.course_region = course_region;
		this.course_date = course_date;
		this.course_open = course_open;
		this.course_introduce = course_introduce;
	}

	//메소드  - g/s
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

	//메소드 - 일반
	@Override
	public String toString() {
		return "YysVo [course_no=" + course_no + ", users_no=" + users_no + ", course_name=" + course_name
				+ ", course_difficulty=" + course_difficulty + ", course_length=" + course_length + ", course_time="
				+ course_time + ", course_hit=" + course_hit + ", course_region=" + course_region + ", course_date="
				+ course_date + ", course_open=" + course_open + ", course_introduce=" + course_introduce + "]";
	}
	
	
}
