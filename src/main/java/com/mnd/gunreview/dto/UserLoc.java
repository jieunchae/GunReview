package com.mnd.gunreview.dto;

public class UserLoc {
	private String userid;
	private String address_name;
	private String road_address_name;
	private double lat;
	private double lng;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public UserLoc(String userid, String address_name, String road_address_name, double lat, double lng) {
		super();
		this.userid = userid;
		this.address_name = address_name;
		this.road_address_name = road_address_name;
		this.lat = lat;
		this.lng = lng;
	}
	public UserLoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
