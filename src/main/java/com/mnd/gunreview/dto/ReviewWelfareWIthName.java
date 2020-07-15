package com.mnd.gunreview.dto;

import java.util.Date;

public class ReviewWelfareWIthName {
	private int no;
	private String review_content;						
	private Date review_datetime;
	private String review_img;						
	private double review_rate;									
	private String review_userid;				
	private String review_nickname;						
	private Date review_birth;							
	private String welfare_id;
	private String place_name;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public Date getReview_datetime() {
		return review_datetime;
	}

	public void setReview_datetime(Date review_datetime) {
		this.review_datetime = review_datetime;
	}

	public String getReview_img() {
		return review_img;
	}

	public void setReview_img(String review_img) {
		this.review_img = review_img;
	}

	public double getReview_rate() {
		return review_rate;
	}

	public void setReview_rate(double review_rate) {
		this.review_rate = review_rate;
	}

	public String getReview_userid() {
		return review_userid;
	}

	public void setReview_userid(String review_userid) {
		this.review_userid = review_userid;
	}

	public String getReview_nickname() {
		return review_nickname;
	}

	public void setReview_nickname(String review_nickname) {
		this.review_nickname = review_nickname;
	}

	public Date getReview_birth() {
		return review_birth;
	}

	public void setReview_birth(Date review_birth) {
		this.review_birth = review_birth;
	}

	public String getWelfare_id() {
		return welfare_id;
	}

	public void setWelfare_id(String welfare_id) {
		this.welfare_id = welfare_id;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public ReviewWelfareWIthName(int no, String review_content, Date review_datetime, String review_img,
			double review_rate, String review_userid, String review_nickname, Date review_birth, String welfare_id,
			String place_name) {
		super();
		this.no = no;
		this.review_content = review_content;
		this.review_datetime = review_datetime;
		this.review_img = review_img;
		this.review_rate = review_rate;
		this.review_userid = review_userid;
		this.review_nickname = review_nickname;
		this.review_birth = review_birth;
		this.welfare_id = welfare_id;
		this.place_name = place_name;
	}

	public ReviewWelfareWIthName() {
	}
}
