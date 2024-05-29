package com.javaex.vo;

public class YdsAttachVo {
	
	//필드
	private int gallery_no;
	private String gallery_filePath;
	private String gallery_orgName;
	private String gallery_saveName;
    private long gallery_fileSize;

    
	
    //생성자
    public YdsAttachVo() {
		
	}



	public YdsAttachVo(int gallery_no, String gallery_filePath, String gallery_orgName, String gallery_saveName,
			long gallery_fileSize) {
		
		this.gallery_no = gallery_no;
		this.gallery_filePath = gallery_filePath;
		this.gallery_orgName = gallery_orgName;
		this.gallery_saveName = gallery_saveName;
		this.gallery_fileSize = gallery_fileSize;
	}



	// g/s
	public int getGallery_no() {
		return gallery_no;
	}



	public void setGallery_no(int gallery_no) {
		this.gallery_no = gallery_no;
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



	//일반
	@Override
	public String toString() {
		return "YdsAttachVo [gallery_no=" + gallery_no + ", gallery_filePath=" + gallery_filePath + ", gallery_orgName="
				+ gallery_orgName + ", gallery_saveName=" + gallery_saveName + ", gallery_fileSize=" + gallery_fileSize
				+ "]";
	}


    
	

	
}
