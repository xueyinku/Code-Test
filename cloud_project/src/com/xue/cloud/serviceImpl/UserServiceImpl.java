package com.xue.cloud.serviceImpl;

import java.util.List;

import com.xue.cloud.dao.UserDao;
import com.xue.cloud.model.User;
import com.xue.cloud.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public boolean insertUser(User user) {
		// TODO 根据传来的数据，向数据库中增加user
		//1写sql语句
		String sql = "insert into users values(default,?,?,?)";
		return UserDao.update(sql, user.getName(), user.getPassword(), user.getType());
	}

	@Override
	public User checkUser(String name, String password) {
		// TODO 根据传来的数据，查看该运用是否在数据库中，已完成登陆校验
		//写sql语句
		String sql = "select USER_ID,USER_NAME,PASSWORD,USER_TYPE from users where USER_NAME = ? and PASSWORD = ?";
		List<User> query = UserDao.query(sql, name,password);
		if (query != null && query.size() > 0) {
			return query.get(0);
		} else {
			return null;
		}
		
	}

	@Override
	public List<User> seleteAll() { //全查询
		// TODO 
		String sql = "select USER_ID,USER_NAME,PASSWORD,USER_TYPE from users";
		return UserDao.query(sql);
	}

}
