package com.mnd.gunreview.dto;

public class PX {
	private int no;
	private int year;
	private int month;
	private String criteria;
	private String name;
	
	public PX(int no, int year, int month, String criteria, String name) {
		super();
		this.no = no;
		this.year = year;
		this.month = month;
		this.criteria = criteria;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
