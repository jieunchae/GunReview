package com.mnd.gunreview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mnd.gunreview.dto.User;

@Mapper
public interface UserDAO {
	public List<User> selectUser();
	public User selectUserByUserid(String userid);
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(String userid);
}
