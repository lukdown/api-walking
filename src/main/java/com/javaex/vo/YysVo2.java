package com.javaex.vo;

public class YysVo2 {

	// 필드
	// 유저 정보
	private int users_no;
	private String users_id;
	private String users_name;
	private String users_nickname;
	private int users_kcal;
	private int users_length;
	private int login_users_no;
	
	
	// 도전과제
	private int challenge_no;
	private String challenge_name;
	private String filePath;
	private String orgName;
	private String saveName;
	private long fileSize;
	private String challenge_explanation;
	
	private int is_challenge_t_f;
	
	private int small_group_count;
	private int course_users_count;
	private int course_users_sum_hit;
	private int review_users_count;
	private int gallery_users_count;
	
	private int challenge_complete_count;
	private int challenge_count;
	
	
	
	public YysVo2() {
		super();
	}

	public YysVo2(int users_no, String users_id, String users_name, String users_nickname, int users_kcal,
			int users_length, int login_users_no, int challenge_no, String challenge_name, String filePath,
			String orgName, String saveName, long fileSize, String challenge_explanation, int is_challenge_t_f,
			int small_group_count, int course_users_count, int course_users_sum_hit, int review_users_count,
			int gallery_users_count, int challenge_complete_count, int challenge_count) {
		super();
		this.users_no = users_no;
		this.users_id = users_id;
		this.users_name = users_name;
		this.users_nickname = users_nickname;
		this.users_kcal = users_kcal;
		this.users_length = users_length;
		this.login_users_no = login_users_no;
		this.challenge_no = challenge_no;
		this.challenge_name = challenge_name;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
		this.challenge_explanation = challenge_explanation;
		this.is_challenge_t_f = is_challenge_t_f;
		this.small_group_count = small_group_count;
		this.course_users_count = course_users_count;
		this.course_users_sum_hit = course_users_sum_hit;
		this.review_users_count = review_users_count;
		this.gallery_users_count = gallery_users_count;
		this.challenge_complete_count = challenge_complete_count;
		this.challenge_count = challenge_count;
	}




	public int getChallenge_complete_count() {
		return challenge_complete_count;
	}

	public void setChallenge_complete_count(int challenge_complete_count) {
		this.challenge_complete_count = challenge_complete_count;
	}

	public int getChallenge_count() {
		return challenge_count;
	}

	public void setChallenge_count(int challenge_count) {
		this.challenge_count = challenge_count;
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


	public int getUsers_kcal() {
		return users_kcal;
	}


	public void setUsers_kcal(int users_kcal) {
		this.users_kcal = users_kcal;
	}


	public int getUsers_length() {
		return users_length;
	}


	public void setUsers_length(int users_length) {
		this.users_length = users_length;
	}


	public int getLogin_users_no() {
		return login_users_no;
	}


	public void setLogin_users_no(int login_users_no) {
		this.login_users_no = login_users_no;
	}


	public int getChallenge_no() {
		return challenge_no;
	}


	public void setChallenge_no(int challenge_no) {
		this.challenge_no = challenge_no;
	}


	public String getChallenge_name() {
		return challenge_name;
	}


	public void setChallenge_name(String challenge_name) {
		this.challenge_name = challenge_name;
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


	public String getChallenge_explanation() {
		return challenge_explanation;
	}


	public void setChallenge_explanation(String challenge_explanation) {
		this.challenge_explanation = challenge_explanation;
	}


	public int getIs_challenge_t_f() {
		return is_challenge_t_f;
	}


	public void setIs_challenge_t_f(int is_challenge_t_f) {
		this.is_challenge_t_f = is_challenge_t_f;
	}


	public int getSmall_group_count() {
		return small_group_count;
	}


	public void setSmall_group_count(int small_group_count) {
		this.small_group_count = small_group_count;
	}


	public int getCourse_users_count() {
		return course_users_count;
	}


	public void setCourse_users_count(int course_users_count) {
		this.course_users_count = course_users_count;
	}


	public int getCourse_users_sum_hit() {
		return course_users_sum_hit;
	}


	public void setCourse_users_sum_hit(int course_users_sum_hit) {
		this.course_users_sum_hit = course_users_sum_hit;
	}


	public int getReview_users_count() {
		return review_users_count;
	}


	public void setReview_users_count(int review_users_count) {
		this.review_users_count = review_users_count;
	}


	public int getGallery_users_count() {
		return gallery_users_count;
	}


	public void setGallery_users_count(int gallery_users_count) {
		this.gallery_users_count = gallery_users_count;
	}

	@Override
	public String toString() {
		return "YysVo2 [users_no=" + users_no + ", users_id=" + users_id + ", users_name=" + users_name
				+ ", users_nickname=" + users_nickname + ", users_kcal=" + users_kcal + ", users_length=" + users_length
				+ ", login_users_no=" + login_users_no + ", challenge_no=" + challenge_no + ", challenge_name="
				+ challenge_name + ", filePath=" + filePath + ", orgName=" + orgName + ", saveName=" + saveName
				+ ", fileSize=" + fileSize + ", challenge_explanation=" + challenge_explanation + ", is_challenge_t_f="
				+ is_challenge_t_f + ", small_group_count=" + small_group_count + ", course_users_count="
				+ course_users_count + ", course_users_sum_hit=" + course_users_sum_hit + ", review_users_count="
				+ review_users_count + ", gallery_users_count=" + gallery_users_count + ", challenge_complete_count="
				+ challenge_complete_count + ", challenge_count=" + challenge_count + "]";
	}


	

	
}
