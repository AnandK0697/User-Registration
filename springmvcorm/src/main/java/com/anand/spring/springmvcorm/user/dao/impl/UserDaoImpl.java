package com.anand.spring.springmvcorm.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.anand.spring.springmvcorm.user.dao.UserDao;
import com.anand.spring.springmvcorm.user.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int create(User user) {
		Integer result = (Integer) hibernateTemplate.save(user);
		return result;
	}

	@Override
	public List<User> showAllUsers() {
		List<User> userList = hibernateTemplate.loadAll(User.class);
		return userList;
	}

	@Override
	public User getUser(Integer id) {
		
		User user = hibernateTemplate.get(User.class, id);
		return user;
	}

}
