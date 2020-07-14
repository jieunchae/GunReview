package com.mnd.gunreview.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mnd.gunreview.dto.ReviewPX;

@Mapper
public interface ReviewPXDAO {
	public List<ReviewPX> selectReviewByProduct(String review_productname);
	public List<ReviewPX> selectAllReviewByUserId(String review_userid);
	public List<ReviewPX> selectReviewByUserId(String review_userid, String review_productname);
	public ReviewPX selectReviewByNo(int no);
	public int insertReview(ReviewPX review);
	public int updateReview(ReviewPX review);
	public int deleteReview(int no);
}
