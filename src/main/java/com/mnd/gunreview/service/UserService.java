package com.mnd.gunreview.service;

import java.util.List;

import com.mnd.gunreview.dto.User;

public interface UserService {
	public List<User> selectUser();
	public User selectUserById(String id);
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(String id);
}
