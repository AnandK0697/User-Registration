package com.anand.spring.springmvcorm.user.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anand.spring.springmvcorm.user.dao.UserDao;
import com.anand.spring.springmvcorm.user.entity.User;
import com.anand.spring.springmvcorm.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public int save(User user) {
		return userDao.create(user);
	}

	@Override
	public List<User> showAll() {

		List<User> userList = userDao.showAllUsers();
		Collections.sort(userList);
		return userList;
	}

	@Override
	public User getUser(Integer id) {
		
		return userDao.getUser(id);
	}

}
