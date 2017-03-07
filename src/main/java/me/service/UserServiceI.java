package me.service;

import java.util.List;

import me.domain.*;

public interface UserServiceI {
	//添加用户
	public void addUser(User user);
	
	//根据用户id获取用户信息
	public User getUserById(String userId);

	//获取所有用户信息
	public List<User> getAllUsers();
}
