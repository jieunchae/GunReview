package com.mnd.gunreview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mnd.gunreview.dto.User;

@Mapper
public interface UserDAO {
	public int selectReviewsById(String review_userid);
	public List<User> selectUser();
	public User selectUserById(String id);
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(String id);
	public int selectSumReviewsById(String review_userid);
	public int selectCreditById(String review_userid);
}
