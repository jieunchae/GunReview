package com.mnd.gunreview.dto;

import java.util.Date;

public class Welfare {
	private String id;
	private String kind;
	private String place_name;
	private String event_name;
	private Date start_date;
	private Date finish_date;
	private String phone;
	private String place_url;
	private String detail;
	private String address_name;
	private String road_address_name;
	private String lat;
	private String lng;
	private String rep_img;
	private int review_num;
	private int sum_rate;
	private int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getFinish_date() {
		return finish_date;
	}
	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPlace_url() {
		return place_url;
	}
	public void setPlace_url(String place_url) {
		this.place_url = place_url;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getRoad_address_name() {
		return road_address_name;
	}
	public void setRoad_address_name(String road_address_name) {
		this.road_address_name = road_address_name;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public int getSum_rate() {
		return sum_rate;
	}
	public void setSum_rate(int sum_rate) {
		this.sum_rate = sum_rate;
	}
	
	public String getRep_img() {
		return rep_img;
	}
	public void setRep_img(String rep_img) {
		this.rep_img = rep_img;
	}
	
	public Welfare(String id, String kind, String place_name, String event_name, Date start_date, Date finish_date,
			String phone, String place_url, String detail, String address_name, String road_address_name, String lat,
			String lng, String rep_img, int review_num, int sum_rate, int type) {
		super();
		this.id = id;
		this.kind = kind;
		this.place_name = place_name;
		this.event_name = event_name;
		this.start_date = start_date;
		this.finish_date = finish_date;
		this.phone = phone;
		this.place_url = place_url;
		this.detail = detail;
		this.address_name = address_name;
		this.road_address_name = road_address_name;
		this.lat = lat;
		this.lng = lng;
		this.rep_img = rep_img;
		this.review_num = review_num;
		this.sum_rate = sum_rate;
		this.type = type;
	}
	public Welfare() {
		super();
	}
	
}
