package com.mnd.gunreview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mnd.gunreview.dto.ReviewWelfare;

@Mapper
public interface ReviewWelfareDAO {
	public List<ReviewWelfare> selectReviewWelfare();
	public ReviewWelfare selectReviewWelfareByNo(int no);
	public int insertReviewWelfare(ReviewWelfare review);
	public int updateReviewWelfare(ReviewWelfare review);
	public int deleteReviewWelfare(int no);
	public List<ReviewWelfare> selectReviewWelfareById(String id);
	public List<ReviewWelfare> selectAllReviewByUserId(String userid);
}
