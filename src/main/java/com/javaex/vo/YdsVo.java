package com.javaex.vo;

public class YdsVo {

	//필드
	private int users_no;
    private String users_nickname;
    private YdsAttachVo users_attach;
    private int gallery_no;
    private YdsAttachVo gallery_attach;
    private int course_no;
    private String course_name;
    private String course_region;
    private int course_length;
    private String course_time;
    private int course_hit;
    private String course_difficulty;
    private String gallery_introduce;
    private String record_date;
    private String challenge_name;
	
    //생성자
    public YdsVo() {
		
	}
    
	public YdsVo(int users_no, String users_nickname, YdsAttachVo users_attach, int gallery_no,
			YdsAttachVo gallery_attach, int course_no, String course_name, String course_region, int course_length,
			String course_time, int course_hit, String course_difficulty, String gallery_introduce, String record_date,
			String challenge_name) {
		
		this.users_no = users_no;
		this.users_nickname = users_nickname;
		this.users_attach = users_attach;
		this.gallery_no = gallery_no;
		this.gallery_attach = gallery_attach;
		this.course_no = course_no;
		this.course_name = course_name;
		this.course_region = course_region;
		this.course_length = course_length;
		this.course_time = course_time;
		this.course_hit = course_hit;
		this.course_difficulty = course_difficulty;
		this.gallery_introduce = gallery_introduce;
		this.record_date = record_date;
		this.challenge_name = challenge_name;
	}

	// g/s
	public int getUsers_no() {
		return users_no;
	}

	public void setUsers_no(int users_no) {
		this.users_no = users_no;
	}

	public String getUsers_nickname() {
		return users_nickname;
	}

	public void setUsers_nickname(String users_nickname) {
		this.users_nickname = users_nickname;
	}

	public YdsAttachVo getUsers_attach() {
		return users_attach;
	}

	public void setUsers_attach(YdsAttachVo users_attach) {
		this.users_attach = users_attach;
	}

	public int getGallery_no() {
		return gallery_no;
	}

	public void setGallery_no(int gallery_no) {
		this.gallery_no = gallery_no;
	}

	public YdsAttachVo getGallery_attach() {
		return gallery_attach;
	}

	public void setGallery_attach(YdsAttachVo gallery_attach) {
		this.gallery_attach = gallery_attach;
	}

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_region() {
		return course_region;
	}

	public void setCourse_region(String course_region) {
		this.course_region = course_region;
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

	public String getCourse_difficulty() {
		return course_difficulty;
	}

	public void setCourse_difficulty(String course_difficulty) {
		this.course_difficulty = course_difficulty;
	}

	public String getGallery_introduce() {
		return gallery_introduce;
	}

	public void setGallery_introduce(String gallery_introduce) {
		this.gallery_introduce = gallery_introduce;
	}

	public String getRecord_date() {
		return record_date;
	}

	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}

	public String getChallenge_name() {
		return challenge_name;
	}

	public void setChallenge_name(String challenge_name) {
		this.challenge_name = challenge_name;
	}

	//일반
	@Override
	public String toString() {
		return "YdsVo [users_no=" + users_no + ", users_nickname=" + users_nickname + ", users_attach=" + users_attach
				+ ", gallery_no=" + gallery_no + ", gallery_attach=" + gallery_attach + ", course_no=" + course_no
				+ ", course_name=" + course_name + ", course_region=" + course_region + ", course_length="
				+ course_length + ", course_time=" + course_time + ", course_hit=" + course_hit + ", course_difficulty="
				+ course_difficulty + ", gallery_introduce=" + gallery_introduce + ", record_date=" + record_date
				+ ", challenge_name=" + challenge_name + "]";
	}
    
	

	
	}

    

	
    
    
	
   
    
    
    
	
	
	
	
	
	
	
	
	

