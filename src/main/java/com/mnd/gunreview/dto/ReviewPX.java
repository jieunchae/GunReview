package com.mnd.gunreview.dto;

import java.util.Date;

public class ReviewPX {
	private int no;
	private String review_content;						
	private Date review_datetime;
	private Date review_modifytime;
	private String review_img;						
	private int review_rate;							
	private String review_userid;				
	private String review_nickname;						
	private Date review_birth;							
	private String review_productname;
	
	public ReviewPX() {
		super();
	}
	
	public ReviewPX(int no, String review_content, Date review_datetime, Date review_modifytime, String review_img,
			int review_rate, String review_userid, String review_nickname, Date review_birth,
			String review_productname) {
		super();
		this.no = no;
		this.review_content = review_content;
		this.review_datetime = review_datetime;
		this.review_modifytime = review_modifytime;
		this.review_img = review_img;
		this.review_rate = review_rate;
		this.review_userid = review_userid;
		this.review_nickname = review_nickname;
		this.review_birth = review_birth;
		this.review_productname = review_productname;
	}
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
	public Date getReview_modifytime() {
		return review_modifytime;
	}
	public void setReview_modifytime(Date review_modifytime) {
		this.review_modifytime = review_modifytime;
	}
	public String getReview_img() {
		return review_img;
	}
	public void setReview_img(String review_img) {
		this.review_img = review_img;
	}
	public int getReview_rate() {
		return review_rate;
	}
	public void setReview_rate(int review_rate) {
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
	public String getReview_productname() {
		return review_productname;
	}
	public void setReview_productname(String review_productname) {
		this.review_productname = review_productname;
	}
}
