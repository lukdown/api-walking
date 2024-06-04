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
	private String course_name;
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
	
	//도전과제
	private int person_no;
	private int challenge_no;
	private String challenge_name;
	private String challenge_filePath;
	private String challenge_orgName;
	private String challenge_saveName;
	private long challenge_fileSize;
	private String challenge_explanation;
	

	//소모임
	private int small_gathering_no;
	private String small_gathering_name;
	private String small_gathering_host_name;
	private int small_gathering_total_personnel;
	private String small_gathering_date;
	private String small_gathering_deadline;
	private String small_gathering_region;
	private String small_gatheringn_saveName;
	private String small_gathering_information;
	private String small_gathering_gender_limit;
	private String small_gathering_age_limit;
	private String small_gathering_hp;
	private String small_gathering_filePath;
	private String small_gathering_orgName;
	private String small_gathering_listcol;
	
	
	



	// 생성자
	public KsbVo() {
		super();
	}

	public KsbVo(int users_no, String users_id, String users_pw, String users_name, String users_nickname,
			String users_hp, String users_birth_date, String users_gender, String users_residence, String filePath,
			String orgName, String saveName, long fileSize, int record_no, int course_no, String course_name,
			String record_date, String record_time, double record_length, int record_kcal, String record_vibe,
			String record_memo, int record_point_no, double record_latitude, double record_longitude,
			String record_division, String record_order, int course_point_no, double course_latitude,
			double course_longitude, int course_order, String course_division, int person_no, int challenge_no,
			String challenge_name, String challenge_filePath, String challenge_orgName, String challenge_saveName,
			long challenge_fileSize, String challenge_explanation, int small_gathering_no, String small_gathering_name,
			String small_gathering_host_name, int small_gathering_total_personnel, String small_gathering_date,
			String small_gathering_deadline, String small_gathering_region, String small_gatheringn_saveName,
			String small_gathering_information, String small_gathering_gender_limit, String small_gathering_age_limit,
			String small_gathering_hp, String small_gathering_filePath, String small_gathering_orgName,
			String small_gathering_listcol) {
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
		this.course_name = course_name;
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
		this.person_no = person_no;
		this.challenge_no = challenge_no;
		this.challenge_name = challenge_name;
		this.challenge_filePath = challenge_filePath;
		this.challenge_orgName = challenge_orgName;
		this.challenge_saveName = challenge_saveName;
		this.challenge_fileSize = challenge_fileSize;
		this.challenge_explanation = challenge_explanation;
		this.small_gathering_no = small_gathering_no;
		this.small_gathering_name = small_gathering_name;
		this.small_gathering_host_name = small_gathering_host_name;
		this.small_gathering_total_personnel = small_gathering_total_personnel;
		this.small_gathering_date = small_gathering_date;
		this.small_gathering_deadline = small_gathering_deadline;
		this.small_gathering_region = small_gathering_region;
		this.small_gatheringn_saveName = small_gatheringn_saveName;
		this.small_gathering_information = small_gathering_information;
		this.small_gathering_gender_limit = small_gathering_gender_limit;
		this.small_gathering_age_limit = small_gathering_age_limit;
		this.small_gathering_hp = small_gathering_hp;
		this.small_gathering_filePath = small_gathering_filePath;
		this.small_gathering_orgName = small_gathering_orgName;
		this.small_gathering_listcol = small_gathering_listcol;
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


	public int getPerson_no() {
		return person_no;
	}

	public void setPerson_no(int person_no) {
		this.person_no = person_no;
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

	public String getChallenge_filePath() {
		return challenge_filePath;
	}

	public void setChallenge_filePath(String challenge_filePath) {
		this.challenge_filePath = challenge_filePath;
	}

	public String getChallenge_orgName() {
		return challenge_orgName;
	}

	public void setChallenge_orgName(String challenge_orgName) {
		this.challenge_orgName = challenge_orgName;
	}

	public String getChallenge_saveName() {
		return challenge_saveName;
	}

	public void setChallenge_saveName(String challenge_saveName) {
		this.challenge_saveName = challenge_saveName;
	}

	public long getChallenge_fileSize() {
		return challenge_fileSize;
	}

	public void setChallenge_fileSize(long challenge_fileSize) {
		this.challenge_fileSize = challenge_fileSize;
	}

	public String getChallenge_explanation() {
		return challenge_explanation;
	}

	public void setChallenge_explanation(String challenge_explanation) {
		this.challenge_explanation = challenge_explanation;
	}
	
	

	public int getSmall_gathering_no() {
		return small_gathering_no;
	}




	public void setSmall_gathering_no(int small_gathering_no) {
		this.small_gathering_no = small_gathering_no;
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




	public String getSmall_gathering_region() {
		return small_gathering_region;
	}




	public void setSmall_gathering_region(String small_gathering_region) {
		this.small_gathering_region = small_gathering_region;
	}




	public String getSmall_gatheringn_saveName() {
		return small_gatheringn_saveName;
	}




	public void setSmall_gatheringn_saveName(String small_gatheringn_saveName) {
		this.small_gatheringn_saveName = small_gatheringn_saveName;
	}




	public String getSmall_gathering_information() {
		return small_gathering_information;
	}




	public void setSmall_gathering_information(String small_gathering_information) {
		this.small_gathering_information = small_gathering_information;
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




	public String getSmall_gathering_hp() {
		return small_gathering_hp;
	}




	public void setSmall_gathering_hp(String small_gathering_hp) {
		this.small_gathering_hp = small_gathering_hp;
	}




	public String getSmall_gathering_filePath() {
		return small_gathering_filePath;
	}




	public void setSmall_gathering_filePath(String small_gathering_filePath) {
		this.small_gathering_filePath = small_gathering_filePath;
	}




	public String getSmall_gathering_orgName() {
		return small_gathering_orgName;
	}




	public void setSmall_gathering_orgName(String small_gathering_orgName) {
		this.small_gathering_orgName = small_gathering_orgName;
	}




	public String getSmall_gathering_listcol() {
		return small_gathering_listcol;
	}




	public void setSmall_gathering_listcol(String small_gathering_listcol) {
		this.small_gathering_listcol = small_gathering_listcol;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@Override
	public String toString() {
		return "KsbVo [users_no=" + users_no + ", users_id=" + users_id + ", users_pw=" + users_pw + ", users_name="
				+ users_name + ", users_nickname=" + users_nickname + ", users_hp=" + users_hp + ", users_birth_date="
				+ users_birth_date + ", users_gender=" + users_gender + ", users_residence=" + users_residence
				+ ", filePath=" + filePath + ", orgName=" + orgName + ", saveName=" + saveName + ", fileSize="
				+ fileSize + ", record_no=" + record_no + ", course_no=" + course_no + ", course_name=" + course_name
				+ ", record_date=" + record_date + ", record_time=" + record_time + ", record_length=" + record_length
				+ ", record_kcal=" + record_kcal + ", record_vibe=" + record_vibe + ", record_memo=" + record_memo
				+ ", record_point_no=" + record_point_no + ", record_latitude=" + record_latitude
				+ ", record_longitude=" + record_longitude + ", record_division=" + record_division + ", record_order="
				+ record_order + ", course_point_no=" + course_point_no + ", course_latitude=" + course_latitude
				+ ", course_longitude=" + course_longitude + ", course_order=" + course_order + ", course_division="
				+ course_division + ", person_no=" + person_no + ", challenge_no=" + challenge_no + ", challenge_name="
				+ challenge_name + ", challenge_filePath=" + challenge_filePath + ", challenge_orgName="
				+ challenge_orgName + ", challenge_saveName=" + challenge_saveName + ", challenge_fileSize="
				+ challenge_fileSize + ", challenge_explanation=" + challenge_explanation + ", small_gathering_no="
				+ small_gathering_no + ", small_gathering_name=" + small_gathering_name + ", small_gathering_host_name="
				+ small_gathering_host_name + ", small_gathering_total_personnel=" + small_gathering_total_personnel
				+ ", small_gathering_date=" + small_gathering_date + ", small_gathering_deadline="
				+ small_gathering_deadline + ", small_gathering_region=" + small_gathering_region
				+ ", small_gatheringn_saveName=" + small_gatheringn_saveName + ", small_gathering_information="
				+ small_gathering_information + ", small_gathering_gender_limit=" + small_gathering_gender_limit
				+ ", small_gathering_age_limit=" + small_gathering_age_limit + ", small_gathering_hp="
				+ small_gathering_hp + ", small_gathering_filePath=" + small_gathering_filePath
				+ ", small_gathering_orgName=" + small_gathering_orgName + ", small_gathering_listcol="
				+ small_gathering_listcol + "]";
	}

	
}