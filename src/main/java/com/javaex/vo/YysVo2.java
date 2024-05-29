package com.javaex.vo;

public class YysVo2 {

	// 필드
	private int challenge_no;
	private String challenge_name;
	private String filePath;
	private String orgName;
	private String saveName;
	private long fileSize;
	private String challenge_explanation;
	
	public YysVo2() {
		super();
	}
	public YysVo2(int challenge_no, String challenge_name, String filePath, String orgName, String saveName,
			long fileSize, String challenge_explanation) {
		super();
		this.challenge_no = challenge_no;
		this.challenge_name = challenge_name;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
		this.challenge_explanation = challenge_explanation;
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
	@Override
	public String toString() {
		return "YysVo2 [challenge_no=" + challenge_no + ", challenge_name=" + challenge_name + ", filePath=" + filePath
				+ ", orgName=" + orgName + ", saveName=" + saveName + ", fileSize=" + fileSize
				+ ", challenge_explanation=" + challenge_explanation + "]";
	}
	
}
