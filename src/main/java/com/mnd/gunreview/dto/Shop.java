package com.mnd.gunreview.dto;

import java.util.Date;

public class Shop {
	private String id;
	private String phone;
	private String place_name;
	private String address_name;
	private String road_address_name;
	private String lat;
	private String lng;
	private String category_group_code;
	private String category_group_name;
	private String place_url;
	private String discount;
	private int review_num;
	private double avg_rate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
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

	public String getCategory_group_code() {
		return category_group_code;
	}

	public void setCategory_group_code(String category_group_code) {
		this.category_group_code = category_group_code;
	}

	public String getCategory_group_name() {
		return category_group_name;
	}

	public void setCategory_group_name(String category_group_name) {
		this.category_group_name = category_group_name;
	}

	public String getPlace_url() {
		return place_url;
	}

	public void setPlace_url(String place_url) {
		this.place_url = place_url;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public double getAvg_rate() {
		return avg_rate;
	}

	public void setAvg_rate(double avg_rate) {
		this.avg_rate = avg_rate;
	}

	public Shop(String id, String phone, String place_name, String address_name, String road_address_name, String lat,
			String lng, String category_group_code, String category_group_name, String place_url, String discount,
			int review_num, double avg_rate) {
		super();
		this.id = id;
		this.phone = phone;
		this.place_name = place_name;
		this.address_name = address_name;
		this.road_address_name = road_address_name;
		this.lat = lat;
		this.lng = lng;
		this.category_group_code = category_group_code;
		this.category_group_name = category_group_name;
		this.place_url = place_url;
		this.discount = discount;
		this.review_num = review_num;
		this.avg_rate = avg_rate;
	}

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
