package com.javaex.vo;

public class LebVo4 {
	private double course_latitude;
	private double course_longitude;
	private int course_order;
	private String course_division;
	public LebVo4(double course_latitude, double course_longitude, int course_order,
			String course_division) {
		super();
		this.course_latitude = course_latitude;
		this.course_longitude = course_longitude;
		this.course_order = course_order;
		this.course_division = course_division;
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
	@Override
	public String toString() {
		return "LebVo4 [course_latitude=" + course_latitude
				+ ", course_longitude=" + course_longitude + ", course_order=" + course_order + ", course_division="
				+ course_division + "]";
	}
	
}
