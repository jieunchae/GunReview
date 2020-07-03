package com.mnd.gunreview.service;

import java.util.List;

import com.mnd.gunreview.dto.ReviewShop;

public interface ReviewShopService {
	public List<ReviewShop> selectReviewShop();
	public ReviewShop selectReviewShopByNo(int no);
	public int insertReviewShop(ReviewShop review);
	public int updateReviewShop(ReviewShop review);
	public int deleteReviewShop(int no);
	public List<ReviewShop> selectReviewShopById(String id);
}
