package com.mnd.gunreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnd.gunreview.dao.InfoProductDAO;
import com.mnd.gunreview.dao.ReviewPXDAO;
import com.mnd.gunreview.dto.ReviewPX;

@Service
public class ReviewPXServiceImpl implements ReviewPXService {

	@Autowired 
	private ReviewPXDAO reviewPXDao;
	
	@Autowired
	private InfoProductDAO infoProductDao;
	
	@Override
	public List<ReviewPX> selectReviewByProduct(String review_productname) {
		System.out.println(review_productname);
		return reviewPXDao.selectReviewByProduct(review_productname);
	}

	@Override
	public List<ReviewPX> selectAllReviewByUserId(String review_userid) {
		return reviewPXDao.selectAllReviewByUserId(review_userid);
	}
//
//	@Override
//	public List<ReviewPX> selectReviewByUserId(String review_userid, String review_productname) {
//		return reviewPXDao.selectReviewByUserId(review_userid, review_productname);
//	}

	@Override
	public int insertReview(ReviewPX review) {
		return reviewPXDao.insertReview(review);
	}

	@Override
	public int updateReview(ReviewPX review) {
		return reviewPXDao.updateReview(review);
	}

	@Override
	public int deleteReview(int no) {
		return reviewPXDao.deleteReview(no);
	}

	@Override
	public ReviewPX selectReviewByNo(int no) {
		return reviewPXDao.selectReviewByNo(no);
	}

}
