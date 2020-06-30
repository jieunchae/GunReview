package com.mnd.gunreview.dto;

import java.util.Date;

public class User {
	private String userid;
	private Date birth;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public User(String userid, Date birth) {
		super();
		this.userid = userid;
		this.birth = birth;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
