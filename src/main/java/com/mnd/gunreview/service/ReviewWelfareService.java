package com.mnd.gunreview.service;

import java.util.List;

import com.mnd.gunreview.dto.ReviewWelfare;

public interface ReviewWelfareService {
	public List<ReviewWelfare> selectReviewWelfare();
	public ReviewWelfare selectReviewWelfareByNo(int no);
	public int insertReviewWelfare(ReviewWelfare review);
	public int updateReviewWelfare(ReviewWelfare review);
	public int deleteReviewWelfare(int no);
	public List<ReviewWelfare> selectReviewWelfareById(String id);
	public List<ReviewWelfare> selectAllReviewByUserId(String userid);
}
