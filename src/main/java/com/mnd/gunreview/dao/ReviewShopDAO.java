package com.mnd.gunreview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mnd.gunreview.dto.ReviewShop;

@Mapper
public interface ReviewShopDAO {
	public List<ReviewShop> selectReviewShop();
	public ReviewShop selectReviewShopByNo(int no);
	public int insertReviewShop(ReviewShop review);
	public int updateReviewShop(ReviewShop review);
	public int deleteReviewShop(int no);
	public List<ReviewShop> selectReviewShopById(String id);
	public List<ReviewShop> selectReviewShopByPage(int page);
	public List<ReviewShop> selectReviewShopByIdPage(String id,int page);
	public List<ReviewShop> selectAllReviewByUserId(String review_userid);
}
