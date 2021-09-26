package com.anand.spring.springmvcorm.user.dao;

import java.util.List;

import com.anand.spring.springmvcorm.user.entity.User;

public interface UserDao {
	
	int create(User user);
	List<User> showAllUsers();
	User getUser(Integer id);

}
