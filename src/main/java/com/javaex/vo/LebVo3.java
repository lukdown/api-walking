package com.javaex.vo;

public class LebVo3 {
	
	private int record_no;
	private int record_point_no;
	private double record_latitude;
	private double record_longitude;
	private String record_division;
	private int record_order;
	
	
	public LebVo3() {
		super();
	}

	
	public LebVo3(int record_no, int record_point_no, double record_latitude, double record_longitude,
			String record_division, int record_order) {
		super();
		this.record_no = record_no;
		this.record_point_no = record_point_no;
		this.record_latitude = record_latitude;
		this.record_longitude = record_longitude;
		this.record_division = record_division;
		this.record_order = record_order;
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

	public int getRecord_order() {
		return record_order;
	}

	public void setRecord_order(int i) {
		this.record_order = i;
	}

	public int getRecord_no() {
		return record_no;
	}


	public void setRecord_no(int record_no) {
		this.record_no = record_no;
	}


	@Override
	public String toString() {
		return "LebVo3 [record_no=" + record_no + ", record_point_no=" + record_point_no + ", record_latitude="
				+ record_latitude + ", record_longitude=" + record_longitude + ", record_division=" + record_division
				+ ", record_order=" + record_order + "]";
	}


	
}
