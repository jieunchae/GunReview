package com.mnd.gunreview.service;

import java.util.List;

import com.mnd.gunreview.dto.InfoProduct;

public interface InfoProductService {
	public List<InfoProduct> selectAllProduct();
	public InfoProduct selectProductByName(String review_productname);
	public int updateDetail(String name, String detail);
	public int updatePrice(String name, int price);
	
	public int updateSumRate(String review_productname);
	public int updateNum(String review_productname);
	public int updateImg(String review_productname);
}
