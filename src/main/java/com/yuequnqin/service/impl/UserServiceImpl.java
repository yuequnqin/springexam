package com.yuequnqin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.yuequnqin.dao.UserDao;
import com.yuequnqin.domain.User;
import com.yuequnqin.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier(value="userDao")
	private UserDao userDao;
	@Override
	public boolean isUserExist(User user) {
		int isExist=userDao.isUserExist(user);
		if(isExist>0)
			return true;
		return false;
	}

}
