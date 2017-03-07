package me.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dao.UserMapper;
import me.domain.User;
import me.service.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

//	使用@Autowired注解标注userMapper变量
//	当需要使用UserMapper时，Spring就是自动注入UserMapper
	@Autowired
	private UserMapper userMapper;//注入dao
	
	public void addUser(User user) {
		userMapper.insert(user);
	}

	public User getUserById(String userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

	public List<User> getAllUsers() {
		List<User> list = userMapper.getAllUsers();
		return list;
	}

}
