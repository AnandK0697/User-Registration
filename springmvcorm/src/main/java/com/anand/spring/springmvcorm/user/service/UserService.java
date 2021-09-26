package com.anand.spring.springmvcorm.user.service;

import java.util.List;

import com.anand.spring.springmvcorm.user.entity.User;

public interface UserService {
	int save(User user);
	List<User> showAll();
	User getUser(Integer id);
	
}
