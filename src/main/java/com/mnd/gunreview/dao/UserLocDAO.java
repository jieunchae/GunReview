package com.mnd.gunreview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mnd.gunreview.dto.UserLoc;

@Mapper
public interface UserLocDAO {
	public List<UserLoc> selectUserLoc();
	public List<UserLoc> selectUserLocByUserid(String userid);
	public int insertUserLoc(UserLoc userloc);
	public int updateUserLoc(UserLoc userloc);
	public int deleteUserLoc(int no);
}
