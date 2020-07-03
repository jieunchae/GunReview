package com.mnd.gunreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnd.gunreview.dao.UserLocDAO;
import com.mnd.gunreview.dto.UserLoc;

@Service
public class UserLocServiceImpl implements UserLocService{

	@Autowired
	private UserLocDAO userLocDao;
	
	@Override
	public List<UserLoc> selectUserLoc() {
		return userLocDao.selectUserLoc();
	}

	@Override
	public List<UserLoc> selectUserLocByUserid(String userid) {
		return userLocDao.selectUserLocByUserid(userid);
	}

	@Override
	public int insertUserLoc(UserLoc userloc) {
		return userLocDao.insertUserLoc(userloc);
	}

	@Override
	public int updateUserLoc(UserLoc userloc) {
		return userLocDao.updateUserLoc(userloc);
	}

	@Override
	public int deleteUserLoc(int no) {
		return userLocDao.deleteUserLoc(no);
	}

}
