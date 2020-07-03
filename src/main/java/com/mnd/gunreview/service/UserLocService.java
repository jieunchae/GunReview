package com.mnd.gunreview.service;

import java.util.List;

import com.mnd.gunreview.dto.UserLoc;

public interface UserLocService {
	public List<UserLoc> selectUserLoc();
	public List<UserLoc> selectUserLocByUserid(String userid);
	public int insertUserLoc(UserLoc userloc);
	public int updateUserLoc(UserLoc userloc);
	public int deleteUserLoc(int no);
}
