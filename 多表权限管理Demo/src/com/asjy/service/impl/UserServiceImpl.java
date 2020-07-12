package com.asjy.service.impl;

import java.util.List;

import com.asjy.dao.UserDao;
import com.asjy.model.User;
import com.asjy.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User login(User user) {
		// TODO ��½��֤
		String sql = "select * from tbl_user where user_name = ? and user_password = ?";
		List<User> list = UserDao.query(sql, user.getName(), user.getPassword());
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<User> findUser() {
		// TODO ��ѯ�����û���Ϣ
		String sql = "select * from tbl_user";
		return UserDao.query(sql);
	}

	
}
