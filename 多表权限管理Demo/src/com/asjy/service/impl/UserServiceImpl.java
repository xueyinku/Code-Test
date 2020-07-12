package com.asjy.service.impl;

import java.util.List;

import com.asjy.dao.UserDao;
import com.asjy.model.User;
import com.asjy.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User login(User user) {
		// TODO 登陆验证
		String sql = "select * from tbl_user where user_name = ? and user_password = ?";
		List<User> list = UserDao.query(sql, user.getName(), user.getPassword());
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<User> findUser() {
		// TODO 查询所有用户信息
		String sql = "select * from tbl_user";
		return UserDao.query(sql);
	}

	
}
