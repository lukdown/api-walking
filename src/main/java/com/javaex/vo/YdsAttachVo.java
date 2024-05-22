package com.javaex.vo;

public class YdsAttachVo {
	
	//필드
    private String gallery_orgName;
    private String gallery_saveName;
    private String gallery_filePath;
    private long gallery_fileSize;

    private String users_orgName;
    private String users_saveName;
    private String users_filePath;
    private long users_fileSize;
	
    //생성자
    public YdsAttachVo() {
		
	}
	public YdsAttachVo(String gallery_orgName, String gallery_saveName, String gallery_filePath, long gallery_fileSize,
			String users_orgName, String users_saveName, String users_filePath, long users_fileSize) {
		
		this.gallery_orgName = gallery_orgName;
		this.gallery_saveName = gallery_saveName;
		this.gallery_filePath = gallery_filePath;
		this.gallery_fileSize = gallery_fileSize;
		this.users_orgName = users_orgName;
		this.users_saveName = users_saveName;
		this.users_filePath = users_filePath;
		this.users_fileSize = users_fileSize;
	}
	
	// g/s
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
	public String getGallery_filePath() {
		return gallery_filePath;
	}
	public void setGallery_filePath(String gallery_filePath) {
		this.gallery_filePath = gallery_filePath;
	}
	public long getGallery_fileSize() {
		return gallery_fileSize;
	}
	public void setGallery_fileSize(long gallery_fileSize) {
		this.gallery_fileSize = gallery_fileSize;
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
	
	//일반
	@Override
	public String toString() {
		return "YdsAttachVo [gallery_orgName=" + gallery_orgName + ", gallery_saveName=" + gallery_saveName
				+ ", gallery_filePath=" + gallery_filePath + ", gallery_fileSize=" + gallery_fileSize
				+ ", users_orgName=" + users_orgName + ", users_saveName=" + users_saveName + ", users_filePath="
				+ users_filePath + ", users_fileSize=" + users_fileSize + "]";
	}
    
    
    

}
