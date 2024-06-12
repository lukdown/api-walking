package com.javaex.vo;
import java.util.List;

public class YdsVo {

	// 필드
	// 갤러리필드
	private int gallery_no;
	private String gallery_introduce;
	private String gallery_filePath;
	private String gallery_orgName;
	private String gallery_saveName;
	private long gallery_fileSize;
	
	private int course_no;
	private String course_name;
	private String course_region;
	private int course_length;
	private String course_time;
	private int course_hit;
	private String course_difficulty;
	private int users_no;
	private String users_nickname;
	private String users_orgName;
	private String users_saveName;
	private String users_filePath;
	private long users_fileSize;
	private YdsAttachVo gallery_attach;
	
	
	private String record_date;
	private String challenge_name;
	
	private String saveName;
	
	
	private List<YdsAttachVo> tList;
	
	private int gallery_likeCount;
	

	// 생성자
	public YdsVo() {

	}



	public YdsVo(int gallery_no, String gallery_introduce, String gallery_filePath, String gallery_orgName,
			String gallery_saveName, long gallery_fileSize, int course_no, String course_name, String course_region,
			int course_length, String course_time, int course_hit, String course_difficulty, int users_no,
			String users_nickname, String users_orgName, String users_saveName, String users_filePath,
			long users_fileSize, YdsAttachVo gallery_attach, String record_date, String challenge_name, String saveName,
			List<YdsAttachVo> tList, int gallery_likeCount) {
		super();
		this.gallery_no = gallery_no;
		this.gallery_introduce = gallery_introduce;
		this.gallery_filePath = gallery_filePath;
		this.gallery_orgName = gallery_orgName;
		this.gallery_saveName = gallery_saveName;
		this.gallery_fileSize = gallery_fileSize;
		this.course_no = course_no;
		this.course_name = course_name;
		this.course_region = course_region;
		this.course_length = course_length;
		this.course_time = course_time;
		this.course_hit = course_hit;
		this.course_difficulty = course_difficulty;
		this.users_no = users_no;
		this.users_nickname = users_nickname;
		this.users_orgName = users_orgName;
		this.users_saveName = users_saveName;
		this.users_filePath = users_filePath;
		this.users_fileSize = users_fileSize;
		this.gallery_attach = gallery_attach;
		this.record_date = record_date;
		this.challenge_name = challenge_name;
		this.saveName = saveName;
		this.tList = tList;
		this.gallery_likeCount = gallery_likeCount;
	}



	public String getSaveName() {
		return saveName;
	}



	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}



	public int getGallery_likeCount() {
		return gallery_likeCount;
	}


	public void setGallery_likeCount(int gallery_likeCount) {
		this.gallery_likeCount = gallery_likeCount;
	}


	public List<YdsAttachVo> gettList() {
		return tList;
	}


	public void settList(List<YdsAttachVo> tList) {
		this.tList = tList;
	}


	public String getGallery_filePath() {
		return gallery_filePath;
	}

	public void setGallery_filePath(String gallery_filePath) {
		this.gallery_filePath = gallery_filePath;
	}

	public String getGallery_orgName() {
		return gallery_orgName;
	}

	public void setGallery_orgName(String gallery_orgName) {
		this.gallery_orgName = gallery_orgName;
	}

	public String getGallery_saveName() {
		return gallery_saveName;
	}

	public void setGallery_saveName(String gallery_saveName) {
		this.gallery_saveName = gallery_saveName;
	}

	public long getGallery_fileSize() {
		return gallery_fileSize;
	}

	public void setGallery_fileSize(long gallery_fileSize) {
		this.gallery_fileSize = gallery_fileSize;
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

	public String getUsers_filePath() {
		return users_filePath;
	}

	public void setUsers_filePath(String users_filePath) {
		this.users_filePath = users_filePath;
	}

	public long getUsers_fileSize() {
		return users_fileSize;
	}

	public void setUsers_fileSize(long users_fileSize) {
		this.users_fileSize = users_fileSize;
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

	@Override
	public String toString() {
		return "YdsVo [gallery_no=" + gallery_no + ", gallery_introduce=" + gallery_introduce + ", gallery_filePath="
				+ gallery_filePath + ", gallery_orgName=" + gallery_orgName + ", gallery_saveName=" + gallery_saveName
				+ ", gallery_fileSize=" + gallery_fileSize + ", course_no=" + course_no + ", course_name=" + course_name
				+ ", course_region=" + course_region + ", course_length=" + course_length + ", course_time="
				+ course_time + ", course_hit=" + course_hit + ", course_difficulty=" + course_difficulty
				+ ", users_no=" + users_no + ", users_nickname=" + users_nickname + ", users_orgName=" + users_orgName
				+ ", users_saveName=" + users_saveName + ", users_filePath=" + users_filePath + ", users_fileSize="
				+ users_fileSize + ", gallery_attach=" + gallery_attach + ", record_date=" + record_date
				+ ", challenge_name=" + challenge_name + ", saveName=" + saveName + ", tList=" + tList
				+ ", gallery_likeCount=" + gallery_likeCount + "]";
	}


}
