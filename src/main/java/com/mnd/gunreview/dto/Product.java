package com.mnd.gunreview.dto;

public class Product {
	private int no;
	private int year;
	private int month;
	private String criteria;
	private String name;
	private String detail;
	private int price;
	private int sum_rate;
	private int review_num;
	private String rep_img;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSum_rate() {
		return sum_rate;
	}
	public void setSum_rate(int sum_rate) {
		this.sum_rate = sum_rate;
	}
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public String getRep_img() {
		return rep_img;
	}
	public void setRep_img(String rep_img) {
		this.rep_img = rep_img;
	}
	public Product(int no, int year, int month, String criteria, String name, String detail, int price, int sum_rate,
			int review_num, String rep_img) {
		super();
		this.no = no;
		this.year = year;
		this.month = month;
		this.criteria = criteria;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.sum_rate = sum_rate;
		this.review_num = review_num;
		this.rep_img = rep_img;
	}
	
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [no=" + no + ", year=" + year + ", month=" + month + ", criteria=" + criteria + ", name=" + name
				+ ", detail=" + detail + ", price=" + price + ", sum_rate=" + sum_rate + ", review_num=" + review_num
				+ ", rep_img=" + rep_img + "]";
	}
}
