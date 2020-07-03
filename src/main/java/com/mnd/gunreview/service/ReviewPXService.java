package com.mnd.gunreview.service;

import java.util.List;

import com.mnd.gunreview.dto.ReviewPX;

public interface ReviewPXService {
	public List<ReviewPX> selectReviewByProduct(String review_productname);
	public List<ReviewPX> selectAllReviewByUserId(String review_userid);
	public List<ReviewPX> selectReviewByUserId(String review_userid, String review_productname);
	public int insertReview(ReviewPX review);
	public int updateReview(ReviewPX review);
	public int deleteReview(int no);
}
