package com.xue.test.user.serviceimpl;

import java.util.List;

import com.xue.test.user.dao.UserDao;
import com.xue.test.user.service.UserService;

import xom.xue.test.user.model.User;

public class UserServiceImpl implements UserService{

	@Override
	public boolean selectExistName(String name) {
		// TODO 根据账号查询，是否存在
		//第一步写sql语句
		String sql = "select user_id,user_name,user_password from test_user where user_name = ?";
		List<User> query = UserDao.query(sql, name);
		if (query.size() > 0) {
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public boolean insertuser(User user) {
		// TODO 向数据库增加新注册的用户信息
		String sql = "insert into test_user values(default,?,?)";
		return UserDao.update(sql, user.getName(),user.getPassword());
	}

}
