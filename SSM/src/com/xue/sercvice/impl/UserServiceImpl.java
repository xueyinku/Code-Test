package com.xue.sercvice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xue.dao.UserDao;
import com.xue.model.User;
import com.xue.service.UserService;
@Service//���ú�comnponent����һ������ҵ���ʹ��service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao u1;
	@Override
	public User selectUser(User user) {
		// TODO Auto-generated method stub
		return u1.selectUser(user);
	}

}
