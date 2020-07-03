package com.mnd.gunreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnd.gunreview.dao.ReviewShopDAO;
import com.mnd.gunreview.dto.ReviewShop;

@Service
public class ReviewShopServiceImpl implements ReviewShopService{
	
	@Autowired
	private ReviewShopDAO reviewShopDao;
	
	@Override
	public List<ReviewShop> selectReviewShop() {
		return reviewShopDao.selectReviewShop();
	}

	@Override
	public ReviewShop selectReviewShopByNo(int no) {
		return reviewShopDao.selectReviewShopByNo(no);
	}

	@Override
	public int insertReviewShop(ReviewShop review) {
		return reviewShopDao.insertReviewShop(review);
	}

	@Override
	public int updateReviewShop(ReviewShop review) {
		return reviewShopDao.updateReviewShop(review);
	}

	@Override
	public int deleteReviewShop(int no) {
		return reviewShopDao.deleteReviewShop(no);
	}

	@Override
	public List<ReviewShop> selectReviewShopById(String id) {
		return reviewShopDao.selectReviewShopById(id);
	}

}
