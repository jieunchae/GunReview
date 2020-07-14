package com.mnd.gunreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnd.gunreview.dao.ReviewWelfareDAO;
import com.mnd.gunreview.dto.ReviewWelfare;

@Service
public class ReviewWelfareServiceImpl implements ReviewWelfareService{
	
	@Autowired
	private ReviewWelfareDAO reviewWelfareDao;

	@Override
	public List<ReviewWelfare> selectReviewWelfare() {
		return reviewWelfareDao.selectReviewWelfare();
	}

	@Override
	public ReviewWelfare selectReviewWelfareByNo(int no) {
		return reviewWelfareDao.selectReviewWelfareByNo(no);
	}

	@Override
	public int insertReviewWelfare(ReviewWelfare review) {
		return reviewWelfareDao.insertReviewWelfare(review);
	}

	@Override
	public int updateReviewWelfare(ReviewWelfare review) {
		return reviewWelfareDao.updateReviewWelfare(review);
	}

	@Override
	public int deleteReviewWelfare(int no) {
		return reviewWelfareDao.deleteReviewWelfare(no);
	}

	@Override
	public List<ReviewWelfare> selectReviewWelfareById(String id) {
		return reviewWelfareDao.selectReviewWelfareById(id);
	}

	@Override
	public List<ReviewWelfare> selectAllReviewByUserId(String userid) {
		return reviewWelfareDao.selectAllReviewByUserId(userid);
	}
	

}
