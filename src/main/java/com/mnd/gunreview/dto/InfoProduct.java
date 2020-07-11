package com.mnd.gunreview.dto;

public class InfoProduct {
	private int no;
	private String name;
	private String detail;
	private int price;
	private int sum_rate;
	private int review_num;
	private String rep_img;
	
	public InfoProduct(int no, String name, String detail, int price, int sum_rate, int review_num, String rep_img) {
		super();
		this.no = no;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.sum_rate = sum_rate;
		this.review_num = review_num;
		this.rep_img = rep_img;
	}

	public InfoProduct() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
}
